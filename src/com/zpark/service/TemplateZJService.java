package com.zpark.service;

import java.util.List;

import com.zpark.entity.Template;
import com.zpark.entity.ZJTemplate;

public interface TemplateZJService {
	/**
	 * ����������:��һ��Template�������ݲ��뵽���ݿ���
	 * 
	 * @return: void
	 */
	public void createZJTemplate(ZJTemplate zJtemplate);

	/**
	 * 
	 * ����������:����id����daoɾ����Ӧ��;������
	 * 
	 * @return: void
	 */
	public void removeZJTemplate(Integer id);

	/**
	 * 
	 * ����������:��Template���и���
	 * 
	 * @return: void
	 */
	public void modifyZJTemplate(ZJTemplate template);

	/**
	 * 
	 * ����������:����id��ö�Ӧ��Template
	 * 
	 * @return: Template
	 */
	public ZJTemplate showZJTemplateById(Integer id);
	/**
	 * 
	 * ����������:������е�������Template
	 * 
	 * @return: List<Template>
	 */
	public List<ZJTemplate> showZJTemplates();
	/**
	 * ����������:���ĵ���ΪĬ��
	 * @return: void
	 */
	public void SetZJTemplateDefault(ZJTemplate template);
	/**
	 * 
	 * ����������:��ģ�����Ϊ����״̬
	 * @return: void
	 */
	public void setZJTemplateUseable(Integer uSeableZJTemplateId);
	/**
	 * ����������:����ģ��,ʹ֮������
	 * @return: void
	 */
	public void frozenZJTemplate(Integer frozenZJTemplateId);
}
