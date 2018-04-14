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
		
			//获取收件人地址
			String receivers = messager.getReceiver();
			String[] rec = receivers.split(";");
			
			//获取抄送人员邮件地址
			String cc = messager.getCopyReceiver();
			String[] str = null;
			if(cc != null){
				str = cc.split(";");
			}
			mail.setTo(rec);//收件人
//			mail.setFrom(messager.getSender());//发件人
			mail.setFrom(((JavaMailSenderImpl)mailSender).getUsername());
			mail.setSubject(messager.getTitle());//主题
			if(str != null){
				mail.setCc(str);//设置抄送人  
			}
			mail.setText(messager.getContent());//邮件内容
			mailSender.send(mail);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}	
		return SUCCESS;
	}
}
