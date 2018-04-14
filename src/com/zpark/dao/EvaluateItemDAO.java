package com.zpark.dao;

import java.util.List;

import com.zpark.entity.EvaluateItem;

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
public interface EvaluateItemDAO {
	/**
	 * 
	 * 方法的描述:将一个evaluateItem教评项内容插入到数据库中 
	 * @return: void
	 */
	public void saveEvaluateItem(EvaluateItem evaluateItem);
	/**
	 * 方法的描述:根据id将数据库中对应的evaluateItem删除
	 * @return: void
	 */
	public void deleteEvaluateItem(Integer id);
	/**
	 * 
	 * 方法的描述:将数据库中evaluateIte数据进行更新操作
	 * @return: void
	 */
	public void updateEvaluateItem(EvaluateItem evaluateItem);
	/**
	 * 方法的描述:获得所有的教评项
	 * @return: List<EvaluateItem>
	 */
	public List<EvaluateItem> queryAllEvaluateItem(int pageIndex,int pageCount);
	/**
	 * 方法的描述:根据id查询对应的教评项evaluateItem
	 * @return: EvaluateItem
	 */
	public EvaluateItem queryEvaluateItemById(Integer id);
	/**
	 * 
	 * 方法的描述:查询测评项总共有多少条数据
	 * @return: int
	 */
	public Integer queryEvaluateItemMaxRows();
	/**
	 * 方法的描述:获得所有的教评项不分页
	 * @return: List<EvaluateItem>
	 */
	public List<EvaluateItem> queryAllEvaluateItems();
	
}
