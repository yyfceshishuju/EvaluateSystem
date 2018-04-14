package com.zpark.dao;

import java.util.List;

import com.zpark.entity.Template;
import com.zpark.entity.TemplateItemLink;

/**
 * 
 * �����������װ�йؽ���������ݿ����
 * 
 * @author��yangdd@zparkhr.com.cn
 * 
 * @create: 2013-7-18 ����4:41:57
 * 
 * @version: 1.0
 */
public interface TemplateDAO {
	/**
	 * 
	 * ����������:��һ��Template���������ݲ��뵽���ݿ���
	 * 
	 * @return: void
	 */
	public void saveTemplate(Template template);

	/**
	 * ����������:����id�����ݿ��ж�Ӧ��Templateɾ��
	 * 
	 * @return: void
	 */
	public void deleteTemplate(Integer id);

	/**
	 * 
	 * ����������:�����ݿ���evaluateIte���ݽ��и��²���
	 * 
	 * @return: void
	 */
	public void updateTemplate(Template template);

	/**
	 * ����������:������еĽ�����
	 * 
	 * @return: List<Template>
	 */
	public List<Template> queryAllTemplate(int pageIndex, int pageMax);

	/**
	 * ����������:����id��ѯ��Ӧ�Ľ�����Template
	 * 
	 * @return: Template
	 */
	public Template queryTemplateById(Integer id);

	/**
	 * 
	 * ����������:����ģ��ʱά����ϵ��
	 * 
	 * @return: void
	 */
	public void saveRelativity(TemplateItemLink templateItemLink);

	// public void saveRelativity(Map<Integer,Integer> map);
	/**
	 * ����������:���ģ���еĵ�ǰ����
	 * 
	 * @return: Integer
	 */
	public Integer queryId();

	/**
	 * ����������:��ѯ���ܹ��ж�����ģ��
	 * 
	 * @return: Integer
	 */
	public Integer queryTemplateMaxRows();
}
