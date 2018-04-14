package com.zpark.entity;

import java.util.Date;

/**
 * 
 * 类的描述：教评项的javaBean
 * 
 * @author：yangdd@zparkhr.com.cn
 * 
 * @create: 2013-7-18 下午4:32:32
 * 
 * @version: 1.0
 */
public class EvaluateItem {
	private Integer id;
	private String itemName;
	private Integer itemScore;
	private String itemCategory;
	private Date createDate;
	private String statu;// 表示状态y表示可用,n表示不可用
	private Integer adminId;
	private String isDelete;
	private String adminName;
	
	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	private Admin admin;
	
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getItemScore() {
		return itemScore;
	}

	public void setItemScore(Integer itemScore) {
		this.itemScore = itemScore;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	

	public String getStatu() {
		return statu;
	}

	public void setStatu(String statu) {
		this.statu = statu;
	}

	@Override
	public String toString() {
		return "EvaluateItem [id=" + id + ", itemName=" + itemName
				+ ", itemScore=" + itemScore + ", itemCategory=" + itemCategory
				+ ", createDate=" + createDate + ", statu=" + statu + "]";
	}
}
