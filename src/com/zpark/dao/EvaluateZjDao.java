package com.zpark.dao;

import java.util.List;
import com.zpark.entity.Assistant;
import com.zpark.entity.SearchBean;
import com.zpark.entity.ZJEvaluate;
import com.zpark.entity.ZJEvaluateDetail;
import com.zpark.entity.ZJEvaluateItem;
import com.zpark.entity.ZJTemplate;
import com.zpark.exception.EvaluateDaoException;
import com.zpark.exception.EvaluateZjDaoException;
/**
 * 
 *  �������� ���̲�����dao��
 * @author�� qutt@zparkhr.com.cn
 * @ʱ�䣺2013-8-3������01:37:05
 * @version:1.0
 *
 */
public interface EvaluateZjDao {
	/**
	 * 
	 * ������������ѯ���е����̽���
	 * @return ���̽�����list����
	 * @throws EvaluateDaoException
	 */
	public List<ZJEvaluate> queryAllEvaluate(SearchBean searchBean) throws EvaluateZjDaoException;
	
	/**
	 * 
	 * ������������ѯ���̽�����������
	 * @return  ��������
	 */
	public int queryEvaluateTotalCount()throws EvaluateZjDaoException;
	
	/**
	 * 
	 * �����������������̽���id��ѯ��������ϸ��Ϣ
	 * @param id ���̽���id
	 * @return ��ǰ���̽���
	 * @throws EvaluateDaoException
	 */
	public ZJEvaluate queryEvaluateDetailByEvaluateId(int id) throws EvaluateZjDaoException;

	/**
	 * �����������������̽�����ϸ��id ��ѯ���̽�����ϸ��Ϣ
	 * @param id  ���̽�����ϸid
	 * @return  ���ظ����̽�����ϸ����
	 */
	public ZJEvaluateDetail queryEvaluteDetailById(int id)throws EvaluateZjDaoException;
	
	/**
	 * 
	 * �����������������̽�����Ϣ
	 * @param zjEvaluate ���µ���Ϣ
	 */
	public void updateEvaluate(ZJEvaluate zjEvaluate)throws EvaluateZjDaoException;
	
	/**
	 * 
	 * ����������ɾ�����̽�����Ϣ
	 * @param id ����id
	 */
	public void deleteEvaluateById(List<Integer> list)throws EvaluateZjDaoException;
	
	/**
	 * �������������ݽ���idɾ�����̽�����ϸ
	 * @param id ���̽���id
	 */
	public void deleteEvaluateDetailByEvaluateId( int id)throws EvaluateZjDaoException;
	/**
	 * 
	 * ��������������һ�����̽�����Ϣ
	 * @param zjEvaluate ������Ϣ
	 */
	public void savaEvaluate(ZJEvaluate zjEvaluate)throws EvaluateZjDaoException;
	
	/**
	 * 
	 * ���������� ��ѯ���е�����ģ��
	 * @return ����ģ��ļ���
	 */
	public List<ZJTemplate> queryAllTempalate()throws EvaluateZjDaoException;
	
	/**
	 * 
	 * ������������ѯ���е�����
	 * @return �����������̵ļ���
	 */
	public List<Assistant> queryAllAssistant()throws EvaluateZjDaoException;
	
	/**
	 *  ������������ѯĳ��������ƽ����
	 * @param id  ����id
	 * @return  �ý���id����Ӧ������ƽ����
	 */
	public double queryAverageTotalScore(int id)throws EvaluateZjDaoException;
	/**
	 * �������������ɽ����ֺܷ�����������
	 * @param zjEvaluate  ��������
	 */
	public void updateEvaluateTotalScoreAndCommendDetail(ZJEvaluate zjEvaluate)throws EvaluateZjDaoException;
	/**
	 * 
	 * @param id
	 * @return
	 */
//	public List<String> queryAllScoreDetailByEvaluateId(int id);
	
	public List<ZJEvaluateDetail> queryAllEvaluateDetailBySearchBean(SearchBean searchBan)throws EvaluateZjDaoException;
	/**
	 * �������������ݽ���id��ѯ���еĽ�������
	 * @param id ����id
	 * @return �������鼯��
	 */
	public List<ZJEvaluateDetail> queryAllEvaluateDetailByEvaluateId(int id)throws EvaluateZjDaoException;
	/**
	 * �������������ݽ���id��ѯ������ϸ��Ϣ������
	 * @param id ����id
	 * @return �������
	 */
	public int queryTotalCountEvaluateDetailByEvaluateId(int id)throws EvaluateZjDaoException;
	/**
	 * �������������ݽ�ʦ����ѯ����
	 * @param zjSearchBan ��װ��ѯ����  
	 * @return  ���ؽ�������
	 */
	public List<ZJEvaluate> queryEvaluateByTeacherName(SearchBean searchBean)throws EvaluateZjDaoException;
	/**
	 * 	�������������ݽ�ʦ����ѯ����������
	 * @param zjSearchBan ��װ��ѯ����
	 * @return  ���ز鵽������
	 */
	public int queryTotalCountByTeacherName(SearchBean searchBean)throws EvaluateZjDaoException;
	/**
	 * �������������ݿγ����Ʋ�ѯ����
	 * @param zjSearchBan ��װ��ѯ����  
	 * @return  ���ؽ�������
	 */
	public List<ZJEvaluate> queryEvaluateBySubject(SearchBean searchBean)throws EvaluateZjDaoException;
	/**
	 * 	�������������ݿγ�����ѯ����������
	 * @param searchBean ��װ��ѯ����
	 * @return  ���ز鵽������
	 */
	public int queryTotalCountBySubject(SearchBean searchBean)throws EvaluateZjDaoException;
	/**
	 * �������������ݲ���ʱ���ѯ����
	 * @param searchBean ��װ��ѯ����  
	 * @return  ���ؽ�������
	 */
	public List<ZJEvaluate> queryEvaluateByEvalauteDate(SearchBean searchBean)throws EvaluateZjDaoException;
	/**
	 * 	�������������ݲ���ʱ���ѯ����������
	 * @param searchBean ��װ��ѯ����
	 * @return  ���ز鵽������
	 */
	public int queryTotalCountByEvaluateDate(SearchBean searchBean)throws EvaluateZjDaoException;
	/**
	 * ��������������ѧ��������ѯ����
	 * @param searchBean ��װ��ѯ����  
	 * @return  ���ؽ�������
	 */
	public List<ZJEvaluate> queryEvaluateByStudentName(SearchBean searchBean)throws EvaluateZjDaoException;
	/**
	 * 	��������������ѧ��������ѯ����������
	 * @param searchBean ��װ��ѯ����
	 * @return  ���ز鵽������
	 */
	public int queryTotalCountByStudentName(SearchBean searchBean)throws EvaluateZjDaoException;
	/**
	 * �������������ݲ���ģ��id��ѯ������
	 * @param id ģ��id
	 * @return �������
	 */
	public List<ZJEvaluateItem>  queryEvaluateItemByTemplateId(int id)throws EvaluateZjDaoException;
	
	public List<ZJEvaluate> queryEvaluateByTemplateId(int id)throws EvaluateZjDaoException;
	/**
	 * �������������ݿ�ʼʱ��Ͱ༶��ѯ����
	 * @param zjSearchBan ��װ��ѯ����
	 * @return  ��ѯ����zjEvaluate
	 */
	public ZJEvaluate queryEvaluateByDateAndClazz(ZJEvaluate zjEvaluate)throws EvaluateZjDaoException;
}
