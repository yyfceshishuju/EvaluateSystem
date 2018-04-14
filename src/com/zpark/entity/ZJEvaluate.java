package com.zpark.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 类描述：助教的测评实体类
 * @author qutt@zparkhr.com.cn
 *
 */
public class ZJEvaluate implements Serializable {
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
	private Assistant assistant;
	private ZJTemplate zjTemplate;
	private Admin admin;
	private Integer ZjTemplateId;
	private ZJEvaluateItem zjEvaluateItem;
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
	public Integer getClazzCount() {
		return clazzCount;
	}
	public void setClazzCount(Integer clazzCount) {
		this.clazzCount = clazzCount;
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
	
	public Assistant getAssistant() {
		return assistant;
	}
	public void setAssistant(Assistant assistant) {
		this.assistant = assistant;
	}
	public ZJTemplate getZjTemplate() {
		return zjTemplate;
	}
	public void setZjTemplate(ZJTemplate zjTemplate) {
		this.zjTemplate = zjTemplate;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public ZJEvaluateItem getZjEvaluateItem() {
		return zjEvaluateItem;
	}
	public void setZjEvaluateItem(ZJEvaluateItem zjEvaluateItem) {
		this.zjEvaluateItem = zjEvaluateItem;
	}
	public void setZjTemplateId(Integer zjTemplateId) {
		ZjTemplateId = zjTemplateId;
	}
	public Integer getZjTemplateId() {
		return ZjTemplateId;
	}
	
	
}
