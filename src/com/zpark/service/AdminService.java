package com.zpark.service;

import com.zpark.entity.Admin;

/**
 * 
 * �����������װ�йع���Ա�����еĲ���
 * 
 * @author��yangdd@zparkhr.com.cn
 * 
 * @create: 2013-7-21 ����5:49:55
 * 
 * @version: 1.0
 */
public interface AdminService {
	/**
	 * 
	 * ����������:����id��ѯ��Ӧ��admin
	 * 
	 * @return: Admin
	 */
	public Admin showAdminById(Integer id);

	/**
	 * 
	 * ����������:����username��ѯ��Ӧ��admin
	 * 
	 * @return: Admin
	 */
	public boolean login(String username,String password);
	/**
	 * ����������:ͨ��id��õ�ǰ�û�
	 * @return: Admin
	 */
	public Admin queryAdminByUsername(String adminName);
}
