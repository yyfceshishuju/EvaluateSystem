package com.zpark.service;

import com.zpark.entity.Assistant;
import com.zpark.entity.Teacher;

/**
 * ����������û���ͬ�û��ĵ�¼��̨����ϵͳ�Ĺ���
 * 
 * @author��yangdd@zparkhr.com.cn
 * 
 * @create: 2013-7-18 ����6:12:37
 * 
 * @version: 1.0
 */
public interface RoleService {
	/**
	 * ���ܣ���ʦ��¼����
	 * @param username
	 * @param password
	 * @return
	 */
	public Teacher teacherLogin(String username, String password);
	/**
	 * ���ܣ�����¼����
	 * @param username
	 * @param password
	 * @return
	 */
	public Assistant assistantLogin(String username, String password);
	/**
	 * ���ܣ���ʦ�����޸Ĺ���
	 * @param id
	 * @param oldpassword
	 * @param newPassword
	 */
	public void teacherModifyPassword(Integer id,String oldPassword,String newPassword);
	/**
	 * ���ܣ����������޸Ĺ���
	 * @param id
	 * @param oldPassword
	 * @param newPassword
	 */
	public void assistantModifyPassword(Integer id,String oldPassword,String newPassword);
}
