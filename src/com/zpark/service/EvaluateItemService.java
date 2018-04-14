package com.zpark.service;

import java.util.List;

import com.zpark.entity.EvaluateItem;
/**
 * 类的描述：
 * 
 * @author：yangdd@zparkhr.com.cn
 * 
 * @create: 2013-7-18 下午6:12:37
 *
 * @version: 1.0
 */
public interface EvaluateItemService {
	/**
	 * 方法的描述:将一个EvaluateItem对象数据插入到数据库中
	 * @return: void
	 */
	public void createEvaluateItem(EvaluateItem evaluateItem);
	/**
	 * 
	 * 方法的描述:根据id调用dao删除对应的;评测项
	 * @return: void
	 */
	public void removeEvaluateItem(Integer id);
	/**
	 * 
	 * 方法的描述:将evaluateItem进行更新
	 * @return: void
	 */
	public void modifyEvaluateItem(EvaluateItem evaluateItem);
	/**
	 * 
	 * 方法的描述:根据id获得对应的evaluateItem
	 * @return: EvaluateItem
	 */
	public EvaluateItem showEvaluateItemById(Integer id);
	/**
	 * 
	 * 方法的描述:获得所有的评测项evaluateItem
	 * @return: List<EvaluateItem>
	 */
	public List<EvaluateItem> showEvaluateItems();
	/**
	 * 方法的描述:获得所有的测评想不分页
	 * @return: List<EvaluateItem>
	 */
	public List<EvaluateItem> showEvaluateItemsForTemplate();
}
