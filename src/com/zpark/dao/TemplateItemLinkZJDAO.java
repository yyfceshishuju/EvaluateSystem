package com.zpark.dao;

import java.util.List;

import com.zpark.entity.ZJTemplateItemLink;

/**
 * 
 * 类的描述：封装有关Admin的一切数据库操作
 * 
 * @author：yangdd@zparkhr.com.cn
 * 
 * @create: 2013-7-18 下午4:35:35
 * 
 * @version: 1.0
 */
public interface TemplateItemLinkZJDAO {
	/**
	 * 
	 * 方法的描述:根据itemId查询对应的TemplateItemLink对象
	 * 
	 * @return: Admin
	 */
	public List<ZJTemplateItemLink> queryByItemId(Integer itemId);
	/**
	 * 
	 * 方法的描述:根据templateId查询对应的TemplateItemLink对象
	 * 
	 * @return: Admin
	 */
	//public TemplateItemLink queryByTemplateId(Integer templateId);
	/**
	 * 方法的描述:根据模板id删除关系表
	 * @return: void
	 */
	public void deleteByZJTemplateId(Integer templateId);
	
}
