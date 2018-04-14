package com.zpark.entity;

import java.sql.Date;

/**
 * 
 * 
 * �������:��ѧ����������Ϣʵ��
 * 					�ṩ4������
 * 				1��id:  ��ѧ�������������
 * 				2��scoreDetail:  ��ֵ����
 * 				3��commendDetail: ��������
 * 				4��totalScore: �ܷ�
 *
 *@author: wangyx@zparkhr.com.cn
 *
 * @create: 2013-7-18����6:51:13
 *
 *	@version 1.0
 */
public class EvaluateDetail {
	private Integer id;
	private String scoreDetail;
	private String commendDetail;
	private Double totalScore;
	private Evaluate evaluate;
	private User user;
	private Integer userId;
	private Integer evaluateId;
	private Date  createDate;
	public EvaluateDetail(Integer id, String scoreDetail, String commendDetail,
			Double totalScore, Evaluate evaluate, User user, Integer userId,
			Integer evaluateId, Date createDate) {
		super();
		this.id = id;
		this.scoreDetail = scoreDetail;
		this.commendDetail = commendDetail;
		this.totalScore = totalScore;
		this.evaluate = evaluate;
		this.user = user;
		this.userId = userId;
		this.evaluateId = evaluateId;
		this.createDate = createDate;
	}
	public EvaluateDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getScoreDetail() {
		return scoreDetail;
	}
	public void setScoreDetail(String scoreDetail) {
		this.scoreDetail = scoreDetail;
	}
	public String getCommendDetail() {
		return commendDetail;
	}
	public void setCommendDetail(String commendDetail) {
		this.commendDetail = commendDetail;
	}
	public Double getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(Double totalScore) {
		this.totalScore = totalScore;
	}
	public Evaluate getEvaluate() {
		return evaluate;
	}
	public void setEvaluate(Evaluate evaluate) {
		this.evaluate = evaluate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getEvaluateId() {
		return evaluateId;
	}
	public void setEvaluateId(Integer evaluateId) {
		this.evaluateId = evaluateId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "EvaluateDetail [commendDetail=" + commendDetail
				+ ", createDate=" + createDate + ", id=" + id
				+ ", scoreDetail=" + scoreDetail + ", totalScore=" + totalScore
				+ "]";
	}
	
	
}
