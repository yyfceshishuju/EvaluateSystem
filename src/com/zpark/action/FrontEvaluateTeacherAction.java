package com.zpark.action;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zpark.entity.Evaluate;
import com.zpark.entity.EvaluateDetail;
import com.zpark.entity.User;
import com.zpark.exception.NotFindTheEvaluationException;
import com.zpark.exception.RepeatSubmitException;
import com.zpark.service.EvaluateDetailTeacherService;
import com.zpark.service.EvaluateDetailZJService;
import com.zpark.service.UserService;
@Controller
@Scope("prototype")
public class FrontEvaluateTeacherAction extends ActionSupport {
	private Logger logger  = Logger.getLogger(FrontEvaluateTeacherAction.class);
	private static final long serialVersionUID = 1L;
	private User user;
	private Evaluate evaluate;
	private EvaluateDetail evaluateDetail;
	private LinkedHashMap<String,String> inputeEvaluateItemDetailMap;
	private LinkedHashMap<String,String> selectEvaluateItemDetailMap;
	private String exceptionMessage;
	private List<String>selectEvaluateItem;
	private List<String>inputEvaluateItem;
	
	@Autowired
	private UserService userService;
	@Autowired
	private EvaluateDetailTeacherService evaluateDetailTeacherService;
	@Autowired
	private EvaluateDetailZJService evaluateDetailZJService;
	
	
	public Logger getLogger() {
		return logger;
	}
	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Evaluate getEvaluate() {
		return evaluate;
	}
	public void setEvaluate(Evaluate evaluate) {
		this.evaluate = evaluate;
	}
	public EvaluateDetail getEvaluateDetail() {
		return evaluateDetail;
	}
	public void setEvaluateDetail(EvaluateDetail evaluateDetail) {
		this.evaluateDetail = evaluateDetail;
	}
	public LinkedHashMap<String, String> getInputeEvaluateItemDetailMap() {
		return inputeEvaluateItemDetailMap;
	}
	public void setInputeEvaluateItemDetailMap(
			LinkedHashMap<String, String> inputeEvaluateItemDetailMap) {
		this.inputeEvaluateItemDetailMap = inputeEvaluateItemDetailMap;
	}
	public LinkedHashMap<String, String> getSelectEvaluateItemDetailMap() {
		return selectEvaluateItemDetailMap;
	}
	public void setSelectEvaluateItemDetailMap(
			LinkedHashMap<String, String> selectEvaluateItemDetailMap) {
		this.selectEvaluateItemDetailMap = selectEvaluateItemDetailMap;
	}
	public String getExceptionMessage() {
		return exceptionMessage;
	}
	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	public List<String> getSelectEvaluateItem() {
		return selectEvaluateItem;
	}
	public void setSelectEvaluateItem(List<String> selectEvaluateItem) {
		this.selectEvaluateItem = selectEvaluateItem;
	}
	public List<String> getInputEvaluateItem() {
		return inputEvaluateItem;
	}
	public void setInputEvaluateItem(List<String> inputEvaluateItem) {
		this.inputEvaluateItem = inputEvaluateItem;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public EvaluateDetailTeacherService getEvaluateDetailTeacherService() {
		return evaluateDetailTeacherService;
	}
	public void setEvaluateDetailTeacherService(
			EvaluateDetailTeacherService evaluateDetailTeacherService) {
		this.evaluateDetailTeacherService = evaluateDetailTeacherService;
	}
	public EvaluateDetailZJService getEvaluateDetailZJService() {
		return evaluateDetailZJService;
	}
	public void setEvaluateDetailZJService(
			EvaluateDetailZJService evaluateDetailZJService) {
		this.evaluateDetailZJService = evaluateDetailZJService;
	}
	/**
	 * 
	 * 
	 * 方法的描述: 收集用户所在班级信息查询教师测评
	 * 
	 * @param @return
	 * @param @throws Exception
	 * 
	 * @return: String
	 * 
	 *
	 */
	public String showUserByCreateDateAndClazz()throws NotFindTheEvaluationException, Exception{
		
		logger.info("[ into showUserByCreateDateAndClazz method]");
		try {
			
			
		this.evaluate=evaluateDetailTeacherService.showEvaluateByCreateDateAndClazz(user.getClazz());
		this.inputEvaluateItem=evaluate.getTemplate().getInputItem();
		this.selectEvaluateItem=evaluate.getTemplate().getSelectItem();
		
		
		logger.debug("=-=-=-=-=-="+evaluate.getTeacher().getTeacherName());
		logger.debug("_+_+_+_+_+_+"+evaluate.getClazz());
		} catch (NotFindTheEvaluationException e) {
			logger.error("[ method showUserByCreateDateAndClazz ]", e);
			this.exceptionMessage=e.getErrorMsg();
			return "NotFindTheEvaluationException";
		}catch(Exception e){
			logger.error("exception",e);
			this.addFieldError("exception", e.getLocalizedMessage());
		}
		logger.debug("[ showUserByCreateDateAndClazz method performs normal ]");
		return "queryTeacherEvaluateSeccess";
	}
	/**
	 * 
	 * 
	 * 方法的描述: 收集学生测评数据入库
	 * 
	 * @param @return
	 * @param @throws Exception
	 * 
	 * @return: String
	 * 
	 *
	 */
	public String createEvaluate()throws RepeatSubmitException, Exception{
		logger.info("[ into createEvaluate method]");
		try {
			logger.debug("当前测评	"+evaluateDetail.getEvaluateId());
			logger.debug("当前教师	"+evaluate.getTeacher().getTeacherName());
			logger.debug("当前班级	"+evaluate.getClazz());
			Integer userId =(Integer) ActionContext.getContext().getSession().get("userId");
			logger.debug("当前学生	"+userId);
			
			evaluateDetailTeacherService.createEvaluateDetail(evaluateDetail,inputeEvaluateItemDetailMap, selectEvaluateItemDetailMap,userId);
		}catch(RepeatSubmitException e){
			logger.error("[ method createEvaluate ]", e);
			this.exceptionMessage=e.getErrorMsg();
			return "RepeatSubmitException";
		} catch (Exception e) {
			logger.error("[ method createEvaluate ]", e);
			this.addFieldError("Exception", e.getLocalizedMessage());
			throw e;
		}
			logger.debug("[ createEvaluate method performs normal ]");
			return "createEvaluateSeccess";
	}
}
