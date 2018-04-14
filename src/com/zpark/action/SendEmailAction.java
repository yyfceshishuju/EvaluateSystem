package com.zpark.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionSupport;
import com.zpark.entity.EmailMessage;
@Controller
public class SendEmailAction  extends ActionSupport{
	private EmailMessage messager;
	@Autowired
	private JavaMailSender mailSender;
	public EmailMessage getMessager() {
		return messager;
	}
	public void setMessager(EmailMessage messager) {
		this.messager = messager;
	}
	public String sendEmail(){
		try {
//			sender.setHost("smtp.zparkhr.com.cn");
//			sender.setUsername(messager.getSender());
//			sender.setPassword(messager.getPassword());
			SimpleMailMessage mail = new SimpleMailMessage();
		
			//��ȡ�ռ��˵�ַ
			String receivers = messager.getReceiver();
			String[] rec = receivers.split(";");
			
			//��ȡ������Ա�ʼ���ַ
			String cc = messager.getCopyReceiver();
			String[] str = null;
			if(cc != null){
				str = cc.split(";");
			}
			mail.setTo(rec);//�ռ���
//			mail.setFrom(messager.getSender());//������
			mail.setFrom(((JavaMailSenderImpl)mailSender).getUsername());
			mail.setSubject(messager.getTitle());//����
			if(str != null){
				mail.setCc(str);//���ó�����  
			}
			mail.setText(messager.getContent());//�ʼ�����
			mailSender.send(mail);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}	
		return SUCCESS;
	}
}
