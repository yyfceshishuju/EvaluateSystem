package com.zpark.service;

import java.util.List;

import com.zpark.entity.Template;

/**
 * 
 * 类的描述：
 * 
 * @author：yangdd@zparkhr.com.cn
 * 
 * @create: 2013-7-22 上午11:11:02
 *
 * @version: 1.0
 */
public interface TemplateService {
	/**
	 * 方法的描述:将一个Template对象数据插入到数据库中
	 * 
	 * @return: void
	 */
	public void createTemplate(Template template);

	/**
	 * 
	 * 方法的描述:根据id调用dao删除对应的;评测项
	 * 
	 * @return: void
	 */
	public void removeTemplate(Integer id);

	/**
	 * 
	 * 方法的描述:将Template进行更新
	 * 
	 * @return: void
	 */
	public void modifyTemplate(Template template);

	/**
	 * 
	 * 方法的描述:根据id获得对应的Template
	 * 
	 * @return: Template
	 */
	public Template showTemplateById(Integer id);
	/**
	 * 
	 * 方法的描述:获得所有的评测项Template
	 * 
	 * @return: List<Template>
	 */
	public List<Template> showTemplates();
	/**
	 * 方法的描述:将文档置为默认
	 * @return: void
	 */
	public void SetTemplateDefault(Template template);
	/**
	 * 
	 * 方法的描述:将模板调整为可用状态
	 * @return: void
	 */
	public void setTemplateUseable(Integer uSeableTemplateId);
	/**
	 * 方法的描述:冻结模板,使之不可用
	 * @return: void
	 */
	public void frozenTemplate(Integer frozenTemplateId);
}
