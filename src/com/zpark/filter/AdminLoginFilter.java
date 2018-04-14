package com.zpark.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zpark.entity.Assistant;
import com.zpark.entity.Teacher;

/**
 * 类的描述: 判断是否有用户登录,如果没有则跳转登录页面
 * 
 * @author: wangyx@zparkhr.com.cn
 * @create: 2013-7-21下午12:46:22
 * @version 1.0
 */
public class AdminLoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest requ, ServletResponse rspon,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) requ;
		HttpServletResponse response = (HttpServletResponse) rspon;
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Integer adminId = (Integer) request.getSession(true).getAttribute(
				"nowAdminId");
		Teacher t = (Teacher)request.getSession(true).getAttribute("teacher");
		Assistant a = (Assistant)request.getSession(true).getAttribute("assistant");
		String realuri =request.getServletPath();
		String uri ="/bgTemplate/Admin_login.action";
		if (adminId == null && !realuri.equals(uri) && t == null && a == null) {
			response.sendRedirect("/EvaluateSystem/mangerLogin.jsp");
		} else {
			chain.doFilter(requ, rspon);
		}
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
