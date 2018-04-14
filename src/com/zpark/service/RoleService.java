package com.zpark.service;

import com.zpark.entity.Assistant;
import com.zpark.entity.Teacher;

/**
 * 类的描述：用户不同用户的登录后台管理系统的管理
 * 
 * @author：yangdd@zparkhr.com.cn
 * 
 * @create: 2013-7-18 下午6:12:37
 * 
 * @version: 1.0
 */
public interface RoleService {
	/**
	 * 功能：教师登录功能
	 * @param username
	 * @param password
	 * @return
	 */
	public Teacher teacherLogin(String username, String password);
	/**
	 * 功能：助教录功能
	 * @param username
	 * @param password
	 * @return
	 */
	public Assistant assistantLogin(String username, String password);
	/**
	 * 功能：教师密码修改功能
	 * @param id
	 * @param oldpassword
	 * @param newPassword
	 */
	public void teacherModifyPassword(Integer id,String oldPassword,String newPassword);
	/**
	 * 功能：助教密码修改功能
	 * @param id
	 * @param oldPassword
	 * @param newPassword
	 */
	public void assistantModifyPassword(Integer id,String oldPassword,String newPassword);
}
