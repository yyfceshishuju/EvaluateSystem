package com.zpark.service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zpark.dao.EvaluateDao;
import com.zpark.dao.TemplateDAO;
import com.zpark.entity.Evaluate;
import com.zpark.entity.EvaluateDetail;
import com.zpark.entity.EvaluateItem;
import com.zpark.entity.SearchBean;
import com.zpark.entity.Teacher;
import com.zpark.entity.Template;
import com.zpark.entity.User;
import com.zpark.exception.EvaluateDaoException;
import com.zpark.exception.EvaluateServiceException;
import com.zpark.util.GenerationDetailUtil;
import com.zpark.util.PageUtil;
@Service
public class EvaluateServiceImpl implements EvaluateService {

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(EvaluateServiceImpl.class);
	@Autowired
	private EvaluateDao evaluateDao;
	@Autowired
	private TemplateDAO templateDAO;
	
	public TemplateDAO getTemplateDAO() {
		return templateDAO;
	}
	public void setTemplateDAO(TemplateDAO templateDAO) {
		this.templateDAO = templateDAO;
	}
	public EvaluateDao getEvaluateDao() {
		return evaluateDao;
	}
	public void setEvaluateDao(EvaluateDao evaluateDao) {
		this.evaluateDao = evaluateDao;
	}
	/**
	 * 
	 * 方法描述：查询所有的教评
	 * @return 教评的list集合
	 * @throws EvaluateDaoException
	 */
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Evaluate> showAllEvaluate() throws Exception{
		logger.debug("in EvaluateService method showAllEvaluate");
		List<Evaluate> list = null;
		try {
			SearchBean sb = new SearchBean();
			sb.setPage(PageUtil.getFirstResult());
			sb.setRows(PageUtil.getLastResult());
//			sb.setPage(1);
//			sb.setRows(10);
			list = evaluateDao.queryAllEvaluate(sb);
			PageUtil.setTotal(evaluateDao.queryEvaluateTotalCount());
			if(list == null){
				throw new EvaluateServiceException("无数据");
			}
		} catch (EvaluateDaoException e) {
			logger.debug(e.getMessage());
			e.printStackTrace();
			throw new EvaluateServiceException("dao 层错误");
		}catch(EvaluateServiceException e){
			logger.debug(e.getMessage());
			throw  e;
		}catch(Exception e){
			logger.debug(e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return list;
	}
	
	/**
	 * 
	 * 方法描述：根据教评id查询教评的详细信息
	 * @param id 教评id
	 * @return 当前教评
	 * @throws EvaluateDaoException
	 */
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Evaluate showEvaluateDetailByEvaluateId(int id)
			throws Exception {
		logger.debug("[ in EvaluateService method showEvaluateDetailByEvaluatgeId]");
		Evaluate evaluate = null;
		try {
			evaluate = evaluateDao.queryEvaluateDetailByEvaluateId(id);
			Date d = new Date();
			if(((d.getTime()) - (evaluate.getBeginDate().getTime())) > 0 ){
				throw new EvaluateServiceException("还没结束，不能看到详细信息");
			}
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
		return evaluate;
	}
	
	
	
	/**
	 * 
	 * 方法描述：更新教评信息
	 * @param evaluate 更新的信息
	 */
	@Override
	@Transactional
	public void modifyEvaluate(Evaluate evaluate) throws Exception{
		logger.debug("[in EvaluateService method modifyEvaluate]");
		try{
			evaluateDao.updateEvaluate(evaluate);
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
	}
	/**
	 * 
	 * 方法描述：删除教评信息
	 * @param id 教评id
	 */
	@Override
	@Transactional
	public void removeEvaluateById(String deleteId) throws Exception{
		logger.debug("[in EvaluateService method removeEvaluateById]");
		try{
			String[] delId = deleteId.split(",");
			List<Integer> list = new ArrayList<Integer>();
			for(String str:delId){
				int id = Integer.parseInt(str);
				Evaluate e = evaluateDao.queryEvaluateDetailByEvaluateId(id);
				Date d = new Date();
				if(((d.getTime()) - (e.getBeginDate().getTime())) > 0 ){
					throw new EvaluateServiceException("活动已经开始，不能删除");
				}
				evaluateDao.deleteEvaluateDetailByEvaluateId(id);
				list.add(id);
			}
			evaluateDao.deleteEvaluateById(list);
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
	}
	/**
	 * 
	 * 方法描述：插入一条教评信息
	 * @param evaluate 插入信息
	 */
	@Override 
	@Transactional
	public void createEvaluate(Evaluate evaluate) throws Exception{
		logger.debug("[in EvaluateService method createEvalaute]");
		Evaluate eva = null;
		try{
			eva = evaluateDao.queryEvaluateByDateAndClazz(evaluate);
			if(eva == null){
				evaluate.setTotalScore(0.0);
				evaluateDao.savaEvaluate(evaluate);
			}else{
				throw new EvaluateServiceException("该班级该日期已经有测评，不能重复生成！");
			}
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
	}
	
	/**
	 * 
	 * 方法描述： 查询所有的模板
	 * @return 所有模板的集合
	 */
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Template> showAllTemplate()throws Exception {
		logger.debug("[in EvalauteService method showAllTemplate]");
		List<Template> list =null;
		try{
			list = evaluateDao.queryAllTempalate();
			logger.debug(list);
			if(list == null ||list.size() == 0){
				throw new EvaluateServiceException("没有模板");
			}
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
		return list;
	}
	/**
	 * 	方法描述：查询所有的老师
	 * @return 返回所有老师集合
	 */
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Teacher> showAllTeacher() throws Exception{
		logger.debug("[in method EvaluateService showAllTeacher]");
		List<Teacher>  teacherList = null;
		try{
			teacherList = evaluateDao.queryAllTeacher();
			if(teacherList == null || teacherList.size() == 0){
				throw  new EvaluateServiceException("无老师");
			}
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
		return teacherList;
	}
	@Override
	/**方法描述：根据条件查询教评信息
	 * @param: 封装查询信息
	 * @return 返回查询结果集
	 */
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Evaluate> showByCondition(SearchBean searchBean) throws Exception{
		logger.debug("in evalauteServiceImpl showByCondition"+searchBean);
		List<Evaluate> list = null;
		try {
			if(searchBean.getCondition().equals("teacherName")){
				searchBean.setPage(PageUtil.getFirstResult());
				searchBean.setRows(PageUtil.getLastResult());
				list = evaluateDao.queryEvaluateByTeacherName(searchBean);
				PageUtil.setTotal(evaluateDao.queryTotalCountByTeacherName(searchBean));	
			}
			if(searchBean.getCondition().equals("evaluateTime")){
				searchBean.setPage(PageUtil.getFirstResult());
				searchBean.setRows(PageUtil.getLastResult());
				list = evaluateDao.queryEvaluateByEvalauteDate(searchBean);
				PageUtil.setTotal(evaluateDao.queryTotalCountByEvaluateDate(searchBean));
			}
			if(searchBean.getCondition().equals("subject")){
				searchBean.setPage(PageUtil.getFirstResult());
				searchBean.setRows(PageUtil.getLastResult());
				list = evaluateDao.queryEvaluateBySubject(searchBean);
				PageUtil.setTotal(evaluateDao.queryTotalCountBySubject(searchBean));
			}
			if(searchBean.getCondition().equals("studentName")){
				searchBean.setPage(PageUtil.getFirstResult());
				searchBean.setRows(PageUtil.getLastResult());
				list = evaluateDao.queryEvaluateByStudentName(searchBean);
				PageUtil.setTotal(evaluateDao.queryTotalCountByStudentName(searchBean));
			}
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
		return list;
	}
	@Override
	/**
	 * 方法描述：生成教评的平均分
	 * @params:  教评id
	 */
	@Transactional
	public void createAverageTotalScore(int id) throws Exception {
		logger.debug("[in method evaluateService createAverageTotalScore]");
		List<EvaluateDetail> list = null;
		String stringCommendDetail = "";
		String stringScoreDetail = null;
		double averageTotalSocre = 0;
		 try{
		//	 Evaluate eva = evaluateDao.queryEvaluateDetailByEvaluateId(id);
			 list = evaluateDao.queryAllEvaluateDetailByEvaluateId(id);
			 if(list == null){
					throw new EvaluateServiceException("活动还没结束，不能产生结果");
			}
			 averageTotalSocre = evaluateDao.queryAverageTotalScore(id);
			 DecimalFormat df = new DecimalFormat( "0.000 "); 
			 double score = Double.parseDouble(df.format(averageTotalSocre));
			 if(score == 0){
				 throw new EvaluateServiceException("无法生成平均分");
			 }
			 logger.debug(score);
			 List<String> scoreDetailList = new ArrayList<String>();
			 for(EvaluateDetail ed:list){
				 scoreDetailList.add(ed.getScoreDetail());
			 }
			 stringScoreDetail = GenerationDetailUtil.generateCommendDetail(scoreDetailList);
			Evaluate e = new Evaluate();
			e.setId(id);
			e.setCommendDetail(stringCommendDetail);
			e.setTotalScore(score);
			e.setScoreDetail(stringScoreDetail);
			evaluateDao.updateEvaluateTotalScoreAndCommendDetail(e);
		 } catch (EvaluateDaoException e) {
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
	}
	
	/**
	 * 方法描述：根据教评id查询对应的教评详情集合
	 * @param: 教评id
	 * @return: 教评详情集合
	 */
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<EvaluateDetail> showAllEvaluateDetailsByEvaluateId(int id) throws Exception {
		List<EvaluateDetail> list = null;
		try {
			SearchBean sb = new SearchBean();
			sb.setPage(PageUtil.getFirstResult());
			sb.setRows(PageUtil.getLastResult());
			sb.setId(id);
			PageUtil.setTotal(evaluateDao.queryTotalCountEvaluateDetailByEvaluateId(id));
			list = evaluateDao.queryAllEvaluateDetailBySearchBean(sb);
			logger.debug(list.size());
			if(list.size() == 0){
				throw new EvaluateServiceException("无数据");
			}
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
		return list;
	}
	/**
	 * 方法描述：根据教评id 和模板id 查询教评打分情况和评价情况
	 * @param  返回学生打分情况的集合
	 */
	@Override
	@Transactional
	public List<String> showEvaluateItemDetail(int evaluateDetailId,int templateId) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		List<String> strList = null;;
		try {
			//教评详细表
			EvaluateDetail evaluateDetail = evaluateDao.queryEvaluteDetailById(evaluateDetailId);
			//教评项
			//List<EvaluateItem>  evaluteItems = evaluateDao.queryEvaluateItemByTemplateId(templateId);
			List<Integer> scoreList = GenerationDetailUtil.getScoreList(evaluateDetail.getScoreDetail());
			List<String> commentList = GenerationDetailUtil.getCommentList(evaluateDetail.getCommendDetail());
			strList = new ArrayList<String>();
			Template template =templateDAO.queryTemplateById(templateId);
			List<String> selectItem = new ArrayList<String>();
			List<String> inputItem = new ArrayList<String>();
			for(EvaluateItem e: template.getEvaluateItems()){
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
	public List<String> showScoreDetail(int evaluteId, int templateId) throws Exception {
		List<String> scoreList = null;
		try {
			Evaluate eva = evaluateDao.queryEvaluateDetailByEvaluateId(evaluteId);
			List<String> scoreDetailList = GenerationDetailUtil.getStringScoreList(eva.getScoreDetail());
			Template template =templateDAO.queryTemplateById(templateId);
			List<String> selectItem = new ArrayList<String>();
			scoreList = new ArrayList<String>(); 
			for(EvaluateItem e: template.getEvaluateItems()){
				if(e.getItemCategory().equals("selector")){
					selectItem.add(e.getItemName());
				}
			}
			for(int i = 0; i < selectItem.size();i++){
				scoreList.add(selectItem.get(i)+" : "+scoreDetailList.get(i));
			}
			for(String str:scoreList){
				System.out.println(str);
			}
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
		return scoreList;
	}
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public SearchBean showCommendDetail(int evaluteId, int templateId)
			throws Exception {
		logger.debug("in evaluateServiceImpl method  showCommendDetail"+evaluteId);
		SearchBean sb = new SearchBean();
		List<String> inputItem  = null;
		try {
			//拿到模板中类别为input的测评项
			Template template =templateDAO.queryTemplateById(templateId);
			inputItem = new ArrayList<String>();
			for(EvaluateItem e: template.getEvaluateItems()){
				if(e.getItemCategory().equals("Input")){
					inputItem.add(e.getItemName());
				}
			}
			//获取每个人的input类别的测评项的内容
			List<EvaluateDetail>  evaluateDetailList = evaluateDao.queryAllEvaluateDetailByEvaluateId(evaluteId);
			List<String> list0 = new ArrayList<String>();
			List<String> list1 = new ArrayList<String>();
			for(EvaluateDetail detail :evaluateDetailList){
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
	public List<EvaluateDetail> showExportEvaluateDetailsByEvaluateId(int id)
			throws Exception {
		List<EvaluateDetail> list = new ArrayList<EvaluateDetail>();
		try{
			list = evaluateDao.queryAllEvaluateDetailByEvaluateId(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 方法描述：根据班级号查询用户集合
	 */
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<User> showUserByClazz(String clazz) throws Exception {
		List<User> list = new ArrayList<User>();
		try{
			list = evaluateDao.queryUserByClass(clazz);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Evaluate> showEvaluateByEvaluateId(int id) throws Exception {
		logger.debug("[ in EvaluateService method showEvaluateByEvaluateId]");
		List<Evaluate> evaluates = new ArrayList<Evaluate>();
		try {
			Evaluate evaluate = evaluateDao.queryEvaluateDetailByEvaluateId(id);
			evaluates.add(evaluate);
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
		return evaluates;
	}
}
