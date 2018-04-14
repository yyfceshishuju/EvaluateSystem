package com.zpark.service;

import java.util.LinkedHashMap;

import com.zpark.entity.Evaluate;
import com.zpark.entity.EvaluateDetail;
import com.zpark.exception.RepeatSubmitException;

public interface EvaluateDetailTeacherService {
	  /**
	   * 
	   * 方法的描述: 查询当天生成的教师测评表
	   * 
	   * @param @param clazz
	   * @param @return
	   * @param @throws Exception
	   * 
	   * @return: Evaluate
	   * 
	   *
	   */
	   public Evaluate showEvaluateByCreateDateAndClazz(String clazz)throws Exception;
	   
	   /**
	    * 
	    * 
	    * 方法的描述: 处理用户提交的测评数据
	    * 
	    * @param @param evaluateDetail
	    * @param @throws Exception
	    * 
	    * @return: void
	    * 
	    *
	    */
	   public void createEvaluateDetail(EvaluateDetail evaluateDetail,LinkedHashMap<String,String> inputeEvaluateItemDetailMap,LinkedHashMap<String,String> selectEvaluateItemDetailMap,Integer UserId)throws RepeatSubmitException, Exception;
}
