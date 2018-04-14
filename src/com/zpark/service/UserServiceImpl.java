package com.zpark.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zpark.dao.EvaluateDetailDAO;
import com.zpark.dao.EvaluateDetailZJDAO;
import com.zpark.dao.TemplateDAO;
import com.zpark.dao.TemplateZJDAO;
import com.zpark.dao.UserDAO;
import com.zpark.entity.Evaluate;
import com.zpark.entity.EvaluateDetail;
import com.zpark.entity.EvaluateItem;
import com.zpark.entity.Template;
import com.zpark.entity.User;
import com.zpark.entity.ZJEvaluate;
import com.zpark.entity.ZJEvaluateDetail;
import com.zpark.entity.ZJEvaluateItem;
import com.zpark.entity.ZJTemplate;
import com.zpark.exception.NotFindTheEvaluationException;
import com.zpark.exception.RepeatSubmitException;
import com.zpark.exception.UserNameAndPasswordException;
import com.zpark.util.GenerationDetailUtil;

@Service
public class UserServiceImpl implements UserService {
    private static Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private EvaluateDetailDAO evaluateDetailDAO;
	@Autowired
	private TemplateDAO templateDAO;
	@Autowired
	private EvaluateDetailZJDAO evaluateDetailZJDAO;
	@Autowired
	private TemplateZJDAO templatezjDAO;
	@Autowired
	
	public TemplateZJDAO getTemplatezjDAO() {
		return templatezjDAO;
	}

	public void setTemplatezjDAO(TemplateZJDAO templatezjDAO) {
		this.templatezjDAO = templatezjDAO;
	}

	public TemplateDAO getTemplateDAO() {
		return templateDAO;
	}

	public void setTemplateDAO(TemplateDAO templateDAO) {
		this.templateDAO = templateDAO;
	}




	public EvaluateDetailZJDAO getEvaluateDetailZJDAO() {
		return evaluateDetailZJDAO;
	}

	public void setEvaluateDetailZJDAO(EvaluateDetailZJDAO evaluateDetailZJDAO) {
		this.evaluateDetailZJDAO = evaluateDetailZJDAO;
	}

	public EvaluateDetailDAO getEvaluateDetailDAO() {
		return evaluateDetailDAO;
	}

	public void setEvaluateDetailDAO(EvaluateDetailDAO evaluateDetailDAO) {
		this.evaluateDetailDAO = evaluateDetailDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public User showUserByUsername(String userName,String password) throws Exception {
		try {
			logger.info("[into findUserByUsernameAndPassword method]");
			
			User	user =userDAO.queryUserByUsername(userName);
			if(user==null){
				logger.debug("-----�û������-----");
				throw new UserNameAndPasswordException("�û����������");
			}else{
				
				if(!user.getPassword().equals(password)){
					logger.debug("-----�������-----");
					throw new UserNameAndPasswordException("�����������");
				}
			}
			logger.debug("[ findUserByUsernameAndPassword method performs normal ]");

			return user;
		} catch (UserNameAndPasswordException e) {
            logger.error("[ method findUserByUsernameAndPassword ]", e);
            throw e;
		}catch(Exception e){
			logger.error("[ method findUserByUsernameAndPassword ]", e);
			throw e;
		}
	}

	@Transactional(rollbackFor=java.lang.RuntimeException.class)
	public void createUser(User user) throws UserNameAndPasswordException, Exception{
		
		try{
		logger.info("[into createUser method]");
				//��ѯ�û����Ƿ����
				User un =userDAO.queryUserByUsername(user.getName());
				//��ѯ�û���ip�Լ�Cookie�Ƿ����
				HttpServletRequest request=ServletActionContext.getRequest();
				 String ip = request.getHeader("x-forwarded-for");
			        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			            ip = request.getHeader("Proxy-Client-IP");
			        }
			        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			            ip = request.getHeader("WL-Proxy-Client-IP");
			        }
			        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			            ip = request.getRemoteAddr();
			        }
			        
				Cookie[] cookie =  request.getCookies();
//			if(cookie!=null){
//				for (Cookie cok : cookie) {
//					if(cok.getName().equals("users")){
//						throw new UserNameAndPasswordException("�벻Ҫ�ظ�ע��");
//					}
//				}
//			}
				User ui = userDAO.queryUserByIp(ip);
				if(ui!=null){
					
					throw new UserNameAndPasswordException("用户名已存在");
				}
				if(un==null){
					Cookie coo = new Cookie("users",ip);
					//����COOKIE1��
					coo.setMaxAge(60*60*24);
					
					ServletActionContext.getResponse().addCookie(coo);
					
					user.setIp(ip);
					userDAO.saveUser(user);
					}else{
					logger.debug("-----�û����Ѵ���-----");
					throw new UserNameAndPasswordException("用户名已存在");
					
				}
		}catch(UserNameAndPasswordException e){
			logger.error("[ method createUser ]",e);
			throw e;
		}catch(Exception e){
			logger.error("[ method createUser ]",e);
			throw e;
		}
		logger.info("[ createUser method performs normal ]");
	}
		
		@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
		public User showUserByPasswordQuestion(User user) throws UserNameAndPasswordException, Exception {
			logger.info("[ into findUserByPasswordQuestion  ]");
			
			try{
				logger.debug("userPasswordAnswer is ---"+user.getPasswordAnswer());
				User u = userDAO.queryUserByUsername(user.getName());
				if(u==null){
					throw new UserNameAndPasswordException("用户名错误");
				} 
				
				if(!u.getPasswordQuestion().equals(user.getPasswordQuestion())){
						throw new UserNameAndPasswordException("提示问题不相符");
				} 
				
				if(!u.getPasswordAnswer().equals(user.getPasswordAnswer())){
					throw new UserNameAndPasswordException("密码问题答案不相符");
				}
					
				logger.info("[ createUser method performs normal ]");
				return u;
			}catch(UserNameAndPasswordException e){
				logger.error("method findUserByPasswordQuestion",e);
				throw e;
			}catch(Exception e){
				logger.error("method findUserByPasswordQuestion",e);
				throw e;
			}
			
			
		
	}
		
			
}

