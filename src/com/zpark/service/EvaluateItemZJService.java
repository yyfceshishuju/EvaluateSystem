package com.zpark.service;

import java.util.List;

import com.zpark.entity.ZJEvaluateItem;

/**
 * 类的描述：接口：封装 有关ZJEvaluateItem的持久化操作
 * 
 * @author：yangdd@zparkhr.com.cn
 * 
 * @create: 2013-8-3 下午3:49:08
 * 
 * @version: 1.0
 */
public interface EvaluateItemZJService {
	/**
	 * 方法的描述:将一个ZJEvaluateItem对象数据插入到数据库中
	 * 
	 * @return: void
	 */
	public void createZJEvaluateItem(ZJEvaluateItem zJevaluateItem);

	/**
	 * 
	 * 方法的描述:根据id调用dao删除对应的;评测项
	 * 
	 * @return: void
	 */
	public void removeZJEvaluateItem(Integer id);

	/**
	 * 
	 * 方法的描述:将zJevaluateItem进行更新
	 * 
	 * @return: void
	 */
	public void modifyZJEvaluateItem(ZJEvaluateItem zJevaluateItem);

	/**
	 * 
	 * 方法的描述:根据id获得对应的zJevaluateItem
	 * 
	 * @return: ZJEvaluateItem
	 */
	public ZJEvaluateItem showZJEvaluateItemById(Integer id);

	/**
	 * 
	 * 方法的描述:获得所有的评测项evaluateItem
	 * 
	 * @return: List<ZJEvaluateItem>
	 */
	public List<ZJEvaluateItem> showZJEvaluateItems();

	/**
	 * 方法的描述:获得所有的测评想不分页
	 * 
	 * @return: List<ZJEvaluateItem>
	 */
	public List<ZJEvaluateItem> showZJEvaluateItemsForTemplate();
}
