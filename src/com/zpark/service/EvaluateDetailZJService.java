package com.zpark.service;

import java.util.LinkedHashMap;

import com.zpark.entity.ZJEvaluate;
import com.zpark.entity.ZJEvaluateDetail;
import com.zpark.exception.NotFindTheEvaluationException;
import com.zpark.exception.RepeatSubmitException;

public interface EvaluateDetailZJService {
	 /**
	    * 
	    * 方法的描述: 查询当前的助教测评
	    * 
	    * @param @param clazz
	    * @param @return
	    * 
	    * @return: ZJEvaluate
	    * 
	    *
	    */
	   public ZJEvaluate showEvaluateZJByCreateDateAndClazz(String clazz) throws NotFindTheEvaluationException, Exception;

	   /**
	    * 
	    * 
	    * 方法的描述: 生成助教测评详情
	    * 
	    * @param @param zjevaluateDetail
	    * @param @param inputeEvaluateItemDetailMap
	    * @param @param selectEvaluateItemDetailMap
	    * @param @param UserId
	    * @param @throws RepeatSubmitException
	    * @param @throws Exception
	    * 
	    * @return: void
	    * 
	    *
	    */
	   public void createZJEvaluateDetail(ZJEvaluateDetail zjevaluateDetail,LinkedHashMap<String,String> inputeEvaluateItemDetailMap,LinkedHashMap<String,String> selectEvaluateItemDetailMap,Integer UserId)throws RepeatSubmitException ,Exception;
	
	
	
	
	
}
