package com.zpark.dao;

import java.util.List;

import com.zpark.entity.ZJTemplateItemLink;

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
public interface TemplateItemLinkZJDAO {
	/**
	 * 
	 * ����������:����itemId��ѯ��Ӧ��TemplateItemLink����
	 * 
	 * @return: Admin
	 */
	public List<ZJTemplateItemLink> queryByItemId(Integer itemId);
	/**
	 * 
	 * ����������:����templateId��ѯ��Ӧ��TemplateItemLink����
	 * 
	 * @return: Admin
	 */
	//public TemplateItemLink queryByTemplateId(Integer templateId);
	/**
	 * ����������:����ģ��idɾ����ϵ��
	 * @return: void
	 */
	public void deleteByZJTemplateId(Integer templateId);
	
}
