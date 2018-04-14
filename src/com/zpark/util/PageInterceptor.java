package com.zpark.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class PageInterceptor implements Interceptor{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String srows = request.getParameter("rows");
		String spage = request.getParameter("page");
		if(srows != null && spage != null){
			int rows = Integer.parseInt(srows);
			int page = Integer.parseInt(spage);
		    
		    PageUtil.setPage(page, rows);
		}
		return ai.invoke();
		
	}
  
}
