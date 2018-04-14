package com.zpark.service;

import java.util.LinkedHashMap;

import com.zpark.entity.Evaluate;
import com.zpark.entity.EvaluateDetail;
import com.zpark.exception.RepeatSubmitException;

public interface EvaluateDetailTeacherService {
	  /**
	   * 
	   * ����������: ��ѯ�������ɵĽ�ʦ������
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
	    * ����������: �����û��ύ�Ĳ�������
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
