package com.zpark.service;

import java.util.List;

import com.zpark.entity.Template;

/**
 * 
 * ���������
 * 
 * @author��yangdd@zparkhr.com.cn
 * 
 * @create: 2013-7-22 ����11:11:02
 *
 * @version: 1.0
 */
public interface TemplateService {
	/**
	 * ����������:��һ��Template�������ݲ��뵽���ݿ���
	 * 
	 * @return: void
	 */
	public void createTemplate(Template template);

	/**
	 * 
	 * ����������:����id����daoɾ����Ӧ��;������
	 * 
	 * @return: void
	 */
	public void removeTemplate(Integer id);

	/**
	 * 
	 * ����������:��Template���и���
	 * 
	 * @return: void
	 */
	public void modifyTemplate(Template template);

	/**
	 * 
	 * ����������:����id��ö�Ӧ��Template
	 * 
	 * @return: Template
	 */
	public Template showTemplateById(Integer id);
	/**
	 * 
	 * ����������:������е�������Template
	 * 
	 * @return: List<Template>
	 */
	public List<Template> showTemplates();
	/**
	 * ����������:���ĵ���ΪĬ��
	 * @return: void
	 */
	public void SetTemplateDefault(Template template);
	/**
	 * 
	 * ����������:��ģ�����Ϊ����״̬
	 * @return: void
	 */
	public void setTemplateUseable(Integer uSeableTemplateId);
	/**
	 * ����������:����ģ��,ʹ֮������
	 * @return: void
	 */
	public void frozenTemplate(Integer frozenTemplateId);
}
