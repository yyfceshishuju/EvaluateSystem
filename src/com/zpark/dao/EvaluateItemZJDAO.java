package com.zpark.dao;

import java.util.List;

import com.zpark.entity.ZJEvaluateItem;

/**
 * ����������ӿڣ�������̵������������Ĳ���
 * 
 * @author��yangdd@zparkhr.com.cn
 * 
 * @create: 2013-8-3 ����3:31:48
 *
 * @version: 1.0
 */
public interface EvaluateItemZJDAO {
	/**
	 * ����������:��ZJEvaluateItem���浽���ݿ���
	 * @return: void
	 */
	public void saveZJEvaluteItem(ZJEvaluateItem zJEvaluateItem);
	/**
	 * ����������:����id�����ݿ��ж�Ӧ������evaluateItemɾ��
	 * @return: void
	 */
	public void deleteZJEvaluateItem(Integer id);
	/**
	 * 
	 * ����������:�����ݿ�������evaluateIte���ݽ��и��²���
	 * @return: void
	 */
	public void updateZJEvaluateItem(ZJEvaluateItem zJevaluateItem);
	/**
	 * ����������:������е����̽�����
	 * @return: List<EvaluateItem>
	 */
	public List<ZJEvaluateItem> queryAllZJEvaluateItem(int pageIndex,int pageCount);
	/**
	 * ����������:����id��ѯ��Ӧ�����̽�����zjevaluateItem
	 * @return: EvaluateItem
	 */
	public ZJEvaluateItem queryZJEvaluateItemById(Integer id);
	/**
	 * 
	 * ����������:��ѯ���̲������ܹ��ж���������
	 * @return: int
	 */
	public Integer queryZJEvaluateItemMaxRows();
	/**
	 * ����������:������е����̽������ҳ
	 * @return: List<EvaluateItem>
	 */
	public List<ZJEvaluateItem> queryAllEvaluateItems();
}
