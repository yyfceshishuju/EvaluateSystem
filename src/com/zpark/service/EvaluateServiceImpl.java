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
	 * ������������ѯ���еĽ���
	 * @return ������list����
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
				throw new EvaluateServiceException("������");
			}
		} catch (EvaluateDaoException e) {
			logger.debug(e.getMessage());
			e.printStackTrace();
			throw new EvaluateServiceException("dao �����");
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
	 * �������������ݽ���id��ѯ��������ϸ��Ϣ
	 * @param id ����id
	 * @return ��ǰ����
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
				throw new EvaluateServiceException("��û���������ܿ�����ϸ��Ϣ");
			}
		} catch (EvaluateDaoException e) {
			e.printStackTrace();
			logger.debug(e.getMessage());
			throw new EvaluateServiceException("dao �����");
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
	 * �������������½�����Ϣ
	 * @param evaluate ���µ���Ϣ
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
			throw new EvaluateServiceException("dao �����");
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
	 * ����������ɾ��������Ϣ
	 * @param id ����id
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
					throw new EvaluateServiceException("��Ѿ���ʼ������ɾ��");
				}
				evaluateDao.deleteEvaluateDetailByEvaluateId(id);
				list.add(id);
			}
			evaluateDao.deleteEvaluateById(list);
		} catch (EvaluateDaoException e) {
			e.printStackTrace();
			logger.debug(e.getMessage());
			throw new EvaluateServiceException("dao �����");
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
	 * ��������������һ��������Ϣ
	 * @param evaluate ������Ϣ
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
				throw new EvaluateServiceException("�ð༶�������Ѿ��в����������ظ����ɣ�");
			}
		} catch (EvaluateDaoException e) {
			e.printStackTrace();
			logger.debug(e.getMessage());
			throw new EvaluateServiceException("dao �����");
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
	 * ���������� ��ѯ���е�ģ��
	 * @return ����ģ��ļ���
	 */
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Template> showAllTemplate()throws Exception {
		logger.debug("[in EvalauteService method showAllTemplate]");
		List<Template> list =null;
		try{
			list = evaluateDao.queryAllTempalate();
			logger.debug(list);
			if(list == null ||list.size() == 0){
				throw new EvaluateServiceException("û��ģ��");
			}
		} catch (EvaluateDaoException e) {
			e.printStackTrace();
			logger.debug(e.getMessage());
			throw new EvaluateServiceException("dao �����");
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
	 * 	������������ѯ���е���ʦ
	 * @return ����������ʦ����
	 */
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Teacher> showAllTeacher() throws Exception{
		logger.debug("[in method EvaluateService showAllTeacher]");
		List<Teacher>  teacherList = null;
		try{
			teacherList = evaluateDao.queryAllTeacher();
			if(teacherList == null || teacherList.size() == 0){
				throw  new EvaluateServiceException("����ʦ");
			}
		} catch (EvaluateDaoException e) {
			e.printStackTrace();
			logger.debug(e.getMessage());
			throw new EvaluateServiceException("dao �����");
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
	/**��������������������ѯ������Ϣ
	 * @param: ��װ��ѯ��Ϣ
	 * @return ���ز�ѯ�����
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
			throw new EvaluateServiceException("dao �����");
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
	 * �������������ɽ�����ƽ����
	 * @params:  ����id
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
					throw new EvaluateServiceException("���û���������ܲ������");
			}
			 averageTotalSocre = evaluateDao.queryAverageTotalScore(id);
			 DecimalFormat df = new DecimalFormat( "0.000 "); 
			 double score = Double.parseDouble(df.format(averageTotalSocre));
			 if(score == 0){
				 throw new EvaluateServiceException("�޷�����ƽ����");
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
				throw new EvaluateServiceException("dao �����");
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
	 * �������������ݽ���id��ѯ��Ӧ�Ľ������鼯��
	 * @param: ����id
	 * @return: �������鼯��
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
				throw new EvaluateServiceException("������");
			}
		} catch (EvaluateDaoException e) {
			e.printStackTrace();
			logger.debug(e.getMessage());
			throw new EvaluateServiceException("dao �����");
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
	 * �������������ݽ���id ��ģ��id ��ѯ�������������������
	 * @param  ����ѧ���������ļ���
	 */
	@Override
	@Transactional
	public List<String> showEvaluateItemDetail(int evaluateDetailId,int templateId) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		List<String> strList = null;;
		try {
			//������ϸ��
			EvaluateDetail evaluateDetail = evaluateDao.queryEvaluteDetailById(evaluateDetailId);
			//������
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
			throw new EvaluateServiceException("dao �����");
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
	 * �����������ض������н�ʦÿ�����۵ĵ÷����
	 * @param evalauteId������id
	 *        template:�ý�����ģ��id
	 * @return: ÿ�������ƽ���÷����
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
			throw new EvaluateServiceException("dao �����");
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
			//�õ�ģ�������Ϊinput�Ĳ�����
			Template template =templateDAO.queryTemplateById(templateId);
			inputItem = new ArrayList<String>();
			for(EvaluateItem e: template.getEvaluateItems()){
				if(e.getItemCategory().equals("Input")){
					inputItem.add(e.getItemName());
				}
			}
			//��ȡÿ���˵�input���Ĳ����������
			List<EvaluateDetail>  evaluateDetailList = evaluateDao.queryAllEvaluateDetailByEvaluateId(evaluteId);
			List<String> list0 = new ArrayList<String>();
			List<String> list1 = new ArrayList<String>();
			for(EvaluateDetail detail :evaluateDetailList){
				List <String> commendList = GenerationDetailUtil.getCommentList(detail.getCommendDetail());
				String str0 = commendList.get(0);
				String str1 = commendList.get(1);
				if(!("��".equals(str0))){
					list0.add(str0);
				}
				if(!("��".equals(str1))){
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
			throw new EvaluateServiceException("dao �����");
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
	 * �������������ݰ༶�Ų�ѯ�û�����
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
			throw new EvaluateServiceException("dao �����");
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
