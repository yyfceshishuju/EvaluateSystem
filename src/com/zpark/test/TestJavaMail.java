package com.zpark.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class TestJavaMail {
	public static ApplicationContext ctx = null;
	
	public static  void send() {
		//��ȡJavaMailSender bean
		ctx = new ClassPathXmlApplicationContext("classpath:com/zpark/config/spring/applicationContext-mail.xml");
//		JavaMailSenderImpl sender = (JavaMailSenderImpl) ctx.getBean("mailSender");
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		sender.setHost("smtp.qq.com");
		sender.setUsername("591469580@qq.com");
		sender.setPassword("quaotao@0607");
		
		System.out.println(sender.getHost());
		SimpleMailMessage mail = new SimpleMailMessage(); //<span style="color: rgb(255, 0, 0);">ע��SimpleMailMessageֻ����������text��ʽ���ʼ�</span>
		String[] str = new String[]{"410089109@qq.com","qutt2011@hotmail.com"};
		try {
			mail.setTo("qutaotao0607@163.com");//������
			mail.setFrom("591469580@qq.com");//������,���ﻹ��������Email�����ú�xml���usernameһ��
			mail.setSubject("spring mail test!");//����
//			if (mail.getCc() != null && !"".equals(mail.getCc())) {
//				 mail.setCc(str);//���ó�����  
//			}
			   
			mail.setText("springMail�ļ򵥷��Ͳ���");//�ʼ�����
			sender.send(mail);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]){
		send();
	}
}
