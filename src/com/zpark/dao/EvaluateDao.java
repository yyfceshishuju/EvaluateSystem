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
 * 类的描述：教评操作的DAO层
 * @author qutt@zparkhr.com.cn
 * @time 2013-7-19 上午10:47:31
 * @version 1.1
 */
public interface EvaluateDao {
	/**
	 * 
	 * 方法描述：查询所有的教评
	 * @return 教评的list集合
	 * @throws EvaluateDaoException
	 */
	public List<Evaluate> queryAllEvaluate(SearchBean searchBean) throws EvaluateDaoException;
	
	/**
	 * 
	 * 方法描述：查询教评数量总数
	 * @return  教评总数
	 */
	public int queryEvaluateTotalCount()throws EvaluateDaoException;
	
	/**
	 * 
	 * 方法描述：根据教评id查询教评的详细信息
	 * @param id 教评id
	 * @return 当前教评
	 * @throws EvaluateDaoException
	 */
	public Evaluate queryEvaluateDetailByEvaluateId(int id) throws EvaluateDaoException;
	
	/**
	 * 方法描述：根据讲评详细表id 查询教评详细信息
	 * @param id  教评详细id
	 * @return  返回该教评详细数据
	 */
	public EvaluateDetail queryEvaluteDetailById(int id)throws EvaluateDaoException;
	
	/**
	 * 
	 * 方法描述：更新教评信息
	 * @param evaluate 更新的信息
	 */
	public void updateEvaluate(Evaluate evaluate)throws EvaluateDaoException;
	
	/**
	 * 
	 * 方法描述：删除教评信息
	 * @param id 教评id
	 */
	public void deleteEvaluateById(List<Integer> list)throws EvaluateDaoException;
	
	/**
	 * 方法描述：根据教评id删除教评详细
	 * @param id 教评id
	 */
	public void deleteEvaluateDetailByEvaluateId( int id)throws EvaluateDaoException;
	/**
	 * 
	 * 方法描述：插入一条教评信息
	 * @param evaluate 插入信息
	 */
	public void savaEvaluate(Evaluate evaluate)throws EvaluateDaoException;
	
	/**
	 * 
	 * 方法描述： 查询所有的模板
	 * @return 所有模板的集合
	 */
	public List<Template> queryAllTempalate()throws EvaluateDaoException;
	
	/**
	 * 
	 * 方法描述：查询所有的教师
	 * @return 返回所有教师的集合
	 */
	public List<Teacher> queryAllTeacher()throws EvaluateDaoException;
	
	/**
	 *  方法描述：查询某条教评的平均分
	 * @param id  教评id
	 * @return  该教评id所对应教评的平均分
	 */
	public double queryAverageTotalScore(int id)throws EvaluateDaoException;
	/**
	 * 方法描述：生成教评总分和总评价内容
	 * @param evaluate  教评对象
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
	 * 方法描述：根据教评id查询所有的教评详情
	 * @param id 教评id
	 * @return 教评详情集合
	 */
	public List<EvaluateDetail> queryAllEvaluateDetailByEvaluateId(int id)throws EvaluateDaoException;
	/**
	 * 方法描述：根据教评id查询教评详细信息的数量
	 * @param id 教评id
	 * @return 数量结果
	 */
	public int queryTotalCountEvaluateDetailByEvaluateId(int id)throws EvaluateDaoException;
	/**
	 * 方法描述：根据教师名查询教评
	 * @param searchBean 封装查询条件  
	 * @return  返回教评集合
	 */
	public List<Evaluate> queryEvaluateByTeacherName(SearchBean searchBean)throws EvaluateDaoException;
	/**
	 * 	方法描述：根据教师名查询教评的总数
	 * @param searchBean 封装查询条件
	 * @return  返回查到的数量
	 */
	public int queryTotalCountByTeacherName(SearchBean searchBean)throws EvaluateDaoException;
	/**
	 * 方法描述：根据课程名称查询教评
	 * @param searchBean 封装查询条件  
	 * @return  返回教评集合
	 */
	public List<Evaluate> queryEvaluateBySubject(SearchBean searchBean)throws EvaluateDaoException;
	/**
	 * 	方法描述：根据课程名查询教评的总数
	 * @param searchBean 封装查询条件
	 * @return  返回查到的数量
	 */
	public int queryTotalCountBySubject(SearchBean searchBean)throws EvaluateDaoException;
	/**
	 * 方法描述：根据测评时间查询教评
	 * @param searchBean 封装查询条件  
	 * @return  返回教评集合
	 */
	public List<Evaluate> queryEvaluateByEvalauteDate(SearchBean searchBean)throws EvaluateDaoException;
	/**
	 * 	方法描述：根据测评时间查询教评的总数
	 * @param searchBean 封装查询条件
	 * @return  返回查到的数量
	 */
	public int queryTotalCountByEvaluateDate(SearchBean searchBean)throws EvaluateDaoException;
	/**
	 * 方法描述：根据学生姓名查询教评
	 * @param searchBean 封装查询条件  
	 * @return  返回教评集合
	 */
	public List<Evaluate> queryEvaluateByStudentName(SearchBean searchBean)throws EvaluateDaoException;
	/**
	 * 	方法描述：根据学生姓名查询教评的总数
	 * @param searchBean 封装查询条件
	 * @return  返回查到的数量
	 */
	public int queryTotalCountByStudentName(SearchBean searchBean)throws EvaluateDaoException;
	/**
	 * 方法描述：根据测评模板id查询测评项
	 * @param id 模板id
	 * @return 测评项集合
	 */
	public List<EvaluateItem>  queryEvaluateItemByTemplateId(int id)throws EvaluateDaoException;
	
	public List<Evaluate> queryEvaluateByTemplateId(int id)throws EvaluateDaoException;
	/**
	 * 方法描述：根据开始时间和班级查询教评
	 * @param searchBean 封装查询参数
	 * @return  查询到的evaluate
	 */
	public Evaluate queryEvaluateByDateAndClazz(Evaluate evaluate)throws EvaluateDaoException;
	
	public List<User> queryUserByClass(String clazz) throws EvaluateDaoException;
}
