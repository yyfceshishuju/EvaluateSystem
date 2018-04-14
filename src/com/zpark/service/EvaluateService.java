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
 * 类的描述：教评操作的Service层
 * @author qutt@zparkhr.com.cn
 * @time 2013-7-19 上午10:50:35
 * @version 1.1
 */
public interface EvaluateService {
	/**
	 * 
	 * 方法描述：查询所有的教评
	 * @return 教评的list集合
	 * @throws EvaluateDaoException
	 */
	public List<Evaluate> showAllEvaluate() throws Exception;
	
	/**
	 * 
	 * 方法描述：  根据教评id查询所有的教评项
	 * @param id 教评id
	 * @return 该教评id对应的教评项集合
	 */
//	public List<EvaluateItem> showEvaluateItemByEvaluateId( int id)throws Exception;
	
	/**
	 * 
	 * 方法描述：根据教评id查询教评的详细信息
	 * @param id 教评id
	 * @return 当前教评
	 * @throws EvaluateDaoException
	 */
	public  Evaluate showEvaluateDetailByEvaluateId( int id)throws Exception;
	public  List<Evaluate> showEvaluateByEvaluateId( int id)throws Exception;

	/**
	 * 
	 * 方法描述：更新教评信息
	 * @param evaluate 更新的信息
	 */
	public void modifyEvaluate(Evaluate evaluate)throws Exception;
	

	/**
	 * 
	 * 方法描述：删除教评信息
	 * @param id 教评id
	 */
	public void removeEvaluateById(String deleteId) throws Exception;
	
	/**
	 * 
	 * 方法描述：插入一条教评信息
	 * @param evaluate 插入信息
	 */
	public void createEvaluate(Evaluate evaluate) throws Exception;
	/**
	 * 
	 * 方法描述： 查询所有的模板
	 * @return 所有模板的集合
	 */
	public List<Template> showAllTemplate()throws Exception;
	/**
	 * 
	 * 方法描述：查询所有的教师
	 * @return  返回所有教师的集合
	 */
	public List<Teacher> showAllTeacher()throws Exception;
	
	@SuppressWarnings("unchecked")
	/**方法描述：根据条件查询教评信息
	 * @param: 封装查询信息
	 * @return 返回查询结果集
	 */
	public List<Evaluate> showByCondition(SearchBean searchBean)throws Exception;
	/**
	 * 方法描述：生成教评的平均分
	 * @params:  教评id
	 */
	public void createAverageTotalScore(int id) throws Exception;
	/**
	 * 方法描述：根据教评id查询对应的教评详情集合
	 * @param: 教评id
	 * @return: 教评详情集合
	 */
	public List<EvaluateDetail> showAllEvaluateDetailsByEvaluateId(int id) throws Exception;
	/**
	 * 方法描述：根据教评id 和模板id 查询教评打分情况和评价情况
	 * @param  返回学生打分情况的集合
	 */
	public List<String> showEvaluateItemDetail(int evaluteDetailId,int templateId)throws Exception;

	public  List<String> showScoreDetail(int evaluteDetailId,int templateId)throws Exception;
	
	public  SearchBean showCommendDetail(int evaluteDetailId,int templateId)throws Exception;
	
	public List<EvaluateDetail> showExportEvaluateDetailsByEvaluateId(int id) throws Exception;
	/**
	 * 方法描述：根据班级号，查询所有的用户
	 * @param clazz  班级号
	 * @return  用户集合
	 * @throws Exception
	 */
	public List<User> showUserByClazz(String clazz)throws Exception;
}
