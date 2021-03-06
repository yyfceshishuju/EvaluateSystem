package com.zpark.dao;

import java.util.List;

import com.zpark.entity.Template;
import com.zpark.entity.TemplateItemLink;

/**
 * 
 * 类的描述：封装有关教评项的数据库操作
 * 
 * @author：yangdd@zparkhr.com.cn
 * 
 * @create: 2013-7-18 下午4:41:57
 * 
 * @version: 1.0
 */
public interface TemplateDAO {
	/**
	 * 
	 * 方法的描述:将一个Template教评项内容插入到数据库中
	 * 
	 * @return: void
	 */
	public void saveTemplate(Template template);

	/**
	 * 方法的描述:根据id将数据库中对应的Template删除
	 * 
	 * @return: void
	 */
	public void deleteTemplate(Integer id);

	/**
	 * 
	 * 方法的描述:将数据库中evaluateIte数据进行更新操作
	 * 
	 * @return: void
	 */
	public void updateTemplate(Template template);

	/**
	 * 方法的描述:获得所有的教评项
	 * 
	 * @return: List<Template>
	 */
	public List<Template> queryAllTemplate(int pageIndex, int pageMax);

	/**
	 * 方法的描述:根据id查询对应的教评项Template
	 * 
	 * @return: Template
	 */
	public Template queryTemplateById(Integer id);

	/**
	 * 
	 * 方法的描述:插入模板时维护关系表
	 * 
	 * @return: void
	 */
	public void saveRelativity(TemplateItemLink templateItemLink);

	// public void saveRelativity(Map<Integer,Integer> map);
	/**
	 * 方法的描述:获得模板中的当前序列
	 * 
	 * @return: Integer
	 */
	public Integer queryId();

	/**
	 * 方法的描述:查询出总共有多少条模板
	 * 
	 * @return: Integer
	 */
	public Integer queryTemplateMaxRows();
}
