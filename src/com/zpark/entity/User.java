package com.zpark.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * 
 * �������:  �û���Ϣʵ����.
 * 					�ṩ8������:
 * 				1��id:  �û��������
 * 				2��name: �û���
 * 				3��password: ����
 * 				4��passwordQuestion: ������ʾ����
 *				5��passwordAnswer: ������ʾ�����
 *				6��date: ע��ʱ��
 *				7��clazz: ѧ���༶
 *				8��statu: �û�״̬
 *				9��ip      �û���IP         
 *@author: wangyx@zparkhr.com.cn
 *
 * @create: 2013-7-18����6:09:18
 *
 *	@version 1.0
 */
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String password;
	private String passwordQuestion;
	private String passwordAnswer;
	private Date createDate;
	private String clazz;
	private String statu;
	private String ip;
	private List<EvaluateDetail> evaluateDetails = new ArrayList<EvaluateDetail>();
	private List<Evaluate> evaluates = new ArrayList<Evaluate>();
	
	private List<ZJEvaluateDetail> zjEvaluateDetails = new ArrayList<ZJEvaluateDetail>();
	private List<ZJEvaluate> zjEvaluates =  new ArrayList<ZJEvaluate>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordQuestion() {
		return passwordQuestion;
	}
	public void setPasswordQuestion(String passwordQuestion) {
		this.passwordQuestion = passwordQuestion;
	}
	public String getPasswordAnswer() {
		return passwordAnswer;
	}
	public void setPasswordAnswer(String passwordAnswer) {
		this.passwordAnswer = passwordAnswer;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public List<EvaluateDetail> getEvaluateDetails() {
		return evaluateDetails;
	}
	public void setEvaluateDetails(List<EvaluateDetail> evaluateDetails) {
		this.evaluateDetails = evaluateDetails;
	}
	public List<Evaluate> getEvaluates() {
		return evaluates;
	}
	public void setEvaluates(List<Evaluate> evaluates) {
		this.evaluates = evaluates;
	}
	public User(Integer id, String name, String password,
			String passwordQuestion, String passwordAnswer, Date createDate,
			String clazz, String statu, String ip,
			List<EvaluateDetail> evaluateDetails, List<Evaluate> evaluates) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.passwordQuestion = passwordQuestion;
		this.passwordAnswer = passwordAnswer;
		this.createDate = createDate;
		this.clazz = clazz;
		this.statu = statu;
		this.ip = ip;
		this.evaluateDetails = evaluateDetails;
		this.evaluates = evaluates;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<ZJEvaluateDetail> getZjEvaluateDetails() {
		return zjEvaluateDetails;
	}
	public void setZjEvaluateDetails(List<ZJEvaluateDetail> zjEvaluateDetails) {
		this.zjEvaluateDetails = zjEvaluateDetails;
	}
	public List<ZJEvaluate> getZjEvaluates() {
		return zjEvaluates;
	}
	public void setZjEvaluates(List<ZJEvaluate> zjEvaluates) {
		this.zjEvaluates = zjEvaluates;
	}
	@Override
	public String toString() {
		return "User [clazz=" + clazz + ", createDate=" + createDate + ", id="
				+ id + ", ip=" + ip + ", name=" + name + ", password="
				+ password + ", passwordAnswer=" + passwordAnswer
				+ ", passwordQuestion=" + passwordQuestion + ", statu=" + statu
				+ "]";
	}
	
}
