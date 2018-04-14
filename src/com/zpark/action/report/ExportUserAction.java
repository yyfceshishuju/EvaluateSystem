package com.zpark.action.report;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.zpark.entity.Evaluate;
import com.zpark.entity.User;
import com.zpark.service.EvaluateService;
import com.zpark.util.ExportCallback;
import com.zpark.util.ExportExcelCallback;
import com.zpark.util.ExportExcelData;
@Controller
@Scope("prototype")
public class ExportUserAction implements Action {
	private String clazz;
	@Autowired
	private EvaluateService evaluateService;
	@ExportExcelData
	private List<User> users;
	
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public EvaluateService getEvaluateService() {
		return evaluateService;
	}
	public void setEvaluateService(EvaluateService evaluateService) {
		this.evaluateService = evaluateService;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	@ExportExcelCallback
	private ExportCallback<User> exb = new ExportCallback<User>(){
		public String getFileName(){
			return "用户信息汇总表";
		}
		@Override
		public String getTitle() {
			// TODO Auto-generated method stub
			return "用户信息";
		}

		@Override
		public String[] getHeaders() {
			return new String[]{"编号","用户姓名","密码","密码提示问题","提示答案","创建时间","班级","状态","注册ip"};
		}

		@Override
		public Object[] getRow(User rowObject) {
			return new Object[]{rowObject.getId(),rowObject.getName(),rowObject.getPassword(),
					rowObject.getPasswordQuestion(),rowObject.getPasswordAnswer(),
					new SimpleDateFormat("yyyy-MM-dd").format(rowObject.getCreateDate()),
					rowObject.getClazz(),rowObject.getStatu(),rowObject.getIp()
				};
		}
	};
	@Override
	public String execute(){
		try{
			users = evaluateService.showUserByClazz(clazz);
			if(users==null || users.size() == 0){
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
		return "success";
	}
}
