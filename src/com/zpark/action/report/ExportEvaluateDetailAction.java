package com.zpark.action.report;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.zpark.entity.Evaluate;
import com.zpark.entity.EvaluateDetail;
import com.zpark.service.EvaluateService;
import com.zpark.util.ExportCallback;
import com.zpark.util.ExportExcelCallback;
import com.zpark.util.ExportExcelData;
@Controller
@Scope("prototype")
public class ExportEvaluateDetailAction implements Action {
	@Autowired
	private EvaluateService evaluateService;
	
	@ExportExcelData
	private List<EvaluateDetail> evaluateDetails;
	private int evaluateId;
	public int getEvaluateId() {
		return evaluateId;
	}
	public void setEvaluateId(int evaluateId) {
		this.evaluateId = evaluateId;
	}
	public EvaluateService getEvaluateService() {
		return evaluateService;
	}
	public void setEvaluateService(EvaluateService evaluateService) {
		this.evaluateService = evaluateService;
	}

	public List<EvaluateDetail> getEvaluateDetails() {
		return evaluateDetails;
	}

	public void setEvaluateDetails(List<EvaluateDetail> evaluateDetails) {
		this.evaluateDetails = evaluateDetails;
	}

	@ExportExcelCallback
	private ExportCallback<EvaluateDetail> exb = new ExportCallback<EvaluateDetail>(){
		public String getFileName(){
			String str = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
			return str+"讲师测评详细情况汇总表";
		}
		@Override
		public String getTitle() {
			return "讲师测评详细信息";
		}

		@Override
		public String[] getHeaders() {
			return new String[]{"编号","学生编号","评分详情","评论详情","教评id","平均分","提交时间"};
		}

		@Override
		public Object[] getRow(EvaluateDetail rowObject) {
			return new Object[]{rowObject.getId(),rowObject.getUser().getId(),rowObject.getScoreDetail(),
					rowObject.getCommendDetail(),rowObject.getEvaluate().getId(),rowObject.getTotalScore(),
					new SimpleDateFormat("yyyy-MM-dd").format(rowObject.getCreateDate())};
		}
	};
	@Override
	public String execute() {
		try{
			evaluateDetails = evaluateService.showExportEvaluateDetailsByEvaluateId(evaluateId);
			if(evaluateDetails==null || evaluateDetails.size() == 0){
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
		return "success";
	}

}
