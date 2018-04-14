package com.zpark.entity;

import java.io.Serializable;

import java.util.Date;
/**
 * 
 * 类的描述：教评实体类
 * @author qutt@zparkhr.com.cn
 * @time 2013-7-19 上午10:40:19
 * @version 1.1
 */
public class Evaluate implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private	String subject;
	private Integer clazzCount;
	private Integer realCount;
	private double totalScore;
	private String scoreDetail;
	private Date createDate;
	private Date endDate;
	private String commendDetail; 
	private String clazz;
	private Date beginDate;
	private String statu;
	private Teacher teacher;
	private Template template;
	private Admin admin;
	private Integer templateId;
	private EvaluateItem evaluateItem;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public Integer getRealCount() {
		return realCount;
	}
	public void setRealCount(Integer realCount) {
		this.realCount = realCount;
	}
	public Double getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(Double totalScore) {
		this.totalScore = totalScore;
	}
	public String getScoreDetail() {
		return scoreDetail;
	}
	public void setScoreDetail(String scoreDetail) {
		this.scoreDetail = scoreDetail;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getCommendDetail() {
		return commendDetail;
	}
	public void setCommendDetail(String commendDetail) {
		this.commendDetail = commendDetail;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Template getTemplate() {
		return template;
	}
	public void setTemplate(Template template) {
		this.template = template;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Integer getTemplateId() {
		return templateId;
	}
	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}
	public EvaluateItem getEvaluateItem() {
		return evaluateItem;
	}
	public void setEvaluateItem(EvaluateItem evaluateItem) {
		this.evaluateItem = evaluateItem;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getClazzCount() {
		return clazzCount;
	}
	public void setClazzCount(Integer clazzCount) {
		this.clazzCount = clazzCount;
	}
	public Evaluate(Integer id, String subject, Integer clazzCount,
			Integer realCount, Double totalScore, String scoreDetail,
			Date createDate, Date endDate, String commendDetail, String clazz,
			Date beginDate, String statu, Teacher teacher, Template template,
			Admin admin, Integer templateId, EvaluateItem evaluateItem) {
		super();
		this.id = id;
		this.subject = subject;
	
		this.realCount = realCount;
		this.totalScore = totalScore;
		this.scoreDetail = scoreDetail;
		this.createDate = createDate;
		this.endDate = endDate;
		this.commendDetail = commendDetail;
		this.clazz = clazz;
		this.beginDate = beginDate;
		this.statu = statu;
		this.teacher = teacher;
		this.template = template;
		this.admin = admin;
		this.templateId = templateId;
		this.evaluateItem = evaluateItem;
	}
	
	
	public Evaluate() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Evaluate [beginDate=" + beginDate + ", clazz=" + clazz
				+ ", clazzCount=" + clazzCount + ", createDate=" + createDate
				+ ", endDate=" + endDate + ", id=" + id + ", realCount="
				+ realCount + ", scoreDetail=" + scoreDetail + ", statu="
				+ statu + ", subject=" + subject + ", totalScore=" + totalScore
				+ "]";
	}
	
}
