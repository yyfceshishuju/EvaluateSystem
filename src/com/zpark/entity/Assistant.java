package com.zpark.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * 类描述：助教实体类
 * @author qutt@zparkhr.com.cn
 *
 */
public class Assistant implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String assistantName;
	private String username;
	private String password;
	private List<ZJEvaluate> ZjEvaluates = new ArrayList<ZJEvaluate>();
	
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAssistantName() {
		return assistantName;
	}
	public void setAssistantName(String assistantName) {
		this.assistantName = assistantName;
	}
	public List<ZJEvaluate> getZjEvaluates() {
		return ZjEvaluates;
	}
	public void setZjEvaluates(List<ZJEvaluate> zjEvaluates) {
		ZjEvaluates = zjEvaluates;
	}
	
}
