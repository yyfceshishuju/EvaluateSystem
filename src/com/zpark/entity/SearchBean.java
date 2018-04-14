package com.zpark.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class SearchBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String condition;
	private String content;
	private Date beginDate;
	private Date endDate;
	private int rows;
	private int page;
	private int id;
	private String itemName;
	private int score;
	private String itemContent;
	private List<String> inputItem;
	private List<String> commend1;
	private List<String> commend2;

	public String getItemContent() {
		return itemContent;
	}
	public void setItemContent(String itemContent) {
		this.itemContent = itemContent;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return condition+"---"+content+"---"+beginDate+"--"+endDate;
	}
	public List<String> getInputItem() {
		return inputItem;
	}
	public void setInputItem(List<String> inputItem) {
		this.inputItem = inputItem;
	}
	public List<String> getCommend1() {
		return commend1;
	}
	public void setCommend1(List<String> commend1) {
		this.commend1 = commend1;
	}
	public List<String> getCommend2() {
		return commend2;
	}
	public void setCommend2(List<String> commend2) {
		this.commend2 = commend2;
	}
	
	
}
