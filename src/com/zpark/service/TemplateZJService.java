package com.zpark.service;

import java.util.List;

import com.zpark.entity.Template;
import com.zpark.entity.ZJTemplate;

public interface TemplateZJService {
	/**
	 * 方法的描述:将一个Template对象数据插入到数据库中
	 * 
	 * @return: void
	 */
	public void createZJTemplate(ZJTemplate zJtemplate);

	/**
	 * 
	 * 方法的描述:根据id调用dao删除对应的;评测项
	 * 
	 * @return: void
	 */
	public void removeZJTemplate(Integer id);

	/**
	 * 
	 * 方法的描述:将Template进行更新
	 * 
	 * @return: void
	 */
	public void modifyZJTemplate(ZJTemplate template);

	/**
	 * 
	 * 方法的描述:根据id获得对应的Template
	 * 
	 * @return: Template
	 */
	public ZJTemplate showZJTemplateById(Integer id);
	/**
	 * 
	 * 方法的描述:获得所有的评测项Template
	 * 
	 * @return: List<Template>
	 */
	public List<ZJTemplate> showZJTemplates();
	/**
	 * 方法的描述:将文档置为默认
	 * @return: void
	 */
	public void SetZJTemplateDefault(ZJTemplate template);
	/**
	 * 
	 * 方法的描述:将模板调整为可用状态
	 * @return: void
	 */
	public void setZJTemplateUseable(Integer uSeableZJTemplateId);
	/**
	 * 方法的描述:冻结模板,使之不可用
	 * @return: void
	 */
	public void frozenZJTemplate(Integer frozenZJTemplateId);
}
