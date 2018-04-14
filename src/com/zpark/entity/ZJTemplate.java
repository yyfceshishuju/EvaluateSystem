/**
 * 
 */
package com.zpark.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author qutt@zparkhr.com.cn
 *
 */
public class ZJTemplate implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String templateName;
	private Date createDate;
	private String statu;// ״̬y��ʾ����,n��ʾ������
	private String isDefault;// �Ƿ�Ĭ��,y��ʾ��Ĭ��,n��ʾ��Ĭ��
	private Integer adminId;
	private Admin admin;
	private List<ZJEvaluateItem> zjevaluateItems;
	private List<ZJEvaluate>  zjEvaluateList = new ArrayList<ZJEvaluate>();
	private List<String> selectItem;
	private List<String> inputItem;
	private String isDelete;
	private String adminName;
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
	
	public List<ZJEvaluateItem> getZjevaluateItems() {
		return zjevaluateItems;
	}
	public void setZjevaluateItems(List<ZJEvaluateItem> zjevaluateItems) {
		this.zjevaluateItems = zjevaluateItems;
	}
	public List<ZJEvaluate> getZjEvaluateList() {
		return zjEvaluateList;
	}
	public void setZjEvaluateList(List<ZJEvaluate> zjEvaluateList) {
		this.zjEvaluateList = zjEvaluateList;
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
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
	
}
