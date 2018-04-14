package com.zpark.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zpark.entity.Admin;
import com.zpark.entity.Assistant;
import com.zpark.entity.SearchBean;
import com.zpark.entity.ZJEvaluate;
import com.zpark.entity.ZJEvaluateDetail;
import com.zpark.entity.ZJEvaluateDetail;
import com.zpark.entity.ZJEvaluateItem;
import com.zpark.entity.ZJTemplate;
import com.zpark.exception.EvaluateZjServiceException;
import com.zpark.service.EvaluateZjService;
import com.zpark.util.EasyUI;
/**
 * 
 *  �����������̲�����action��
 * @author�� qutt@zparkhr.com.cn
 * @ʱ�䣺2013-8-3������03:43:33
 * @version:1.0
 *
 */
@Controller
@Scope("prototype")
public class EvaluateZjAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private EvaluateZjService evaluateZjService;
	private static Logger logger = Logger.getLogger(EvaluateZjAction.class);
	private int id;
	private int assistantId;
	private int templateId;
	private int evaluateId;
	private ZJEvaluate zjEvaluate;
	private String deleteId;
	private String msg;
	private String tag;
	private SearchBean searchBean;
	private List<ZJEvaluateItem> evaluateItemList = new ArrayList<ZJEvaluateItem>();
	@EasyUI
	private List<ZJEvaluate> evaluateList = new ArrayList<ZJEvaluate>();
	@EasyUI
	private List<ZJEvaluateDetail> evaluateDetails = new ArrayList<ZJEvaluateDetail>();
	
	public EvaluateZjService getEvaluateZjService() {
		return evaluateZjService;
	}
	public void setEvaluateZjService(EvaluateZjService evaluateZjService) {
		this.evaluateZjService = evaluateZjService;
	}
	
	public int getEvaluateId() {
		return evaluateId;
	}
	public void setEvaluateId(int evaluateId) {
		this.evaluateId = evaluateId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAssistantId() {
		return assistantId;
	}
	public void setAssistantId(int assistantId) {
		this.assistantId = assistantId;
	}
	public int getTemplateId() {
		return templateId;
	}
	public void setTemplateId(int templateId) {
		this.templateId = templateId;
	}
	public ZJEvaluate getZjEvaluate() {
		return zjEvaluate;
	}
	public void setZjEvaluate(ZJEvaluate zjEvaluate) {
		this.zjEvaluate = zjEvaluate;
	}
	public String getDeleteId() {
		return deleteId;
	}
	public void setDeleteId(String deleteId) {
		this.deleteId = deleteId;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public SearchBean getSearchBean() {
		return searchBean;
	}
	public void setSearchBean(SearchBean searchBean) {
		this.searchBean = searchBean;
	}
	public List<ZJEvaluateItem> getEvaluateItemList() {
		return evaluateItemList;
	}
	public void setEvaluateItemList(List<ZJEvaluateItem> evaluateItemList) {
		this.evaluateItemList = evaluateItemList;
	}
	public List<ZJEvaluate> getEvaluateList() {
		return evaluateList;
	}
	public void setEvaluateList(List<ZJEvaluate> evaluateList) {
		this.evaluateList = evaluateList;
	}
	public List<ZJEvaluateDetail> getEvaluateDetails() {
		return evaluateDetails;
	}
	public void setEvaluateDetails(List<ZJEvaluateDetail> evaluateDetails) {
		this.evaluateDetails = evaluateDetails;
	}
	/**
	 * 
	 * ������������ѯ���еĽ���
	 * @return ��ת·�����߼�����
	 * 
	 */
	public String showAllEvaluate(){
		logger.debug(" [in EvaluateZjAction method showAllEvaluate] ");
		try {
			evaluateList = evaluateZjService.showAllEvaluate();
			for(ZJEvaluate e : evaluateList){
			logger.debug("showAllEvaluate size is "+ e.getTotalScore()+e.getAssistant());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "showOk";
	}
	/**
	 * 
	 * ��������������һ��������Ϣ
	 * @return ��ת·�����߼�����
	 */
	@SuppressWarnings("unchecked")
	public String createEvaluate(){
		logger.debug("[in method evalauteService createEvaluate]");
		try {
			Assistant assistant = new Assistant();
			assistant.setId(assistantId);
			ZJTemplate template = new ZJTemplate();
			template.setId(templateId);
			Admin admin = new Admin();
			Map session = ActionContext.getContext().getSession();
			admin.setId((Integer)session.get("nowAdminId"));
			zjEvaluate.setAdmin(admin);
			zjEvaluate.setAssistant(assistant);
			zjEvaluate.setCreateDate(new Date());
			zjEvaluate.setZjTemplate(template);
			evaluateZjService.createEvaluate(zjEvaluate);
			msg = "�����ɹ�";
		} catch (Exception e) {
			logger.debug(e.getMessage());
			msg = e.getMessage();
			return ERROR;
		}
		return "createEvaluateOk";
	}
	
	/**
	 * 
	 * ���������� ���ݽ���id��ѯ��������ϸ��Ϣ
	 * @return ��ת·�����߼�����
	 */
	@SuppressWarnings("unchecked")
	public String showEvaluateDetail(){
		logger.debug("[in EvaluateAction method showEvaluateDetail]"+id);
		try {
			List<ZJTemplate> templateList = new ArrayList<ZJTemplate>();
			List<Assistant> assistantList = new ArrayList<Assistant>();
			templateList = evaluateZjService.showAllTemplate();
			assistantList = evaluateZjService.showAllAssistant();
			Map requestMap = (Map) ActionContext.getContext().get("request");
			requestMap.put("templateList", templateList);
			requestMap.put("teacherList", assistantList);
			
			zjEvaluate = evaluateZjService.showEvaluateDetailByEvaluateId(id);
		} catch (Exception e) {
			msg = "��Ѿ���ʼ���������޸�";
		 return ERROR;
		}
		return "showEvaluateDetailOk";
	}
	/**
	 * �������������ݽ���id ��ѯ���еĽ������ڼ���
	 * @return  ��ת·�����߼�����
	 */
	public String showEvaluateDetails(){
		logger.debug("[in EvaluateAction method showEvaluateDetail]"+id);
		try {
			logger.debug(tag+"-----");
			evaluateDetails = evaluateZjService.showAllEvaluateDetailsByEvaluateId(id);
			if(tag.equals("a")){
				return "showEvaluateDetailsOk";
			}
			logger.debug(evaluateDetails.size()+"===detailSize");
		} catch (Exception e) {
			msg = e.getMessage();
			return ERROR;
		}
		return "showEvaluateDetailsOk";
	}
	
	/**
	 * 
	 * ����������������Ϣ���޸�
	 * @return  ��ת·�����߼�����
	 */
				 
	public String  modifyEvaluate(){
		logger.debug("[in EvaluateAction method modidyEvaluate]");
		
		evaluateZjService.modifyEvaluate(zjEvaluate);
		msg = "�޸ĳɹ�";
		logger.debug("[in evalauteAction method modifyEvaluate ok]");
		return "modifyOkEvalaute";
	}
	/**
	 * 
	 * ����������ɾ��������Ϣ
	 * @return ��ת·�����߼�����
	 */
	public String removeEvaluateByEvaluateId(){
		logger.debug("[in EvaluateAction method removeEvaluate]");
		try {
			evaluateZjService.removeEvaluateById(deleteId);
		} catch (Exception e) {
			msg = "������ɾ��";
			return "error";
		}
		return "removeEvalauteOk";
	}
	
	/**
	 * 
	 * ��������:��ѯ���е�ģ��
	 * @return ��ת·�����߼�����
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public String showAllTemplateAndTeacher() throws Exception{
		logger.debug("[in method evaluateAction showAllTemplate]");
		List<ZJTemplate> templateList = new ArrayList<ZJTemplate>();
		List<Assistant> assistantList = new ArrayList<Assistant>();
		Map requestMap = (Map) ActionContext.getContext().get("request");
		try {
			templateList = evaluateZjService.showAllTemplate();
			assistantList = evaluateZjService.showAllAssistant();
			requestMap.put("templateList", templateList);
			requestMap.put("teacherList", assistantList);
		} catch (EvaluateZjServiceException e) {
			msg = "��ʱ�޷�����ģ��";
			return "error";
		}
		return "showAllTemplateOk";
	}
	/**
	 *  ��������������������ѯ����
	 *  @param:��ת·�����߼�����
	 */
	public String showByCondition(){
		logger.debug(searchBean.getContent()+"----------");
		String str =searchBean.getContent(); 
		logger.debug("in evaluateAction method showByCondition"+ str);
		evaluateList = evaluateZjService.showByCondition(searchBean);
		return "showByConditionOk";
	}
	/**
	 * �������������ɽ�ʦ��������ƽ����
	 * @return ��ת·�����߼�����
	 */
	public String createAverageTotalScore(){
		logger.debug("[in method EvaluateAction createAverageTotalScore]");
		try {
			evaluateZjService.createAverageTotalScore(id);
		} catch (Exception e) {
			msg = "��ʱ�޷����ɽ��";
			return ERROR;
		}
		return "createEvaluateResultOk";
	}
	/**
	 * ���������� ��ѯ������Ĵ�����
	 * @return ��ת·�����߼�����
	 */
	@SuppressWarnings("unchecked")
	public String showEvaluateItemDetail(){
		List<String> evaluateItem = evaluateZjService.showEvaluateItemDetail(id, templateId);
		Map requestMap = (Map) ActionContext.getContext().get("request");
		requestMap.put("evaluateItem", evaluateItem);
		return "showEvaluateItemOk";
	}

	public String showScoreDetail(){
		List<String> evaluateScoreDetail = evaluateZjService.showScoreDetail(id, templateId);		
		Map requestMap = (Map) ActionContext.getContext().get("request");
		requestMap.put("evaluateScoreDetail", evaluateScoreDetail);
		return "showScoreDetailOk";
	}
	
	@SuppressWarnings({ "unchecked", "unchecked" })
	public String showCommendDetail(){
		try {
			logger.debug("in EvaluateAction method showCommendDetail");
			SearchBean  commendDetails  = evaluateZjService.showCommendDetail(id, templateId);	
			Map requestMap = (Map) ActionContext.getContext().get("request");
			List<String> inputItem = commendDetails.getInputItem();
			List<String> commend1 = commendDetails.getCommend1();
			List<String> commend2 = commendDetails.getCommend2();
			requestMap.put("inputItem", inputItem);
			requestMap.put("commend1", commend1);
			requestMap.put("commend2", commend2);
		} catch (Exception e) {
			logger.debug(e.getMessage());
			return "systemError";
		}
		return "showCommendDetailOk";
	}
}
