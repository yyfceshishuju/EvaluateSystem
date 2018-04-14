package com.zpark.action.report;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.zpark.entity.Evaluate;

import com.zpark.service.EvaluateService;
import com.zpark.util.ExportCallback;
import com.zpark.util.ExportExcelCallback;
import com.zpark.util.ExportExcelData;
@Controller
@Scope("prototype")
public class ExportEvaluateAction implements Action{
	@ExportExcelData
	private List<Evaluate> evaluates; 

	public List<Evaluate> getEvaluates() {
		return evaluates;
	}
	public void setEvaluates(List<Evaluate> evaluates) {
		this.evaluates = evaluates;
	}
	@Autowired
	private EvaluateService evaluateService;
	
	public EvaluateService getEvaluateService() {
		return evaluateService;
	}
	public void setEvaluateService(EvaluateService evaluateService) {
		this.evaluateService = evaluateService;
	}
	@ExportExcelCallback
	private ExportCallback<Evaluate> exb = new ExportCallback<Evaluate>(){
		public String getFileName(){
			return "��ʦ�������ܱ�";
		}
		@Override
		public String getTitle() {
			// TODO Auto-generated method stub
			return "��ʦ������Ϣ";
		}

		@Override
		public String[] getHeaders() {
			return new String[]{"���","�༶","�༶������","�༶ʵ������","�γ�",
						"ģ��ID","��ʦID","���","�÷�����","��ʼʱ��","����ʱ��","����ʱ��","״̬","����ԱID"};
		}

		@Override
		public Object[] getRow(Evaluate rowObject) {
			return new Object[]{rowObject.getId(),rowObject.getClazz(),rowObject.getClazzCount(),
					rowObject.getRealCount(),rowObject.getSubject(),rowObject.getTemplate().getId(),
					rowObject.getTeacher().getId(),rowObject.getTotalScore(),rowObject.getScoreDetail(),
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
			evaluates = evaluateService.showAllEvaluate();
			if(evaluates==null || evaluates.size() == 0){
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
		return "success";
	}
}