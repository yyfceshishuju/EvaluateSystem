package com.zpark.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zpark.dao.EvaluateDetailDAO;
import com.zpark.dao.EvaluateDetailZJDAO;
import com.zpark.dao.TemplateDAO;
import com.zpark.dao.TemplateZJDAO;
import com.zpark.dao.UserDAO;
import com.zpark.entity.Evaluate;
import com.zpark.entity.EvaluateDetail;
import com.zpark.entity.EvaluateItem;
import com.zpark.entity.Template;
import com.zpark.exception.NotFindTheEvaluationException;
import com.zpark.exception.RepeatSubmitException;
import com.zpark.util.GenerationDetailUtil;
@Service
public class EvaluateDetailTeacherServiceImpl implements
		EvaluateDetailTeacherService {
			
		private Logger logger = Logger.getLogger(EvaluateDetailTeacherServiceImpl.class);
	
		@Autowired
		private UserDAO userDAO;
		@Autowired
		private EvaluateDetailDAO evaluateDetailDAO;
		@Autowired
		private TemplateDAO templateDAO;
		@Autowired
		private EvaluateDetailZJDAO evaluateDetailZJDAO;
		@Autowired
		private TemplateZJDAO templatezjDAO;
		
		
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public Evaluate showEvaluateByCreateDateAndClazz(String clazz)
			throws Exception {
		try {
			logger.info("[into findUserByPasswordQuestion method]");
			Evaluate evaluate =userDAO.queryEvaluateByCreateDateAndCalzz(clazz);
			if(evaluate==null){
				throw new NotFindTheEvaluationException("没有可用的测评");
			}else{
				Template template =templateDAO.queryTemplateById(evaluate.getTemplateId());
				
				List<String> selectItem = new ArrayList<String>();
				List<String> inputItem = new ArrayList<String>();

				for(EvaluateItem e: template.getEvaluateItems()){
					if(e.getItemCategory().equals("selector")){
						selectItem.add(e.getItemName());
						
					}else{
						inputItem.add(e.getItemName());
					}
				}
				template.setInputItem(inputItem);
				template.setSelectItem(selectItem);
				evaluate.setTemplate(template);
			logger.debug("[ findUserByPasswordQuestion method performs normal ]");
			return evaluate;
			}
		} catch (NotFindTheEvaluationException e) {
            logger.error("[ method findUserByPasswordQuestion ]", e);
            throw e;
		}catch(Exception e){
            logger.error("[ method findUserByPasswordQuestion ]", e);
			throw e;
			
		}
	}

	@Transactional(rollbackFor=java.lang.RuntimeException.class)
	public void createEvaluateDetail(EvaluateDetail evaluateDetail,LinkedHashMap<String,String> inputeEvaluateItemDetailMap,LinkedHashMap<String,String> selectEvaluateItemDetailMap,Integer UserId)throws RepeatSubmitException, Exception{
		
		
		try {
			logger.info("[into createEvaluateDetail method]");
			
			EvaluateDetail evaluateDt = evaluateDetailDAO.queryEvaluateDetailByUserIdOrderByCreateDate(UserId);
			if(evaluateDt!=null){
				long a =(new java.util.Date().getTime()-evaluateDt.getCreateDate().getTime())/24/60/60/1000;
				if(a<1){
					throw new RepeatSubmitException("请不要重复测评");
				}
			}
			
			
			
			String[] detail =GenerationDetailUtil.getDetailAndTotalScore(inputeEvaluateItemDetailMap,selectEvaluateItemDetailMap);
			evaluateDetail.setCreateDate(new Date(new java.util.Date().getTime()));
			evaluateDetail.setScoreDetail(detail[0]);
			evaluateDetail.setCommendDetail(detail[1]);
			evaluateDetail.setTotalScore(Double.valueOf(detail[2]));	
			evaluateDetail.setUserId(UserId);
			evaluateDetailDAO.saveEvaluateDetail(evaluateDetail);
			
			logger.debug("[ createEvaluateDetail method performs normal ]");
		}catch(RepeatSubmitException e){
			logger.error("[method createEvaluateDetail]",e);
			throw e;
		} catch (Exception e) {
            logger.error("[ method createEvaluateDetail ]", e);
            throw e;
		}
	}
 }
