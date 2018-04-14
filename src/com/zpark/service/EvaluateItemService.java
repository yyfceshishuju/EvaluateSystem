package com.zpark.service;

import java.util.List;

import com.zpark.entity.EvaluateItem;
/**
 * ���������
 * 
 * @author��yangdd@zparkhr.com.cn
 * 
 * @create: 2013-7-18 ����6:12:37
 *
 * @version: 1.0
 */
public interface EvaluateItemService {
	/**
	 * ����������:��һ��EvaluateItem�������ݲ��뵽���ݿ���
	 * @return: void
	 */
	public void createEvaluateItem(EvaluateItem evaluateItem);
	/**
	 * 
	 * ����������:����id����daoɾ����Ӧ��;������
	 * @return: void
	 */
	public void removeEvaluateItem(Integer id);
	/**
	 * 
	 * ����������:��evaluateItem���и���
	 * @return: void
	 */
	public void modifyEvaluateItem(EvaluateItem evaluateItem);
	/**
	 * 
	 * ����������:����id��ö�Ӧ��evaluateItem
	 * @return: EvaluateItem
	 */
	public EvaluateItem showEvaluateItemById(Integer id);
	/**
	 * 
	 * ����������:������е�������evaluateItem
	 * @return: List<EvaluateItem>
	 */
	public List<EvaluateItem> showEvaluateItems();
	/**
	 * ����������:������еĲ����벻��ҳ
	 * @return: List<EvaluateItem>
	 */
	public List<EvaluateItem> showEvaluateItemsForTemplate();
}
