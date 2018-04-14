package com.zpark.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zpark.dao.EvaluateDetailDAO;
import com.zpark.dao.EvaluateDetailZJDAO;
import com.zpark.dao.TemplateDAO;
import com.zpark.dao.TemplateZJDAO;
import com.zpark.dao.UserDAO;
import com.zpark.entity.ZJEvaluate;
import com.zpark.entity.ZJEvaluateDetail;
import com.zpark.entity.ZJEvaluateItem;
import com.zpark.entity.ZJTemplate;
import com.zpark.exception.NotFindTheEvaluationException;
import com.zpark.exception.RepeatSubmitException;
import com.zpark.util.GenerationDetailUtil;
@Service
public class EvaluateDetailZJServiceImpl implements EvaluateDetailZJService {
	private Logger logger = Logger.getLogger(EvaluateDetailZJServiceImpl.class);
	
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private EvaluateDetailZJDAO evaluateDetailZJDAO;
	@Autowired
	private TemplateZJDAO templatezjDAO;
	
	@Transactional
	public ZJEvaluate showEvaluateZJByCreateDateAndClazz(String clazz) throws NotFindTheEvaluationException, Exception {
			try {
				logger.info("[into showEvaluateZJByCreateDateAndClazz method]");
				ZJEvaluate zjevaluate =userDAO.queryEvaluateZJByCreateDateAndCalzz(clazz);
				if(zjevaluate==null){
					throw new NotFindTheEvaluationException("没有可用的测评");
				}else{
				
					ZJTemplate zjtemplate =templatezjDAO.queryZJTemplateById(zjevaluate.getZjTemplateId());
					List<String> selectItem = new ArrayList<String>();
					List<String> inputItem = new ArrayList<String>();

					for(ZJEvaluateItem e: zjtemplate.getZjevaluateItems()){
						if(e.getItemCategory().equals("selector")){
							selectItem.add(e.getItemName());
							
						}else{
							inputItem.add(e.getItemName());
						}
					}
					zjtemplate.setInputItem(inputItem);
					zjtemplate.setSelectItem(selectItem);
					zjevaluate.setZjTemplate(zjtemplate);
					}
				logger.debug("[ showEvaluateZJByCreateDateAndClazz method performs normal ]");
				return zjevaluate;
			} catch (NotFindTheEvaluationException e) {
	            logger.error("[ method showEvaluateZJByCreateDateAndClazz ]", e);
	            throw e;
			}catch(Exception e){
	            logger.error("[ method findUserByPasswordQuestion ]", e);
				throw e;
				
			}
		
	}
	
		
		@Transactional(rollbackFor=java.lang.RuntimeException.class)
		public void createZJEvaluateDetail(ZJEvaluateDetail zjevaluateDetail,LinkedHashMap<String,String> inputeEvaluateItemDetailMap,LinkedHashMap<String,String> selectEvaluateItemDetailMap,Integer UserId)throws RepeatSubmitException, Exception{
			
			
			try {
				logger.info("[into createEvaluateDetail method]");
				
				ZJEvaluateDetail evaluateDt = evaluateDetailZJDAO.queryZJEvaluateDetailByUserIdOrderByCreateDate(UserId);
				if(evaluateDt!=null){
					long a =(new java.util.Date().getTime()-evaluateDt.getCreateDate().getTime())/24/60/60/1000;
					if(a<1){
						throw new RepeatSubmitException("请不要重复测评");
					}
				}
				String[] detail =GenerationDetailUtil.getDetailAndTotalScore(inputeEvaluateItemDetailMap,selectEvaluateItemDetailMap);
				zjevaluateDetail.setCreateDate(new Date(new java.util.Date().getTime()));
				zjevaluateDetail.setScoreDetail(detail[0]);
				zjevaluateDetail.setCommendDetail(detail[1]);
				zjevaluateDetail.setTotalScore(Double.valueOf(detail[2]));	
				zjevaluateDetail.setUserId(UserId);
				evaluateDetailZJDAO.saveZJEvaluateDetail(zjevaluateDetail);

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
