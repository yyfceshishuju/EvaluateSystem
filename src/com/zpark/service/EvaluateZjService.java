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
 *  类描述：助教测评的service
 * @author： qutt@zparkhr.com.cn
 * @时间：2013-8-3，下午02:18:36
 * @version:1.0
 *
 */
public interface EvaluateZjService {
	/**
	 * 
	 * 方法描述：查询所有的助教教评
	 * @return 教评的助教list集合
	 * @throws EvaluateDaoException
	 */
	public List<ZJEvaluate> showAllEvaluate() throws Exception;
	
	/**
	 * 
	 * 方法描述：  根据助教教评id查询所有的教评项
	 * @param id 助教教评id
	 * @return 该助教教评id对应的教评项集合
	 */
//	public List<EvaluateItem> showEvaluateItemByEvaluateId( int id)throws Exception;
	
	/**
	 * 
	 * 方法描述：根据助教教评id查询教评的详细信息
	 * @param id 助教教评id
	 * @return 当前助教教评
	 * @throws EvaluateDaoException
	 */
	public  ZJEvaluate showEvaluateDetailByEvaluateId( int id)throws Exception;
	public  List<ZJEvaluate>showEvaluatZJByEvaluateId( int id)throws Exception;

	/**
	 * 
	 * 方法描述：更新助教教评信息
	 * @param evaluate 更新的信息
	 */
	public void modifyEvaluate(ZJEvaluate evaluate);
	

	/**
	 * 
	 * 方法描述：删除助教教评信息
	 * @param id 教评id
	 */
	public void removeEvaluateById(String deleteId) throws Exception;
	
	/**
	 * 
	 * 方法描述：插入一条助教教评信息
	 * @param evaluate 插入信息
	 */
	public void createEvaluate(ZJEvaluate evaluate) throws Exception;
	/**
	 * 
	 * 方法描述： 查询所有的助教教评模板
	 * @return 所有助教教评模板的集合
	 */
	public List<ZJTemplate> showAllTemplate()throws Exception;
	/**
	 * 
	 * 方法描述：查询所有的助教
	 * @return  返回所有助教的集合
	 */
	public List<Assistant> showAllAssistant () throws Exception;
	
	@SuppressWarnings("unchecked")
	/**方法描述：根据条件查询助教教评信息
	 * @param: 封装查询信息
	 * @return 返回查询结果集
	 */
	public List<ZJEvaluate> showByCondition(SearchBean searchBean);
	/**
	 * 方法描述：生成助教教评的平均分
	 * @params:  教评id
	 */
	public void createAverageTotalScore(int id) throws Exception;
	/**
	 * 方法描述：根据助教教评id查询对应的助教教评详情集合
	 * @param: 助教教评id
	 * @return: 助教教评详情集合
	 */
	public List<ZJEvaluateDetail> showAllEvaluateDetailsByEvaluateId(int id) throws Exception;
	/**
	 * 方法描述：根据助教教评id 和模板id 查询助教教评打分情况和评价情况
	 * @param  返回学生打分情况的集合
	 */
	public List<String> showEvaluateItemDetail(int ZjEvaluteDetailId,int zjTemplateId);

	public  List<String> showScoreDetail(int zjEvaluteDetailId,int zjTemplateId);
	public  SearchBean showCommendDetail(int evaluteDetailId,int templateId)throws Exception;
	public List<ZJEvaluateDetail> showExportEvaluateDetailsByEvaluateId(int id) throws Exception;

}
