package com.zpark.action.report;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.zpark.entity.Evaluate;
import com.zpark.entity.ZJEvaluate;
import com.zpark.service.EvaluateZjService;
import com.zpark.util.ExportCallback;
import com.zpark.util.ExportExcelCallback;
import com.zpark.util.ExportExcelData;
@Controller
@Scope("prototype")
public class ExportEvaluateZjAction implements Action {
	@Autowired
	private EvaluateZjService evaluateZjService;
	@ExportExcelData
	private List<ZJEvaluate> zjEvaluates; 
	public EvaluateZjService getEvaluateZjService() {
		return evaluateZjService;
	}
	public void setEvaluateZjService(EvaluateZjService evaluateZjService) {
		this.evaluateZjService = evaluateZjService;
	}
	public List<ZJEvaluate> getZjEvaluates() {
		return zjEvaluates;
	}
	public void setZjEvaluates(List<ZJEvaluate> zjEvaluates) {
		this.zjEvaluates = zjEvaluates;
	}
	@ExportExcelCallback
	private ExportCallback<ZJEvaluate> exb = new ExportCallback<ZJEvaluate>(){
		public String getFileName(){
			return "���̲���������ܱ�";
		}
		@Override
		public String getTitle() {
			// TODO Auto-generated method stub
			return "���̲�����Ϣ";
		}

		@Override
		public String[] getHeaders() {
			return new String[]{"���","�༶","�༶������","�༶ʵ������","�γ�",
					"ģ��ID","����ID","���","�÷�����","��ʼʱ��","����ʱ��","����ʱ��","״̬","����ԱID"};
		}

		@Override
		public Object[] getRow(ZJEvaluate rowObject) {
			return new Object[]{rowObject.getId(),rowObject.getClazz(),rowObject.getClazzCount(),
					rowObject.getRealCount(),rowObject.getSubject(),rowObject.getZjTemplate().getId(),
					rowObject.getAssistant().getId(),rowObject.getTotalScore(),rowObject.getScoreDetail(),
					new SimpleDateFormat("yyyy-MM-dd").format(rowObject.getBeginDate()),
					new SimpleDateFormat("yyyy-MM-dd").format(rowObject.getEndDate()),
					new SimpleDateFormat("yyyy-MM-dd").format(rowObject.getCreateDate()),
					rowObject.getStatu(),rowObject.getAdmin().getId()
			};
		}
	};
	@Override
	public String execute(){
		try{
			zjEvaluates = evaluateZjService.showAllEvaluate();
			if(zjEvaluates==null || zjEvaluates.size() == 0){
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
		return "success";
	}
}
