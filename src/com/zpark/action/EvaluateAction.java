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
import com.zpark.entity.Evaluate;
import com.zpark.entity.EvaluateDetail;
import com.zpark.entity.EvaluateItem;
import com.zpark.entity.SearchBean;
import com.zpark.entity.Teacher;
import com.zpark.entity.Template;
import com.zpark.exception.EvaluateServiceException;
import com.zpark.service.EvaluateService;
import com.zpark.util.EasyUI;
/**
 * 
 * 类的描述：教评的action
 * @author qutt@zparkhr.com.cn
 * @time 2013-7-19 上午10:46:53
 * @version 1.1
 */
@Controller
@Scope("prototype")
public class EvaluateAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	@Autowired
	private EvaluateService evaluateService;
	private static Logger logger = Logger.getLogger(EvaluateAction.class);
	private int id;
	private int evaluateId;
	private int teacherId;
	private int templateId;
	private Evaluate evaluate;
	private String deleteId;
	private String msg;
	private String tag;
	private SearchBean searchBean;
	private String clazz;
	
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	private List<EvaluateItem> evaluateItemList = new ArrayList<EvaluateItem>();
	@EasyUI
	private List<Evaluate> evaluateList = new ArrayList<Evaluate>();
	@EasyUI
	private List<EvaluateDetail> evaluateDetails = new ArrayList<EvaluateDetail>();
	
	 public List<EvaluateDetail> getEvaluateDetails() {
		return evaluateDetails;
	}
	public void setEvaluateDetails(List<EvaluateDetail> evaluateDetails) {
		this.evaluateDetails = evaluateDetails;
	}
	public SearchBean getSearchBean() {
		return searchBean;
	}
	public void setSearchBean(SearchBean searchBean) {
		this.searchBean = searchBean;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public int getEvaluateId() {
		return evaluateId;
	}
	public void setEvaluateId(int evaluateId) {
		this.evaluateId = evaluateId;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getDeleteId() {
		return deleteId;
	}
	public void setDeleteId(String deleteId) {
		this.deleteId = deleteId;
	}
	public int getTemplateId() {
		return templateId;
	}
	public void setTemplateId(int templateId) {
		this.templateId = templateId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public EvaluateService getEvaluateSerivice() {
		return evaluateService;
	}
	public void setEvaluateSerivice(EvaluateService evaluateSerivice) {
		this.evaluateService = evaluateSerivice;
	}
	public List<Evaluate> getEvaluateList() {
		return evaluateList;
	}
	public void setEvaluateList(List<Evaluate> evaluateList) {
		this.evaluateList = evaluateList;
	}
	public List<EvaluateItem> getEvaluateItemList() {
		return evaluateItemList;
	}
	public void setEvaluateItemList(List<EvaluateItem> evaluateItemList) {
		this.evaluateItemList = evaluateItemList;
	}
	public Evaluate getEvaluate() {
		return evaluate;
	}
	public void setEvaluate(Evaluate evaluate) {
		this.evaluate = evaluate;
	}
	public EvaluateService getEvaluateService() {
		return evaluateService;
	}
	public void setEvaluateService(EvaluateService evaluateService) {
		this.evaluateService = evaluateService;
	}

	/**
	 * 
	 * 方法描述：查询所有的教评
	 * @return 跳转路径的逻辑名称
	 * 
	 */
	public String showAllEvaluate(){
		logger.debug(" [in EvaluateAction method showAllEvaluate] ");
		try {
			evaluateList = evaluateService.showAllEvaluate();
			for(Evaluate e : evaluateList){
			logger.debug("showAllEvaluate size is "+ e.getTotalScore());
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
			return "systemError";
		}
		return "showOk";
	}
	/**
	 * 
	 * 方法描述：创建一条教评信息
	 * @return 跳转路径的逻辑名称
	 */
	public String createEvaluate(){
		logger.debug("[in method evalauteService createEvaluate]");
		try {
			Teacher teacher = new Teacher();
			teacher.setId(teacherId);
			Template template = new Template();
			template.setId(templateId);
			Admin admin = new Admin();
			Map session = ActionContext.getContext().getSession();
			admin.setId((Integer)session.get("nowAdminId"));
			evaluate.setAdmin(admin);
			evaluate.setTeacher(teacher);
			evaluate.setCreateDate(new Date());
			evaluate.setTemplate(template);
			evaluateService.createEvaluate(evaluate);
			msg = "创建成功";
		} catch (Exception e) {
			logger.debug(e.getMessage());
			msg = "创建失败";
			return ERROR;
		}
		return "createEvaluateOk";
	}
	
	/**
	 * 
	 * 方法描述： 根据教评id查询教评的详细信息
	 * @return 跳转路径的逻辑名称
	 */
	@SuppressWarnings("unchecked")
	public String showEvaluateDetail(){
		logger.debug("[in EvaluateAction method showEvaluateDetail]"+id);
		try {
			List<Template> templateList = new ArrayList<Template>();
			List<Teacher> teacherList = new ArrayList<Teacher>();
			templateList = evaluateService.showAllTemplate();
			teacherList = evaluateService.showAllTeacher();
			Map requestMap = (Map) ActionContext.getContext().get("request");
			requestMap.put("templateList", templateList);
			requestMap.put("teacherList", teacherList);
			evaluate = evaluateService.showEvaluateDetailByEvaluateId(id);
		} catch (EvaluateServiceException e) {
			msg = "活动已经开始，不允许修改";
			return ERROR;
		}catch(Exception e){
			logger.debug(e.getMessage());
			return "systemError";
		}
		return "showEvaluateDetailOk";
	}
	/**
	 * 方法描述：根据教评id 查询所有的教评星期集合
	 * @return  跳转路径的逻辑名称
	 */
	public String showEvaluateDetails(){
		logger.debug("[in EvaluateAction method showEvaluateDetail]"+id);
		try {
			logger.debug(tag+"-----");
			evaluateDetails = evaluateService.showAllEvaluateDetailsByEvaluateId(id);
			if(tag.equals("a")){
				return "showEvaluateDetailsOk";
			}
			logger.debug(evaluateDetails.size()+"===detailSize");
		} catch (EvaluateServiceException e) {
			msg = e.getMessage();
			return ERROR;
		}catch(Exception e){
			logger.debug(e.getMessage());
			return "systemError";
		}
		return "showEvaluateDetailsOk";
	}
	
	/**
	 * 
	 * 方法描述：教评信息的修改
	 * @return  跳转路径的逻辑名称
	 */
				 
	public String  modifyEvaluate(){
		logger.debug("[in EvaluateAction method modidyEvaluate]");
		try {
			evaluateService.modifyEvaluate(evaluate);
			logger.debug("[in evalauteAction method modifyEvaluate ok]");
			msg = "修改成功";
		} catch (Exception e) {
			logger.debug(e.getMessage());
			return "systemError";
		}
		
		return "modifyOkEvalaute";
	}
	/**
	 * 
	 * 方法描述：删除教评信息
	 * @return 跳转路径的逻辑名称
	 */
	public String removeEvaluateByEvaluateId(){
		logger.debug("[in EvaluateAction method removeEvaluate]");
		try {
			evaluateService.removeEvaluateById(deleteId);
		} catch (EvaluateServiceException e) {
			msg = "不允许删除";
			return "error";
		} catch (Exception e) {
			logger.debug(e.getMessage());
			return "systemError";
		}
		
		return "removeEvalauteOk";
	}
	
	/**
	 * 
	 * 方法描述:查询所有的模板
	 * @return 跳转路径的逻辑名称
	 */
	@SuppressWarnings("unchecked")
	public String showAllTemplateAndTeacher(){
		logger.debug("[in method evaluateAction showAllTemplate]");
		List<Template> templateList = new ArrayList<Template>();
		List<Teacher> teacherList = new ArrayList<Teacher>();
		try {
			templateList = evaluateService.showAllTemplate();
			teacherList = evaluateService.showAllTeacher();
			Map requestMap = (Map) ActionContext.getContext().get("request");
			requestMap.put("templateList", templateList);
			requestMap.put("teacherList", teacherList);
		}catch(EvaluateServiceException e){
			msg = "暂时无法生成模板";
			return "error";
		}catch (Exception e){
			logger.debug(e.getMessage());
			return "systemError";
		}
		return "showAllTemplateOk";
	}
	/**
	 *  方法描述：根据条件查询教评
	 *  @param:跳转路径的逻辑名称
	 */
	@SuppressWarnings("unchecked")
	public String showByCondition(){
		logger.debug("in evaluateAction method showByCondition"+ searchBean.getContent()+"----------"+searchBean.getCondition());
		try {
			evaluateList = evaluateService.showByCondition(searchBean);
		} catch (Exception e) {
			logger.debug(e.getMessage());
			return "systemError";
		}
		return "showByConditionOk";
	}
	/**
	 * 方法描述：生成教师测评的总平均分
	 * @return 跳转路径的逻辑名称
	 */
	public String createAverageTotalScore(){
		logger.debug("[in method EvaluateAction createAverageTotalScore]");
		try {
			evaluateService.createAverageTotalScore(id);
		} catch (Exception e) {
			msg = "暂时无法生成结果";
			return ERROR;
		} 
		return "createEvaluateResultOk";
	}
	/**
	 * 方法描述： 查询测评项的打分情况
	 * @return 跳转路径的逻辑名称
	 */
	@SuppressWarnings("unchecked")
	public String showEvaluateItemDetail(){
		try {
			List<String> evaluateItem = evaluateService.showEvaluateItemDetail(id, templateId);
			Map requestMap = (Map) ActionContext.getContext().get("request");
			requestMap.put("evaluateItem", evaluateItem);
		} catch (Exception e) {
			logger.debug(e.getMessage());
			return "systemError";
		}
		return "showEvaluateItemOk";
	}
	
	public String showScoreDetail(){
		try {
			List<String> evaluateScoreDetail = evaluateService.showScoreDetail(id, templateId);		
			Map requestMap = (Map) ActionContext.getContext().get("request");
			requestMap.put("evaluateScoreDetail", evaluateScoreDetail);
		} catch (Exception e) {
			logger.debug(e.getMessage());
			return "systemError";
		}
		return "showScoreDetailOk";
	}
	public String showCommendDetail(){
		try {
			logger.debug("in EvaluateAction method showCommendDetail");
			SearchBean  commendDetails  = evaluateService.showCommendDetail(id, templateId);	
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
