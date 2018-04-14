package com.zpark.dao;

import java.util.List;

import com.zpark.entity.EvaluateItem;

/**
 * 
 * �����������װ�йؽ���������ݿ����
 * 
 * @author��yangdd@zparkhr.com.cn
 * 
 * @create: 2013-7-18 ����4:41:57
 *
 * @version: 1.0
 */
public interface EvaluateItemDAO {
	/**
	 * 
	 * ����������:��һ��evaluateItem���������ݲ��뵽���ݿ��� 
	 * @return: void
	 */
	public void saveEvaluateItem(EvaluateItem evaluateItem);
	/**
	 * ����������:����id�����ݿ��ж�Ӧ��evaluateItemɾ��
	 * @return: void
	 */
	public void deleteEvaluateItem(Integer id);
	/**
	 * 
	 * ����������:�����ݿ���evaluateIte���ݽ��и��²���
	 * @return: void
	 */
	public void updateEvaluateItem(EvaluateItem evaluateItem);
	/**
	 * ����������:������еĽ�����
	 * @return: List<EvaluateItem>
	 */
	public List<EvaluateItem> queryAllEvaluateItem(int pageIndex,int pageCount);
	/**
	 * ����������:����id��ѯ��Ӧ�Ľ�����evaluateItem
	 * @return: EvaluateItem
	 */
	public EvaluateItem queryEvaluateItemById(Integer id);
	/**
	 * 
	 * ����������:��ѯ�������ܹ��ж���������
	 * @return: int
	 */
	public Integer queryEvaluateItemMaxRows();
	/**
	 * ����������:������еĽ������ҳ
	 * @return: List<EvaluateItem>
	 */
	public List<EvaluateItem> queryAllEvaluateItems();
	
}
