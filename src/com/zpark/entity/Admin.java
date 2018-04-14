package com.zpark.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * 类的描述：Admin管理员javabean
 * 
 * @author：yangdd@zparkhr.com.cn
 * 
 * @create: 2013-7-18 下午4:34:29
 * 
 * @version: 1.0
 */
public class Admin {
	private Integer id;
	private String username;
	private String password;
	private String category;
	private String statu;
	private Date createDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStatu() {
		return statu;
	}

	public void setStatu(String statu) {
		this.statu = statu;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", username=" + username + ", password="
				+ password + ", category=" + category + ", statu=" + statu
				+ ", createDate=" + createDate + "]";
	}

}