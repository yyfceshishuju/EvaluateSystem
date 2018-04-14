package com.zpark.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * 类的描述：讲师的实体类
 * @author qutt@zparkhr.com.cn
 * @time 2013-7-19 上午10:41:12
 * @version 1.1
 */
public class Teacher implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String teacherName;
	private String username;
	private String password;
	private List<Evaluate> evalulateList = new ArrayList<Evaluate>();

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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<Evaluate> getEvalulateList() {
		return evalulateList;
	}
	public void setEvalulateList(List<Evaluate> evalulateList) {
		this.evalulateList = evalulateList;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	
}
