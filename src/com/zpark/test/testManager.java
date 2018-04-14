package com.zpark.test;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zpark.entity.Admin;
import com.zpark.entity.Evaluate;
import com.zpark.entity.SearchBean;
import com.zpark.entity.ZJEvaluate;
import com.zpark.service.EvaluateService;
import com.zpark.service.EvaluateZjService;
import com.zpark.service.TemplateService;

public class testManager {
	public static void main(String ars[]) throws Exception{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		EvaluateZjService ms = (EvaluateZjService)ac.getBean("evaluateZjService");
//		ZjEvaluate ze = new ZjEvaluate();
//		Admin admin = new Admin();
//		admin.setId(1);
//		ze.setAdmin(admin);
//		ms.createEvaluate(ze);
		
		EvaluateService ms = (EvaluateService)ac.getBean("evaluateService");
		SearchBean sb = new SearchBean();
		sb.setCondition("teacherName");
		sb.setContent("ÐìÕ×æÂ");
		List<Evaluate> list = ms.showByCondition(sb);
		System.out.println(list.size());
//		ms.showEvaluateItemDetail(2,1);
	//	ms.showAllTemplate().size();
//		SearchBean sn= new SearchBean();
//		sn.setCondition("studentName");
//		sn.setContent("zhangs");
//		System.out.println(ms.showByCondition(sn).get(0).getCommendDetail());
		
//		List<Evaluate> list = ms.showAllEvaluate();
//		System.out.println(list.size());
//		List<EvaluateDetail> list = ms.showEvaluateDetailByEvaluateId(3).getEvaluateDetailList();
//		for(EvaluateDetail ed:list){
//			System.out.println(ed.getUser().getName());
//		}
//		Evaluate e = new Evaluate();
//		Teacher t = new Teacher();
//		t.setId(2);
//		e.setTeacher(t);
//		e.setSubject("jquery");
//		ms.createEvaluate(e);
		
//		SearchBean sb = new SearchBean();
//		sb.setContent("aa");
//		List list = ms.showByCondition(sb);
//		System.out.println(list.size());
	//	GenerationDetailUtil.getCommentList("4:sdfsd;6:sdfdsfdsf");
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
//		String str = sdf.format(new Date(new java.util.Date().getTime()));
//		System.out.println(str);
	}
}
