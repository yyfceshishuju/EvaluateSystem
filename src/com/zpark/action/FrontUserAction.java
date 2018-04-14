package com.zpark.action;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zpark.entity.User;
import com.zpark.exception.UserNameAndPasswordException;
import com.zpark.service.UserService;
@Controller
@Scope("prototype")

/**
 * 
 * 
 * 类的描述: 收集数据处理用户注册、登录、密码找回、功能跳转
 *
 *@author: wangyx@zparkhr.com.cn
 *
 * @create: 2013-8-5下午9:06:40
 *
 *	@version 1.0
 */
public class FrontUserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(FrontUserAction.class);
	private User user;
	private String exceptionMessage;
	


	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Autowired
	private UserService userService;
	
	
	public String login()throws UserNameAndPasswordException,Exception {
		logger.info("[ into login method]");
			try {
				this.user=userService.showUserByUsername(user.getName(),user.getPassword());
				ActionContext.getContext().getSession().put("userId", user.getId());
				ActionContext.getContext().getSession().put("userCl", user.getClazz());

				logger.debug("[ login method performs normal ]");
				return "showUserByCreateDateAndClazz";
				
				
				} catch (UserNameAndPasswordException e) {
				logger.error("[ method showUserByUsernameAndPassword ]", e);
				this.exceptionMessage=e.getErrorMsg();
				return "UserNameAndPasswordException";
			}catch (Exception e) {
				logger.error("[ method Exception ]", e);
				this.addFieldError("exception", e.getLocalizedMessage());
				throw e;
		}
	}
	
	/**
	 * 
	 * 方法的描述: 用户的注册
	 * 
	 * @param @return
	 * @param @throws Exception action一旦出错,则抛出Exception
	 * 
	 * @return: String 用于跳转
	 * 
	 *
	 */
	public String register()throws Exception {
				logger.info("[ into register method]");
			try {
				
				userService.createUser(user);
			}catch(UserNameAndPasswordException e){
				logger.error("[ method register ]", e);
				this.exceptionMessage=e.getErrorMsg();
				return "UserNameAndQuestionRepeat";
				
			} catch (Exception e) {
				
				logger.error("[ method register ]", e);
				this.addFieldError("exception", e.getLocalizedMessage());
				throw e;
			}
		logger.debug("[ register method performs normal ]");
		return "registerSuccess";
	}
	/**
	 * 
	 * 
	 * 方法的描述: 收集用户提交的密码提示问题与答案查询用户
	 * 
	 * @param @return
	 * @param @throws Exception
	 * 
	 * @return: String
	 * 
	 *
	 */
	public String showUserByPasswordQuestion()throws Exception{
		logger.info("[ into showUserByPasswordQuestion method]");
		try {
		this.user =userService.showUserByPasswordQuestion(user);
		
		}catch(UserNameAndPasswordException e){
			this.exceptionMessage=e.getErrorMsg();
			return "PasswordQuestionAndPasswordAnswerException";
		} catch (Exception e) {
			logger.error("[ method showUserByPasswordQuestionr ]", e);
			this.addFieldError("exception", e.getLocalizedMessage());
			throw e;
		}
			logger.debug("[ showUserByPasswordQuestion method performs normal ]");
		return "showSeccess";
	}
	
	
}
