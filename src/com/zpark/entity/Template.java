package com.zpark.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * 类的描述：教评模板的javaBean
 * 
 * @author：yangdd@zparkhr.com.cn
 * 
 * @create: 2013-7-18 下午4:33:25
 * 
 * @version: 1.0
 */
public class Template {
	private Integer id;
	private String templateName;
	private Date createDate;
	private String statu;// 状态y表示可用,n表示不可用
	private String isDefault;// 是否默认,y表示是默认,n表示非默认
	private Integer adminId;
	private Admin admin;
	private List<EvaluateItem> evaluateItems;
	private List<Evaluate>  evaluateList = new ArrayList<Evaluate>();
	private List<String>selectItem;
	private List<String> inputItem;
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

	public Template() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Template(Integer id, String templateName, Date createDate,
			String statu, String isDefault, Integer adminId, Admin admin,
			List<EvaluateItem> evaluateItems, List<Evaluate> evaluateList,
			List<String> selectItem, List<String> inputItem) {
		super();
		this.id = id;
		this.templateName = templateName;
		this.createDate = createDate;
		this.statu = statu;
		this.isDefault = isDefault;
		this.adminId = adminId;
		this.admin = admin;
		this.evaluateItems = evaluateItems;
		this.evaluateList = evaluateList;
		this.selectItem = selectItem;
		this.inputItem = inputItem;
	}

	public List<String> getSelectItem() {
		return selectItem;
	}

	public void setSelectItem(List<String> selectItem) {
		this.selectItem = selectItem;
	}

	public List<String> getInputItem() {
		return inputItem;
	}

	public void setInputItem(List<String> inputItem) {
		this.inputItem = inputItem;
	}

	public List<Evaluate> getEvaluateList() {
		return evaluateList;
	}

	public void setEvaluateList(List<Evaluate> evaluateList) {
		this.evaluateList = evaluateList;
	}

	public List<EvaluateItem> getEvaluateItems(){
		return evaluateItems;
	}

	public void setEvaluateItems(List<EvaluateItem> evaluateItems) {
		this.evaluateItems = evaluateItems;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

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

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
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

	public String getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	@Override
	public String toString() {
		return "Template [id=" + id + ", templateName=" + templateName
				+ ", createDate=" + createDate + ", statu=" + statu
				+ ", isDefault=" + isDefault + ", adminId=" + adminId
				+ ", admin=" + admin + ", evaluateItems=" + evaluateItems + "]";
	}
}
