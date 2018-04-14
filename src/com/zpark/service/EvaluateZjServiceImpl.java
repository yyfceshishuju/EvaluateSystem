package com.zpark.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zpark.dao.EvaluateZjDao;
import com.zpark.dao.TemplateZJDAO;
import com.zpark.entity.Assistant;
import com.zpark.entity.Evaluate;
import com.zpark.entity.EvaluateDetail;
import com.zpark.entity.EvaluateItem;
import com.zpark.entity.SearchBean;
import com.zpark.entity.Template;
import com.zpark.entity.ZJEvaluate;
import com.zpark.entity.ZJEvaluateDetail;
import com.zpark.entity.ZJEvaluateItem;
import com.zpark.entity.ZJTemplate;
import com.zpark.exception.EvaluateDaoException;
import com.zpark.exception.EvaluateServiceException;
import com.zpark.exception.EvaluateZjServiceException;
import com.zpark.util.GenerationDetailUtil;
import com.zpark.util.PageUtil;
/**
 * 
 *  类描述：助教测评的service层
 * @author： qutt@zparkhr.com.cn
 * @时间：2013-8-3，下午02:27:39
 * @version:1.0
 *
 */
@Service
public class EvaluateZjServiceImpl implements EvaluateZjService {
	private static Logger logger = Logger.getLogger(EvaluateZjServiceImpl.class);
	@Autowired
	private EvaluateZjDao evaluateZjDao;
	@Autowired
	private TemplateZJDAO templateZJDAO;
	
	public TemplateZJDAO getTemplateZJDAO() {
		return templateZJDAO;
	}
	public void setTemplateZJDAO(TemplateZJDAO templateZJDAO) {
		this.templateZJDAO = templateZJDAO;
	}
	public EvaluateZjDao getEvaluateZjDao() {
		return evaluateZjDao;
	}
	public void setEvaluateZjDao(EvaluateZjDao evaluateZjDao) {
		this.evaluateZjDao = evaluateZjDao;
	}

	@Override
	@Transactional
	public void createAverageTotalScore(int id) throws Exception {
		logger.debug("[in method evaluateService createAverageTotalScore]");
		List<ZJEvaluateDetail> list = null;
		String stringCommendDetail = "";
		String stringScoreDetail = null;
		double averageTotalSocre = 0;
		 try{
			 list = evaluateZjDao.queryAllEvaluateDetailByEvaluateId(id);
			 if(list == null){
					throw new EvaluateServiceException("活动还没结束，不能产生结果");
			}
			 averageTotalSocre = evaluateZjDao.queryAverageTotalScore(id);
			 DecimalFormat df = new DecimalFormat( "0.000 "); 
			 double score = Double.parseDouble(df.format(averageTotalSocre));
			 if(score == 0){
				 throw new EvaluateZjServiceException("无法生成平均分");
			 }
			 List<String> scoreDetailList = new ArrayList<String>();
			 for(ZJEvaluateDetail ed:list){
				 scoreDetailList.add(ed.getScoreDetail());
			 }
			stringScoreDetail = GenerationDetailUtil.generateCommendDetail(scoreDetailList);
			logger.debug("[create total commendDetail ] "+ stringCommendDetail);
			ZJEvaluate e = new ZJEvaluate();
			e.setId(id);
			e.setCommendDetail(stringCommendDetail);
			e.setTotalScore(averageTotalSocre);
			e.setScoreDetail(stringScoreDetail);
			evaluateZjDao.updateEvaluateTotalScoreAndCommendDetail(e);
		 }catch(Exception e){
			 logger.debug(e.getMessage());
			 throw e;
		 }
	}

	@Override
	@Transactional
	public void createEvaluate(ZJEvaluate evaluate) throws Exception {
		logger.debug("[in EvaluateService method createEvalaute]");
		ZJEvaluate eva = null;
		try{
			eva = evaluateZjDao.queryEvaluateByDateAndClazz(evaluate);
			if(eva == null){
				evaluate.setTotalScore(0.0);
				evaluateZjDao.savaEvaluate(evaluate);
			}else{
				throw new Exception("该班级该日期已经有测评，不能重复生成！");
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
			
		}
	}

	@Override
	@Transactional
	public void modifyEvaluate(ZJEvaluate evaluate) {
		logger.debug("[in EvaluateService method modifyEvaluate]");
		try{
			evaluateZjDao.updateEvaluate(evaluate);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	@Transactional
	public void removeEvaluateById(String deleteId) throws Exception {
		logger.debug("[in EvaluateService method removeEvaluateById]");
		try{
			String[] delId = deleteId.split(",");
			List<Integer> list = new ArrayList<Integer>();
			outter:for(String str:delId){
				int id = Integer.parseInt(str);
				ZJEvaluate e = evaluateZjDao.queryEvaluateDetailByEvaluateId(id);
				Date d = new Date();
				if(((d.getTime()) - (e.getBeginDate().getTime())) > 0 ){
					throw new Exception("xx");
				}
				evaluateZjDao.deleteEvaluateDetailByEvaluateId(id);
				list.add(id);
			}
			evaluateZjDao.deleteEvaluateById(list);
		}catch(Exception e){
			logger.debug(e.getMessage());
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Assistant> showAllAssistant() throws Exception{
		logger.debug("[in method EvaluateService showAllTeacher]");
		List<Assistant>  assistantList = null;
		try{
			assistantList = evaluateZjDao.queryAllAssistant();
			if(assistantList== null || assistantList.size() == 0){
				throw new EvaluateZjServiceException("无教师");
			}
		}catch(EvaluateZjServiceException e){
			e.printStackTrace();
			throw e;
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return assistantList;
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<ZJEvaluate> showAllEvaluate() throws Exception {
		logger.debug("in EvaluateService method showAllEvaluate");
		List<ZJEvaluate> list = null;
		try {
			SearchBean sb = new SearchBean();
			sb.setPage(PageUtil.getFirstResult());
			sb.setRows(PageUtil.getLastResult());
			list = evaluateZjDao.queryAllEvaluate(sb);
			PageUtil.setTotal(evaluateZjDao.queryEvaluateTotalCount());
			if(list == null){
				throw new EvaluateServiceException("无数据");
			}
		} catch (EvaluateDaoException e) {
			logger.debug(e);
			e.printStackTrace();
			throw e;
		}catch(EvaluateServiceException e){
			logger.debug(e);
			throw  e;
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return list;
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<ZJEvaluateDetail> showAllEvaluateDetailsByEvaluateId(int id)
			throws Exception {
		List<ZJEvaluateDetail> list = null;
		try {
			SearchBean sb = new SearchBean();
			sb.setPage(PageUtil.getFirstResult());
			sb.setRows(PageUtil.getLastResult());
			sb.setId(id);
			
			PageUtil.setTotal(evaluateZjDao.queryTotalCountEvaluateDetailByEvaluateId(id));
			list = evaluateZjDao.queryAllEvaluateDetailBySearchBean(sb);
			logger.debug(list.size());
			if(list.size() == 0){
				throw new Exception("无数据");
			}
		} catch (Exception e) {
			logger.debug(e);
			throw e;
		}
		return list;
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<ZJTemplate> showAllTemplate() throws Exception{
		logger.debug("[in EvalauteService method showAllTemplate]");
		List<ZJTemplate> list =null;
		try{
			list = evaluateZjDao.queryAllTempalate();
			if(list == null ||list.size() == 0 ){
				throw new EvaluateZjServiceException("没模板");
			}
		}catch(EvaluateZjServiceException e){
			e.printStackTrace();
			throw e;
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return list;
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)

	public List<ZJEvaluate> showByCondition(SearchBean searchBean) {
		logger.debug("in evalauteServiceImpl showByCondition"+searchBean);
		List<ZJEvaluate> list = null;
		if(searchBean.getCondition().equals("teacherName")){
			searchBean.setPage(PageUtil.getFirstResult());
			searchBean.setRows(PageUtil.getLastResult());
			list = evaluateZjDao.queryEvaluateByTeacherName(searchBean);
			PageUtil.setTotal(evaluateZjDao.queryTotalCountByTeacherName(searchBean));
			
		}
		if(searchBean.getCondition().equals("evaluateTime")){
			searchBean.setPage(PageUtil.getFirstResult());
			searchBean.setRows(PageUtil.getLastResult());
			list = evaluateZjDao.queryEvaluateByEvalauteDate(searchBean);
			PageUtil.setTotal(evaluateZjDao.queryTotalCountByEvaluateDate(searchBean));

		}
		if(searchBean.getCondition().equals("subject")){
			searchBean.setPage(PageUtil.getFirstResult());
			searchBean.setRows(PageUtil.getLastResult());
			list = evaluateZjDao.queryEvaluateBySubject(searchBean);
			PageUtil.setTotal(evaluateZjDao.queryTotalCountBySubject(searchBean));

		}
		if(searchBean.getCondition().equals("studentName")){
			searchBean.setPage(PageUtil.getFirstResult());
			searchBean.setRows(PageUtil.getLastResult());
			list = evaluateZjDao.queryEvaluateByStudentName(searchBean);
			PageUtil.setTotal(evaluateZjDao.queryTotalCountByStudentName(searchBean));

		}
		return list;
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public ZJEvaluate showEvaluateDetailByEvaluateId(int id) throws Exception {
		logger.debug("[ in EvaluateService method showEvaluateDetailByEvaluatgeId]");
		ZJEvaluate zjEvaluate = null;
		zjEvaluate = evaluateZjDao.queryEvaluateDetailByEvaluateId(id);
		Date d = new Date();
		if(((d.getTime()) - (zjEvaluate.getBeginDate().getTime())) > 0 ){
			throw new Exception("xx");
		}
		return zjEvaluate;
	}
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<String> showEvaluateItemDetail(int ZjEvaluteDetailId,
			int zjTemplateId) {
		Map<String,Object> map = new HashMap<String,Object>();
		ZJEvaluateDetail evaluateDetail = evaluateZjDao.queryEvaluteDetailById(ZjEvaluteDetailId);
//		List<ZJEvaluateItem>  evaluteItems = evaluateZjDao.queryEvaluateItemByTemplateId(zjTemplateId);
		List<Integer> scoreList = GenerationDetailUtil.getScoreList(evaluateDetail.getScoreDetail());
		List<String> commentList = GenerationDetailUtil.getCommentList(evaluateDetail.getCommendDetail());
		List<String> strList = new ArrayList<String>();
		ZJTemplate template =templateZJDAO.queryZJTemplateById(zjTemplateId);
		
		List<String> selectItem = new ArrayList<String>();
		List<String> inputItem = new ArrayList<String>();

		for(ZJEvaluateItem e: template.getZjevaluateItems()){
			if(e.getItemCategory().equals("selector")){
				selectItem.add(e.getItemName());
			}else{
				inputItem.add(e.getItemName());
			}
		}
		for(int i = 0; i < selectItem.size();i++){
			strList.add(selectItem.get(i)+" : "+scoreList.get(i));
		}
		for(int j = 0; j <inputItem.size();j++){
			strList.add(inputItem.get(j)+" : "+commentList.get(j));
		}
		for(String str:strList){
			System.out.println(str);
		}
		return strList;
	}
	/**
	 * 方法描述：特定教评中教师每项评价的得分情况
	 * @param evalauteId：教评id
	 *        template:该教评的模板id
	 * @return: 每项教评的平均得分情况
	 */
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<String> showScoreDetail(int evaluteId, int templateId) {
		ZJEvaluate eva = evaluateZjDao.queryEvaluateDetailByEvaluateId(evaluteId);
//		List<ZJEvaluateItem>  evaluteItems = evaluateZjDao.queryEvaluateItemByTemplateId(templateId);
		List<String> scoreDetailList = GenerationDetailUtil.getStringScoreList(eva.getScoreDetail());
		List<String> scoreList = new ArrayList<String>(); 
		List<String> selectItem = new ArrayList<String>();
		ZJTemplate template =templateZJDAO.queryZJTemplateById(templateId);
		for(ZJEvaluateItem e: template.getZjevaluateItems()){
			if(e.getItemCategory().equals("selector")){
				selectItem.add(e.getItemName());
			}
		}
		for(int i = 0; i < scoreDetailList.size();i++){
			scoreList.add(selectItem.get(i)+" : "+scoreDetailList.get(i));
		}	
		return scoreList;
	}
	@Override
	public SearchBean showCommendDetail(int evaluteId, int templateId)
			throws Exception {
		SearchBean sb = new SearchBean();
		List<String> inputItem  = null;
		try {
			//拿到模板中类别为input的测评项
			ZJTemplate template =templateZJDAO.queryZJTemplateById(templateId);
			inputItem = new ArrayList<String>();
			for(ZJEvaluateItem e: template.getZjevaluateItems()){
				if(e.getItemCategory().equals("Input")){
					inputItem.add(e.getItemName());
				}
			}
			//获取每个人的input类别的测评项的内容
			List<ZJEvaluateDetail>  evaluateDetailList = evaluateZjDao.queryAllEvaluateDetailByEvaluateId(evaluteId);
			List<String> list0 = new ArrayList<String>();
			List<String> list1 = new ArrayList<String>();
			for(ZJEvaluateDetail detail :evaluateDetailList){
				List <String> commendList = GenerationDetailUtil.getCommentList(detail.getCommendDetail());
				String str0 = commendList.get(0);
				String str1 = commendList.get(1);
				if(!("无".equals(str0))){
					list0.add(str0);
				}
				if(!("无".equals(str1))){
					list1.add(str1);
				}
			}
			for(String str:list0){
				System.out.println("1-------"+str);
			}
			for(String str:list1){
				System.out.println("2-------"+str);
			}
			sb.setInputItem(inputItem);
			sb.setCommend1(list0);
			sb.setCommend2(list1);
		} catch (EvaluateDaoException e) {
			e.printStackTrace();
			logger.debug(e.getMessage());
			throw new EvaluateServiceException("dao 层错误");
		}catch(EvaluateServiceException e){
			e.printStackTrace();
			logger.debug(e.getMessage());
			throw e;
		}catch(Exception e){
			e.printStackTrace();
			logger.debug(e.getMessage());
			throw e;
		}
		return sb;
	}
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<ZJEvaluateDetail> showExportEvaluateDetailsByEvaluateId(int id)
			throws Exception {
		List<ZJEvaluateDetail> list = new ArrayList<ZJEvaluateDetail>();
		try{
			list = evaluateZjDao.queryAllEvaluateDetailByEvaluateId(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<ZJEvaluate> showEvaluatZJByEvaluateId(int id) throws Exception {
		logger.debug("[ in EvaluateService method showEvaluatZJByEvaluateId]");
		List<ZJEvaluate> zjEvaluates = null;
		try {
			zjEvaluates = new ArrayList<ZJEvaluate>();
			 ZJEvaluate zjEvaluate = evaluateZjDao.queryEvaluateDetailByEvaluateId(id);
			 zjEvaluates.add(zjEvaluate);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		 return zjEvaluates;
	}
}
