package com.zpark.entity;

import java.sql.Date;

/**
 * 
 * 
 * 类的描述:助教教学评价详情信息实体
 * 					提供8个属性
 * 				1、id:  教学评价详情表主键
 * 				2、scoreDetail:  分值详情
 * 				3、commendDetail: 评价详情
 * 				4、totalScore: 总分
 *				5、create_date创建时间
 *				6、user:  用户表的关系属性
 *				7、userId:  用户表外键
 *				8、evaluateId:  助教测评表外键
 *@author: wangyx@zparkhr.com.cn
 *
 * @create: 2013-7-18下午6:51:13
 *
 *	@version 1.0
 */
public class ZJEvaluateDetail {
	private Integer id;
	private String scoreDetail;
	private String commendDetail;
	private Double totalScore;
	private ZJEvaluate zjevaluate;
	private User user;
	private Integer userId;
	private Integer zjevaluateId;
	private Date  createDate;
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
	public ZJEvaluate getZjevaluate() {
		return zjevaluate;
	}
	public void setZjevaluate(ZJEvaluate zjevaluate) {
		this.zjevaluate = zjevaluate;
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
	public Integer getZjevaluateId() {
		return zjevaluateId;
	}
	public void setZjevaluateId(Integer zjevaluateId) {
		this.zjevaluateId = zjevaluateId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public ZJEvaluateDetail(Integer id, String scoreDetail,
			String commendDetail, Double totalScore, ZJEvaluate zjevaluate,
			User user, Integer userId, Integer zjevaluateId, Date createDate) {
		super();
		this.id = id;
		this.scoreDetail = scoreDetail;
		this.commendDetail = commendDetail;
		this.totalScore = totalScore;
		this.zjevaluate = zjevaluate;
		this.user = user;
		this.userId = userId;
		this.zjevaluateId = zjevaluateId;
		this.createDate = createDate;
	}
	public ZJEvaluateDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
