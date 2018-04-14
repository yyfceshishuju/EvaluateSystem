package com.zpark.service;

import com.zpark.entity.Admin;

/**
 * 
 * 类的描述：封装有关管理员的所有的操作
 * 
 * @author：yangdd@zparkhr.com.cn
 * 
 * @create: 2013-7-21 下午5:49:55
 * 
 * @version: 1.0
 */
public interface AdminService {
	/**
	 * 
	 * 方法的描述:根据id查询对应的admin
	 * 
	 * @return: Admin
	 */
	public Admin showAdminById(Integer id);

	/**
	 * 
	 * 方法的描述:根据username查询对应的admin
	 * 
	 * @return: Admin
	 */
	public boolean login(String username,String password);
	/**
	 * 方法的描述:通过id获得当前用户
	 * @return: Admin
	 */
	public Admin queryAdminByUsername(String adminName);
}
