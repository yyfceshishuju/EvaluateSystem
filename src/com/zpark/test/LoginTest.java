package com.zpark.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zpark.service.ReportDataService;
import com.zpark.service.ReportDataServiceImpl;
import com.zpark.service.RoleService;

public class LoginTest {
	public static void main(String[] args) {
		System.out.println(2);
		System.err.print(2);
//		ApplicationContext ax = new ClassPathXmlApplicationContext(
//				"applicationContext.xml");
//		RoleService roleService = (RoleService) ax.getBean("roleService");
		/*
		 * Integer id = roleService.teacherLogin("huxz@zparkhr.com.cn", "123");
		 * System.out.println(id);
		 */
//		Integer id = roleService.assistantLogin("yangdd@zparkhr.com.cn", "123");
//		System.out.println(id);
//		roleService.teacherModifyPassword(1, "huxz@zparkhr.com.cn", "111");
//		ReportDataService rs= new ReportDataServiceImpl();
//		Map map = new HashMap<>();
//		rs.createAssistantData(map);
	}
}
