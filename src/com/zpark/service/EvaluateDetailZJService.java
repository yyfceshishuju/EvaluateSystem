package com.zpark.service;

import java.util.LinkedHashMap;

import com.zpark.entity.ZJEvaluate;
import com.zpark.entity.ZJEvaluateDetail;
import com.zpark.exception.NotFindTheEvaluationException;
import com.zpark.exception.RepeatSubmitException;

public interface EvaluateDetailZJService {
	 /**
	    * 
	    * ����������: ��ѯ��ǰ�����̲���
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
	    * ����������: �������̲�������
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
