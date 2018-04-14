package com.zpark.action.report;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.zpark.entity.EvaluateDetail;
import com.zpark.entity.ZJEvaluateDetail;
import com.zpark.service.EvaluateService;
import com.zpark.service.EvaluateZjService;
import com.zpark.util.ExportCallback;
import com.zpark.util.ExportExcelCallback;
import com.zpark.util.ExportExcelData;
@Controller
@Scope("prototype")
public class ExportEvaluateDetailZJAction implements Action{
	@Autowired
	private EvaluateZjService evaluateZjService;
	private int evaluateId;
	@ExportExcelData
	private List<ZJEvaluateDetail> zjEvaluateDetails;
	
	public EvaluateZjService getEvaluateZjService() {
		return evaluateZjService;
	}
	public void setEvaluateZjService(EvaluateZjService evaluateZjService) {
		this.evaluateZjService = evaluateZjService;
	}
	public List<ZJEvaluateDetail> getZjEvaluateDetails() {
		return zjEvaluateDetails;
	}
	public void setZjEvaluateDetails(List<ZJEvaluateDetail> zjEvaluateDetails) {
		this.zjEvaluateDetails = zjEvaluateDetails;
	}
	public int getEvaluateId() {
		return evaluateId;
	}
	public void setEvaluateId(int evaluateId) {
		this.evaluateId = evaluateId;
	}
	@ExportExcelCallback
	private ExportCallback<ZJEvaluateDetail> exb = new ExportCallback<ZJEvaluateDetail>(){
		public String getFileName(){
			String str = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
			return str+"助教测评详细情况汇总表";
		}
		@Override
		public String getTitle() {
			return "助教测评详细信息";
		}

		@Override
		public String[] getHeaders() {
			return new String[]{"编号","学生编号","评分详情","评论详情","教评id","平均分","提交时间"};
		}

		@Override
		public Object[] getRow(ZJEvaluateDetail rowObject) {
			return new Object[]{rowObject.getId(),rowObject.getUser().getId(),rowObject.getScoreDetail(),
					rowObject.getCommendDetail(),rowObject.getZjevaluate().getId(),rowObject.getTotalScore(),
					new SimpleDateFormat("yyyy-MM-dd").format(rowObject.getCreateDate())};
		}
	};
	@Override
	public String execute(){
		try{
			zjEvaluateDetails = evaluateZjService.showExportEvaluateDetailsByEvaluateId(evaluateId);
			if(zjEvaluateDetails==null || zjEvaluateDetails.size() == 0){
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
		return "success";
	}
}
