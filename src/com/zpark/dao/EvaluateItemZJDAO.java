package com.zpark.dao;

import java.util.List;

import com.zpark.entity.ZJEvaluateItem;

/**
 * 类的描述：接口：针对助教的评测项所做的操作
 * 
 * @author：yangdd@zparkhr.com.cn
 * 
 * @create: 2013-8-3 下午3:31:48
 *
 * @version: 1.0
 */
public interface EvaluateItemZJDAO {
	/**
	 * 方法的描述:将ZJEvaluateItem保存到数据库中
	 * @return: void
	 */
	public void saveZJEvaluteItem(ZJEvaluateItem zJEvaluateItem);
	/**
	 * 方法的描述:根据id将数据库中对应的助教evaluateItem删除
	 * @return: void
	 */
	public void deleteZJEvaluateItem(Integer id);
	/**
	 * 
	 * 方法的描述:将数据库中助教evaluateIte数据进行更新操作
	 * @return: void
	 */
	public void updateZJEvaluateItem(ZJEvaluateItem zJevaluateItem);
	/**
	 * 方法的描述:获得所有的助教教评项
	 * @return: List<EvaluateItem>
	 */
	public List<ZJEvaluateItem> queryAllZJEvaluateItem(int pageIndex,int pageCount);
	/**
	 * 方法的描述:根据id查询对应的助教教评项zjevaluateItem
	 * @return: EvaluateItem
	 */
	public ZJEvaluateItem queryZJEvaluateItemById(Integer id);
	/**
	 * 
	 * 方法的描述:查询助教测评项总共有多少条数据
	 * @return: int
	 */
	public Integer queryZJEvaluateItemMaxRows();
	/**
	 * 方法的描述:获得所有的助教教评项不分页
	 * @return: List<EvaluateItem>
	 */
	public List<ZJEvaluateItem> queryAllEvaluateItems();
}
