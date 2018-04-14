package com.zpark.service;
import java.util.List;
import java.util.Map;

import com.zpark.entity.Evaluate;
import com.zpark.entity.EvaluateDetail;
import com.zpark.entity.EvaluateItem;
import com.zpark.entity.SearchBean;
import com.zpark.entity.Teacher;
import com.zpark.entity.Template;
import com.zpark.entity.User;
import com.zpark.exception.EvaluateDaoException;
/**
 * 
 * �������������������Service��
 * @author qutt@zparkhr.com.cn
 * @time 2013-7-19 ����10:50:35
 * @version 1.1
 */
public interface EvaluateService {
	/**
	 * 
	 * ������������ѯ���еĽ���
	 * @return ������list����
	 * @throws EvaluateDaoException
	 */
	public List<Evaluate> showAllEvaluate() throws Exception;
	
	/**
	 * 
	 * ����������  ���ݽ���id��ѯ���еĽ�����
	 * @param id ����id
	 * @return �ý���id��Ӧ�Ľ������
	 */
//	public List<EvaluateItem> showEvaluateItemByEvaluateId( int id)throws Exception;
	
	/**
	 * 
	 * �������������ݽ���id��ѯ��������ϸ��Ϣ
	 * @param id ����id
	 * @return ��ǰ����
	 * @throws EvaluateDaoException
	 */
	public  Evaluate showEvaluateDetailByEvaluateId( int id)throws Exception;
	public  List<Evaluate> showEvaluateByEvaluateId( int id)throws Exception;

	/**
	 * 
	 * �������������½�����Ϣ
	 * @param evaluate ���µ���Ϣ
	 */
	public void modifyEvaluate(Evaluate evaluate)throws Exception;
	

	/**
	 * 
	 * ����������ɾ��������Ϣ
	 * @param id ����id
	 */
	public void removeEvaluateById(String deleteId) throws Exception;
	
	/**
	 * 
	 * ��������������һ��������Ϣ
	 * @param evaluate ������Ϣ
	 */
	public void createEvaluate(Evaluate evaluate) throws Exception;
	/**
	 * 
	 * ���������� ��ѯ���е�ģ��
	 * @return ����ģ��ļ���
	 */
	public List<Template> showAllTemplate()throws Exception;
	/**
	 * 
	 * ������������ѯ���еĽ�ʦ
	 * @return  �������н�ʦ�ļ���
	 */
	public List<Teacher> showAllTeacher()throws Exception;
	
	@SuppressWarnings("unchecked")
	/**��������������������ѯ������Ϣ
	 * @param: ��װ��ѯ��Ϣ
	 * @return ���ز�ѯ�����
	 */
	public List<Evaluate> showByCondition(SearchBean searchBean)throws Exception;
	/**
	 * �������������ɽ�����ƽ����
	 * @params:  ����id
	 */
	public void createAverageTotalScore(int id) throws Exception;
	/**
	 * �������������ݽ���id��ѯ��Ӧ�Ľ������鼯��
	 * @param: ����id
	 * @return: �������鼯��
	 */
	public List<EvaluateDetail> showAllEvaluateDetailsByEvaluateId(int id) throws Exception;
	/**
	 * �������������ݽ���id ��ģ��id ��ѯ�������������������
	 * @param  ����ѧ���������ļ���
	 */
	public List<String> showEvaluateItemDetail(int evaluteDetailId,int templateId)throws Exception;

	public  List<String> showScoreDetail(int evaluteDetailId,int templateId)throws Exception;
	
	public  SearchBean showCommendDetail(int evaluteDetailId,int templateId)throws Exception;
	
	public List<EvaluateDetail> showExportEvaluateDetailsByEvaluateId(int id) throws Exception;
	/**
	 * �������������ݰ༶�ţ���ѯ���е��û�
	 * @param clazz  �༶��
	 * @return  �û�����
	 * @throws Exception
	 */
	public List<User> showUserByClazz(String clazz)throws Exception;
}
