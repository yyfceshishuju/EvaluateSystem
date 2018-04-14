package com.zpark.dao;

import java.util.List;

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
 * �������������������DAO��
 * @author qutt@zparkhr.com.cn
 * @time 2013-7-19 ����10:47:31
 * @version 1.1
 */
public interface EvaluateDao {
	/**
	 * 
	 * ������������ѯ���еĽ���
	 * @return ������list����
	 * @throws EvaluateDaoException
	 */
	public List<Evaluate> queryAllEvaluate(SearchBean searchBean) throws EvaluateDaoException;
	
	/**
	 * 
	 * ������������ѯ������������
	 * @return  ��������
	 */
	public int queryEvaluateTotalCount()throws EvaluateDaoException;
	
	/**
	 * 
	 * �������������ݽ���id��ѯ��������ϸ��Ϣ
	 * @param id ����id
	 * @return ��ǰ����
	 * @throws EvaluateDaoException
	 */
	public Evaluate queryEvaluateDetailByEvaluateId(int id) throws EvaluateDaoException;
	
	/**
	 * �������������ݽ�����ϸ��id ��ѯ������ϸ��Ϣ
	 * @param id  ������ϸid
	 * @return  ���ظý�����ϸ����
	 */
	public EvaluateDetail queryEvaluteDetailById(int id)throws EvaluateDaoException;
	
	/**
	 * 
	 * �������������½�����Ϣ
	 * @param evaluate ���µ���Ϣ
	 */
	public void updateEvaluate(Evaluate evaluate)throws EvaluateDaoException;
	
	/**
	 * 
	 * ����������ɾ��������Ϣ
	 * @param id ����id
	 */
	public void deleteEvaluateById(List<Integer> list)throws EvaluateDaoException;
	
	/**
	 * �������������ݽ���idɾ��������ϸ
	 * @param id ����id
	 */
	public void deleteEvaluateDetailByEvaluateId( int id)throws EvaluateDaoException;
	/**
	 * 
	 * ��������������һ��������Ϣ
	 * @param evaluate ������Ϣ
	 */
	public void savaEvaluate(Evaluate evaluate)throws EvaluateDaoException;
	
	/**
	 * 
	 * ���������� ��ѯ���е�ģ��
	 * @return ����ģ��ļ���
	 */
	public List<Template> queryAllTempalate()throws EvaluateDaoException;
	
	/**
	 * 
	 * ������������ѯ���еĽ�ʦ
	 * @return �������н�ʦ�ļ���
	 */
	public List<Teacher> queryAllTeacher()throws EvaluateDaoException;
	
	/**
	 *  ������������ѯĳ��������ƽ����
	 * @param id  ����id
	 * @return  �ý���id����Ӧ������ƽ����
	 */
	public double queryAverageTotalScore(int id)throws EvaluateDaoException;
	/**
	 * �������������ɽ����ֺܷ�����������
	 * @param evaluate  ��������
	 */
	public void updateEvaluateTotalScoreAndCommendDetail(Evaluate evaluate)throws EvaluateDaoException;
	/**
	 * 
	 * @param id
	 * @return
	 */
//	public List<String> queryAllScoreDetailByEvaluateId(int id);
	
	public List<EvaluateDetail> queryAllEvaluateDetailBySearchBean(SearchBean searchBean)throws EvaluateDaoException;
	/**
	 * �������������ݽ���id��ѯ���еĽ�������
	 * @param id ����id
	 * @return �������鼯��
	 */
	public List<EvaluateDetail> queryAllEvaluateDetailByEvaluateId(int id)throws EvaluateDaoException;
	/**
	 * �������������ݽ���id��ѯ������ϸ��Ϣ������
	 * @param id ����id
	 * @return �������
	 */
	public int queryTotalCountEvaluateDetailByEvaluateId(int id)throws EvaluateDaoException;
	/**
	 * �������������ݽ�ʦ����ѯ����
	 * @param searchBean ��װ��ѯ����  
	 * @return  ���ؽ�������
	 */
	public List<Evaluate> queryEvaluateByTeacherName(SearchBean searchBean)throws EvaluateDaoException;
	/**
	 * 	�������������ݽ�ʦ����ѯ����������
	 * @param searchBean ��װ��ѯ����
	 * @return  ���ز鵽������
	 */
	public int queryTotalCountByTeacherName(SearchBean searchBean)throws EvaluateDaoException;
	/**
	 * �������������ݿγ����Ʋ�ѯ����
	 * @param searchBean ��װ��ѯ����  
	 * @return  ���ؽ�������
	 */
	public List<Evaluate> queryEvaluateBySubject(SearchBean searchBean)throws EvaluateDaoException;
	/**
	 * 	�������������ݿγ�����ѯ����������
	 * @param searchBean ��װ��ѯ����
	 * @return  ���ز鵽������
	 */
	public int queryTotalCountBySubject(SearchBean searchBean)throws EvaluateDaoException;
	/**
	 * �������������ݲ���ʱ���ѯ����
	 * @param searchBean ��װ��ѯ����  
	 * @return  ���ؽ�������
	 */
	public List<Evaluate> queryEvaluateByEvalauteDate(SearchBean searchBean)throws EvaluateDaoException;
	/**
	 * 	�������������ݲ���ʱ���ѯ����������
	 * @param searchBean ��װ��ѯ����
	 * @return  ���ز鵽������
	 */
	public int queryTotalCountByEvaluateDate(SearchBean searchBean)throws EvaluateDaoException;
	/**
	 * ��������������ѧ��������ѯ����
	 * @param searchBean ��װ��ѯ����  
	 * @return  ���ؽ�������
	 */
	public List<Evaluate> queryEvaluateByStudentName(SearchBean searchBean)throws EvaluateDaoException;
	/**
	 * 	��������������ѧ��������ѯ����������
	 * @param searchBean ��װ��ѯ����
	 * @return  ���ز鵽������
	 */
	public int queryTotalCountByStudentName(SearchBean searchBean)throws EvaluateDaoException;
	/**
	 * �������������ݲ���ģ��id��ѯ������
	 * @param id ģ��id
	 * @return �������
	 */
	public List<EvaluateItem>  queryEvaluateItemByTemplateId(int id)throws EvaluateDaoException;
	
	public List<Evaluate> queryEvaluateByTemplateId(int id)throws EvaluateDaoException;
	/**
	 * �������������ݿ�ʼʱ��Ͱ༶��ѯ����
	 * @param searchBean ��װ��ѯ����
	 * @return  ��ѯ����evaluate
	 */
	public Evaluate queryEvaluateByDateAndClazz(Evaluate evaluate)throws EvaluateDaoException;
	
	public List<User> queryUserByClass(String clazz) throws EvaluateDaoException;
}
