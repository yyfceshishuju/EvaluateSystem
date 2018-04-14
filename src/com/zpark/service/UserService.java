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
 * �������:�������û�ҵ��
 *
 *@author: wangyx@zparkhr.com.cn
 *
 * @create: 2013-7-15����9:52:07
 *
 *	@version 1.0
 */
public interface UserService {
	
	/**
	 * 
	 * ����������: �����û���¼����֤
	 * 
	 * @param @param username 
	 * @param @param password 	
	 * @param @return 
	 * 
	 * @return: User ���ص�¼���û�
	 * 
	 */
   public User showUserByUsername(String userName,String password)throws UserNameAndPasswordException,Exception;
   
   /**
    * 
    * ����������: �����û���ע��
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
    * ����������: �һ��û���¼����
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
