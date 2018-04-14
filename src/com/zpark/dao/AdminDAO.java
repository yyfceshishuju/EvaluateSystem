package com.zpark.dao;

import com.zpark.entity.Admin;

/**
 * 
 * �����������װ�й�Admin��һ�����ݿ����
 * 
 * @author��yangdd@zparkhr.com.cn
 * 
 * @create: 2013-7-18 ����4:35:35
 * 
 * @version: 1.0
 */
public interface AdminDAO {
	/**
	 * 
	 * ����������:����id��ѯ��Ӧ��Admin����
	 * 
	 * @return: Admin
	 */
	public Admin queryAdminById(Integer id);

	/**
	 * 
	 * ����������:����username��ѯ��Ӧ��Admin����
	 * 
	 * @return: Admin
	 */
	public Admin queryAdminByUsername(String username);
}
