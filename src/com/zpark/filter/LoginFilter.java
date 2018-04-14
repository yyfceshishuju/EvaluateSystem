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

/**
 * 
 * 
 * 类的描述: 判断是否有用户登录,如果没有则跳转登录页面
 *
 *@author: wangyx@zparkhr.com.cn
 *
 * @create: 2013-7-21下午12:46:22
 *
 *	@version 1.0
 */
public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest requ, ServletResponse rspon,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request =(HttpServletRequest)requ;
		HttpServletResponse response = (HttpServletResponse)rspon;
		Integer userId = (Integer)request.getSession(true).getAttribute("userId");
		

		String realuri =request.getServletPath();
		String uri1 ="/front/registration.jsp";
		String uri2 ="/front/loginFrontUserAction.action";
		String uri3="/front/getPassword.jsp";
		String uri4="/front/login.jsp";
		String uri5="/front/registerFrontUserAction.action";
		String uri6="/front/showUserByPasswordQuestionFrontUserAction.action";
		String uri7="/front/showUser.jsp";
		String uri8="/front/showEvaluateZJByCreateDateAndClazzShowEnvaluateFrontAction.action";
		String uri9="/front/zjevaluateSuccess.jsp";
		String uri10="/front/registrationSuccess.jsp";
		if(userId==null && !realuri.equals(uri4) && !realuri.equals(uri3) && !realuri.equals(uri2) && !realuri.equals(uri1) && !realuri.equals(uri5) && !realuri.equals(uri6) &&!realuri.equals(uri7)  &&!realuri.equals(uri8) &&!realuri.equals(uri9) &&!realuri.equals(uri10)){
			response.sendRedirect("/EvaluateSystem/front/login.jsp");
		}else{
		chain.doFilter(requ,rspon);
		}
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}


}
