package com.zpark.service;

import java.util.List;

import com.zpark.entity.ZJEvaluateItem;

/**
 * ����������ӿڣ���װ �й�ZJEvaluateItem�ĳ־û�����
 * 
 * @author��yangdd@zparkhr.com.cn
 * 
 * @create: 2013-8-3 ����3:49:08
 * 
 * @version: 1.0
 */
public interface EvaluateItemZJService {
	/**
	 * ����������:��һ��ZJEvaluateItem�������ݲ��뵽���ݿ���
	 * 
	 * @return: void
	 */
	public void createZJEvaluateItem(ZJEvaluateItem zJevaluateItem);

	/**
	 * 
	 * ����������:����id����daoɾ����Ӧ��;������
	 * 
	 * @return: void
	 */
	public void removeZJEvaluateItem(Integer id);

	/**
	 * 
	 * ����������:��zJevaluateItem���и���
	 * 
	 * @return: void
	 */
	public void modifyZJEvaluateItem(ZJEvaluateItem zJevaluateItem);

	/**
	 * 
	 * ����������:����id��ö�Ӧ��zJevaluateItem
	 * 
	 * @return: ZJEvaluateItem
	 */
	public ZJEvaluateItem showZJEvaluateItemById(Integer id);

	/**
	 * 
	 * ����������:������е�������evaluateItem
	 * 
	 * @return: List<ZJEvaluateItem>
	 */
	public List<ZJEvaluateItem> showZJEvaluateItems();

	/**
	 * ����������:������еĲ����벻��ҳ
	 * 
	 * @return: List<ZJEvaluateItem>
	 */
	public List<ZJEvaluateItem> showZJEvaluateItemsForTemplate();
}
