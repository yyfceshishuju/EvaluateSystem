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
 *  类描述： 助教测评的dao层
 * @author： qutt@zparkhr.com.cn
 * @时间：2013-8-3，下午01:37:05
 * @version:1.0
 *
 */
public interface EvaluateZjDao {
	/**
	 * 
	 * 方法描述：查询所有的助教教评
	 * @return 助教教评的list集合
	 * @throws EvaluateDaoException
	 */
	public List<ZJEvaluate> queryAllEvaluate(SearchBean searchBean) throws EvaluateZjDaoException;
	
	/**
	 * 
	 * 方法描述：查询助教教评数量总数
	 * @return  教评总数
	 */
	public int queryEvaluateTotalCount()throws EvaluateZjDaoException;
	
	/**
	 * 
	 * 方法描述：根据助教教评id查询教评的详细信息
	 * @param id 助教教评id
	 * @return 当前助教教评
	 * @throws EvaluateDaoException
	 */
	public ZJEvaluate queryEvaluateDetailByEvaluateId(int id) throws EvaluateZjDaoException;

	/**
	 * 方法描述：根据助教讲评详细表id 查询助教教评详细信息
	 * @param id  助教教评详细id
	 * @return  返回该助教教评详细数据
	 */
	public ZJEvaluateDetail queryEvaluteDetailById(int id)throws EvaluateZjDaoException;
	
	/**
	 * 
	 * 方法描述：更新助教教评信息
	 * @param zjEvaluate 更新的信息
	 */
	public void updateEvaluate(ZJEvaluate zjEvaluate)throws EvaluateZjDaoException;
	
	/**
	 * 
	 * 方法描述：删除助教教评信息
	 * @param id 教评id
	 */
	public void deleteEvaluateById(List<Integer> list)throws EvaluateZjDaoException;
	
	/**
	 * 方法描述：根据教评id删除助教教评详细
	 * @param id 助教教评id
	 */
	public void deleteEvaluateDetailByEvaluateId( int id)throws EvaluateZjDaoException;
	/**
	 * 
	 * 方法描述：插入一条助教教评信息
	 * @param zjEvaluate 插入信息
	 */
	public void savaEvaluate(ZJEvaluate zjEvaluate)throws EvaluateZjDaoException;
	
	/**
	 * 
	 * 方法描述： 查询所有的助教模板
	 * @return 所有模板的集合
	 */
	public List<ZJTemplate> queryAllTempalate()throws EvaluateZjDaoException;
	
	/**
	 * 
	 * 方法描述：查询所有的助教
	 * @return 返回所有助教的集合
	 */
	public List<Assistant> queryAllAssistant()throws EvaluateZjDaoException;
	
	/**
	 *  方法描述：查询某条教评的平均分
	 * @param id  教评id
	 * @return  该教评id所对应教评的平均分
	 */
	public double queryAverageTotalScore(int id)throws EvaluateZjDaoException;
	/**
	 * 方法描述：生成教评总分和总评价内容
	 * @param zjEvaluate  教评对象
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
	 * 方法描述：根据教评id查询所有的教评详情
	 * @param id 教评id
	 * @return 教评详情集合
	 */
	public List<ZJEvaluateDetail> queryAllEvaluateDetailByEvaluateId(int id)throws EvaluateZjDaoException;
	/**
	 * 方法描述：根据教评id查询教评详细信息的数量
	 * @param id 教评id
	 * @return 数量结果
	 */
	public int queryTotalCountEvaluateDetailByEvaluateId(int id)throws EvaluateZjDaoException;
	/**
	 * 方法描述：根据教师名查询教评
	 * @param zjSearchBan 封装查询条件  
	 * @return  返回教评集合
	 */
	public List<ZJEvaluate> queryEvaluateByTeacherName(SearchBean searchBean)throws EvaluateZjDaoException;
	/**
	 * 	方法描述：根据教师名查询教评的总数
	 * @param zjSearchBan 封装查询条件
	 * @return  返回查到的数量
	 */
	public int queryTotalCountByTeacherName(SearchBean searchBean)throws EvaluateZjDaoException;
	/**
	 * 方法描述：根据课程名称查询教评
	 * @param zjSearchBan 封装查询条件  
	 * @return  返回教评集合
	 */
	public List<ZJEvaluate> queryEvaluateBySubject(SearchBean searchBean)throws EvaluateZjDaoException;
	/**
	 * 	方法描述：根据课程名查询教评的总数
	 * @param searchBean 封装查询条件
	 * @return  返回查到的数量
	 */
	public int queryTotalCountBySubject(SearchBean searchBean)throws EvaluateZjDaoException;
	/**
	 * 方法描述：根据测评时间查询教评
	 * @param searchBean 封装查询条件  
	 * @return  返回教评集合
	 */
	public List<ZJEvaluate> queryEvaluateByEvalauteDate(SearchBean searchBean)throws EvaluateZjDaoException;
	/**
	 * 	方法描述：根据测评时间查询教评的总数
	 * @param searchBean 封装查询条件
	 * @return  返回查到的数量
	 */
	public int queryTotalCountByEvaluateDate(SearchBean searchBean)throws EvaluateZjDaoException;
	/**
	 * 方法描述：根据学生姓名查询教评
	 * @param searchBean 封装查询条件  
	 * @return  返回教评集合
	 */
	public List<ZJEvaluate> queryEvaluateByStudentName(SearchBean searchBean)throws EvaluateZjDaoException;
	/**
	 * 	方法描述：根据学生姓名查询教评的总数
	 * @param searchBean 封装查询条件
	 * @return  返回查到的数量
	 */
	public int queryTotalCountByStudentName(SearchBean searchBean)throws EvaluateZjDaoException;
	/**
	 * 方法描述：根据测评模板id查询测评项
	 * @param id 模板id
	 * @return 测评项集合
	 */
	public List<ZJEvaluateItem>  queryEvaluateItemByTemplateId(int id)throws EvaluateZjDaoException;
	
	public List<ZJEvaluate> queryEvaluateByTemplateId(int id)throws EvaluateZjDaoException;
	/**
	 * 方法描述：根据开始时间和班级查询教评
	 * @param zjSearchBan 封装查询参数
	 * @return  查询到的zjEvaluate
	 */
	public ZJEvaluate queryEvaluateByDateAndClazz(ZJEvaluate zjEvaluate)throws EvaluateZjDaoException;
}
