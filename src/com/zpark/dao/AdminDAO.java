package com.zpark.dao;

import com.zpark.entity.Admin;

/**
 * 
 * 类的描述：封装有关Admin的一切数据库操作
 * 
 * @author：yangdd@zparkhr.com.cn
 * 
 * @create: 2013-7-18 下午4:35:35
 * 
 * @version: 1.0
 */
public interface AdminDAO {
	/**
	 * 
	 * 方法的描述:根据id查询对应的Admin对象
	 * 
	 * @return: Admin
	 */
	public Admin queryAdminById(Integer id);

	/**
	 * 
	 * 方法的描述:根据username查询对应的Admin对象
	 * 
	 * @return: Admin
	 */
	public Admin queryAdminByUsername(String username);
}
