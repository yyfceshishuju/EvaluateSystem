package com.zpark.dao;

import java.util.List;

import com.zpark.entity.Template;
import com.zpark.entity.ZJTemplate;
import com.zpark.entity.ZJTemplateItemLink;

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
public interface TemplateZJDAO {
	/**
	 * 
	 * ����������:��һ��Template���������ݲ��뵽���ݿ���
	 * 
	 * @return: void
	 */
	public void saveZJTemplate(ZJTemplate zJtemplate);

	/**
	 * ����������:����id�����ݿ��ж�Ӧ��Templateɾ��
	 * 
	 * @return: void
	 */
	public void deleteZJTemplate(Integer id);

	/**
	 * 
	 * ����������:�����ݿ���evaluateIte���ݽ��и��²���
	 * 
	 * @return: void
	 */
	public void updateZJTemplate(ZJTemplate zJtemplate);

	/**
	 * ����������:������еĽ�����
	 * 
	 * @return: List<Template>
	 */
	public List<ZJTemplate> queryAllZJTemplate(int pageIndex, int pageMax);

	/**
	 * ����������:����id��ѯ��Ӧ�Ľ�����Template
	 * 
	 * @return: Template
	 */
	public ZJTemplate queryZJTemplateById(Integer id);

	/**
	 * 
	 * ����������:����ģ��ʱά����ϵ��
	 * 
	 * @return: void
	 */
	public void saveZJRelativity(ZJTemplateItemLink zJtemplateItemLink);

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
	public Integer queryZJTemplateMaxRows();
}
