package com.zpark.service;

import java.util.List;
import java.util.Map;

import com.zpark.entity.Assistant;
import com.zpark.entity.EvaluateDetail;
import com.zpark.entity.SearchBean;
import com.zpark.entity.ZJEvaluate;
import com.zpark.entity.ZJEvaluateDetail;
import com.zpark.entity.ZJEvaluateDetail;
import com.zpark.entity.ZJTemplate;
import com.zpark.exception.EvaluateDaoException;

/**
 * 
 *  �����������̲�����service
 * @author�� qutt@zparkhr.com.cn
 * @ʱ�䣺2013-8-3������02:18:36
 * @version:1.0
 *
 */
public interface EvaluateZjService {
	/**
	 * 
	 * ������������ѯ���е����̽���
	 * @return ����������list����
	 * @throws EvaluateDaoException
	 */
	public List<ZJEvaluate> showAllEvaluate() throws Exception;
	
	/**
	 * 
	 * ����������  �������̽���id��ѯ���еĽ�����
	 * @param id ���̽���id
	 * @return �����̽���id��Ӧ�Ľ������
	 */
//	public List<EvaluateItem> showEvaluateItemByEvaluateId( int id)throws Exception;
	
	/**
	 * 
	 * �����������������̽���id��ѯ��������ϸ��Ϣ
	 * @param id ���̽���id
	 * @return ��ǰ���̽���
	 * @throws EvaluateDaoException
	 */
	public  ZJEvaluate showEvaluateDetailByEvaluateId( int id)throws Exception;
	public  List<ZJEvaluate>showEvaluatZJByEvaluateId( int id)throws Exception;

	/**
	 * 
	 * �����������������̽�����Ϣ
	 * @param evaluate ���µ���Ϣ
	 */
	public void modifyEvaluate(ZJEvaluate evaluate);
	

	/**
	 * 
	 * ����������ɾ�����̽�����Ϣ
	 * @param id ����id
	 */
	public void removeEvaluateById(String deleteId) throws Exception;
	
	/**
	 * 
	 * ��������������һ�����̽�����Ϣ
	 * @param evaluate ������Ϣ
	 */
	public void createEvaluate(ZJEvaluate evaluate) throws Exception;
	/**
	 * 
	 * ���������� ��ѯ���е����̽���ģ��
	 * @return �������̽���ģ��ļ���
	 */
	public List<ZJTemplate> showAllTemplate()throws Exception;
	/**
	 * 
	 * ������������ѯ���е�����
	 * @return  �����������̵ļ���
	 */
	public List<Assistant> showAllAssistant () throws Exception;
	
	@SuppressWarnings("unchecked")
	/**��������������������ѯ���̽�����Ϣ
	 * @param: ��װ��ѯ��Ϣ
	 * @return ���ز�ѯ�����
	 */
	public List<ZJEvaluate> showByCondition(SearchBean searchBean);
	/**
	 * �����������������̽�����ƽ����
	 * @params:  ����id
	 */
	public void createAverageTotalScore(int id) throws Exception;
	/**
	 * �����������������̽���id��ѯ��Ӧ�����̽������鼯��
	 * @param: ���̽���id
	 * @return: ���̽������鼯��
	 */
	public List<ZJEvaluateDetail> showAllEvaluateDetailsByEvaluateId(int id) throws Exception;
	/**
	 * �����������������̽���id ��ģ��id ��ѯ���̽������������������
	 * @param  ����ѧ���������ļ���
	 */
	public List<String> showEvaluateItemDetail(int ZjEvaluteDetailId,int zjTemplateId);

	public  List<String> showScoreDetail(int zjEvaluteDetailId,int zjTemplateId);
	public  SearchBean showCommendDetail(int evaluteDetailId,int templateId)throws Exception;
	public List<ZJEvaluateDetail> showExportEvaluateDetailsByEvaluateId(int id) throws Exception;

}
