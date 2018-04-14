package com.zpark.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;

public class ExportExcelResult implements Result{
    
	@Override
	public void execute(ActionInvocation ai) throws Exception {
		ExportCallback<?> callback = getExportCallback(ai);
	    List<?> data = getExportExcelData(ai);
	    HttpServletResponse response = ServletActionContext.getResponse();
	    
	    if(callback!=null && data!=null){
	        ExcelExporter excelExporter  = new ExcelExporter(data);
	    	excelExporter.export(response , callback);
	    	
	    }else{
	    	throw new RuntimeException("excel export error ");
	    }
		
	}
	
	private ExportCallback<?> getExportCallback(ActionInvocation ai) throws Exception{
		 Action targetAction = (Action)ai.getAction();
		 Field[] fields = targetAction.getClass().getDeclaredFields();
		 for(Field field:fields){
		    field.setAccessible(true);
		    Annotation exportExcelDataAnnotation = field.getAnnotation(ExportExcelCallback.class);
		    if(exportExcelDataAnnotation!=null){
		    	return (ExportCallback<?>)field.get(targetAction);
		    }
		 }
		return null;
	}
	
	private List<?> getExportExcelData(ActionInvocation ai) throws Exception{
		 Action targetAction = (Action)ai.getAction();
		 Field[] fields = targetAction.getClass().getDeclaredFields();
		 for(Field field:fields){
		    field.setAccessible(true);
		    Annotation exportExcelDataAnnotation = field.getAnnotation(ExportExcelData.class);
		    if(exportExcelDataAnnotation!=null){
		    	return (List<?>)field.get(targetAction);
		    }
		 }
		return null;
	}
	

}
