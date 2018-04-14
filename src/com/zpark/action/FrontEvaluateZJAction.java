package com.zpark.action;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zpark.entity.User;
import com.zpark.entity.ZJEvaluate;
import com.zpark.entity.ZJEvaluateDetail;
import com.zpark.exception.NotFindTheEvaluationException;
import com.zpark.exception.RepeatSubmitException;
import com.zpark.service.EvaluateDetailZJService;
import com.zpark.service.UserService;
@Controller
@Scope("prototype")
public class FrontEvaluateZJAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(FrontEvaluateZJAction.class);
	private User user;
	private LinkedHashMap<String,String> inputeEvaluateItemDetailMap;
	private LinkedHashMap<String,String> selectEvaluateItemDetailMap;
	private String exceptionMessage;
	private List<String>selectEvaluateItem;
	private List<String>inputEvaluateItem;
	private ZJEvaluate zjevaluate;
	private ZJEvaluateDetail zjevaluateDetail;
	@Autowired
	private UserService userService;
	@Autowired
	private EvaluateDetailZJService evaluateDetailZJService;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public ZJEvaluate getZjevaluate() {
		return zjevaluate;
	}

	public void setZjevaluate(ZJEvaluate zjevaluate) {
		this.zjevaluate = zjevaluate;
	}

	public ZJEvaluateDetail getZjevaluateDetail() {
		return zjevaluateDetail;
	}

	public void setZjevaluateDetail(ZJEvaluateDetail zjevaluateDetail) {
		this.zjevaluateDetail = zjevaluateDetail;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
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
	 * 方法的描述: 收集用户所在班级信息,展示助教测评数据
	 * 
	 * @param @return
	 * 
	 * @return: String
	 * 
	 *
	 */
	public String showEvaluateZJByCreateDateAndClazz(){
		logger.info("[ into showEvaluateZJByCreateDateAndClazz method]");
		try {
			System.out.println("=========================");
			String userClazz = (String) ActionContext.getContext().getSession().get("userCl");
				this.zjevaluate =evaluateDetailZJService.showEvaluateZJByCreateDateAndClazz(userClazz);
				
				this.inputEvaluateItem=zjevaluate.getZjTemplate().getInputItem();
				this.selectEvaluateItem=zjevaluate.getZjTemplate().getSelectItem();
				ActionContext.getContext().getSession().put("zjevaluateid", zjevaluate.getId());
				
		} catch (NotFindTheEvaluationException e) {
			logger.error("[ method showEvaluateZJByCreateDateAndClazz ]", e);
			this.exceptionMessage=e.getErrorMsg();
			return "NotFindTheEvaluationException";
		}catch(Exception e){
			logger.error("exception",e);
			this.addFieldError("exception", e.getLocalizedMessage());
		}
		logger.debug("[ showEvaluateZJByCreateDateAndClazz method performs normal ]");
		return "queryZJEvaluateSeccess";
	}
		
	public String createZJEvaluate() throws RepeatSubmitException,Exception{
		logger.info("[ into createZJEvaluate method]");
		try {
			logger.debug("当前测评	"+zjevaluateDetail.getZjevaluateId());
			logger.debug("当前助教	"+zjevaluate.getAssistant().getAssistantName());
			logger.debug("当前班级	"+zjevaluate.getClazz());
			Integer userId =(Integer) ActionContext.getContext().getSession().get("userId");
			logger.debug("当前学生	"+userId);
			
			evaluateDetailZJService.createZJEvaluateDetail(zjevaluateDetail,inputeEvaluateItemDetailMap, selectEvaluateItemDetailMap,userId);
		
		
		}catch(RepeatSubmitException e){
			logger.error("[ method createZJEvaluate ]", e);
			this.exceptionMessage=e.getErrorMsg();
			return "RepeatSubmitException";
		} catch (Exception e) {
			logger.error("[ method createZJEvaluate ]", e);
			this.addFieldError("Exception", e.getLocalizedMessage());
			throw e;
		}
			logger.debug("[ createEvaluate method performs normal ]");
			 ActionContext.getContext().getSession().remove("userId");
			return "createZJEvaluateSeccess";
	}
		
	
	
	
	
}
