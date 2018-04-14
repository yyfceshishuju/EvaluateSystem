package com.zpark.service;

import java.util.LinkedHashMap;

import com.zpark.entity.Evaluate;
import com.zpark.entity.EvaluateDetail;
import com.zpark.entity.User;
import com.zpark.entity.ZJEvaluate;
import com.zpark.entity.ZJEvaluateDetail;
import com.zpark.exception.NotFindTheEvaluationException;
import com.zpark.exception.RepeatSubmitException;
import com.zpark.exception.UserNameAndPasswordException;


/**
 * 
 * 类的描述:负责处理用户业务
 *
 *@author: wangyx@zparkhr.com.cn
 *
 * @create: 2013-7-15下午9:52:07
 *
 *	@version 1.0
 */
public interface UserService {
	
	/**
	 * 
	 * 方法的描述: 用于用户登录的验证
	 * 
	 * @param @param username 
	 * @param @param password 	
	 * @param @return 
	 * 
	 * @return: User 返回登录的用户
	 * 
	 */
   public User showUserByUsername(String userName,String password)throws UserNameAndPasswordException,Exception;
   
   /**
    * 
    * 方法的描述: 用于用户的注册
    * 
    * @param @param user
    * 
    * @return: void
    * 
    *
    */
   public void createUser(User user) throws Exception;
   
   /**
    * 
    * 
    * 
    * 方法的描述: 找回用户登录密码
    * 
    * @param @param user
    * @param @return
    * @param @throws Exception
    * 
    * @return: User
    * 
    *
    */
   public User showUserByPasswordQuestion(User user) throws UserNameAndPasswordException,Exception;


   	
  
}
