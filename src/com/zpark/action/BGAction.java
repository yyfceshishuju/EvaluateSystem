package com.zpark.action;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zpark.entity.EvaluateItem;
import com.zpark.service.EvaluateItemService;
import com.zpark.util.EasyUI;

@Controller
@Scope("prototype")
public class BGAction extends ActionSupport {
	private Logger logger = Logger.getLogger(BGAction.class);

	
	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	// Service�����
	@Autowired
	private EvaluateItemService evaluateItemService;
	// ����EvaluateItem���ռ��������
	private EvaluateItem evaluateItem;
	// ɾ�����������ռ���id
	private String removeItem;
	// �����������ռ�������
	private EvaluateItem modifyEvaluateItem;
	// ����id��ѯ����EvaluateItem
	@EasyUI
	private EvaluateItem evaluateItemById;
	// ��ѯevaluateItem��id
	private Integer evaluateItemId;
	// չʾ�����������evaluateItems
	@EasyUI
	private List<EvaluateItem> evaluateItems;

	

	public String getRemoveItem() {
		return removeItem;
	}

	public void setRemoveItem(String removeItem) {
		this.removeItem = removeItem;
	}

	public Integer getEvaluateItemId() {
		return evaluateItemId;
	}

	public void setEvaluateItemId(Integer evaluateItemId) {
		this.evaluateItemId = evaluateItemId;
	}

	public EvaluateItem getEvaluateItemById() {
		return evaluateItemById;
	}

	public void setEvaluateItemById(EvaluateItem evaluateItemById) {
		this.evaluateItemById = evaluateItemById;
	}

	public EvaluateItem getModifyEvaluateItem() {
		return modifyEvaluateItem;
	}

	public void setModifyEvaluateItem(EvaluateItem modifyEvaluateItem) {
		this.modifyEvaluateItem = modifyEvaluateItem;
	}

	public List<EvaluateItem> getEvaluateItems() {
		return evaluateItems;
	}

	public void setEvaluateItems(List<EvaluateItem> evaluateItems) {
		this.evaluateItems = evaluateItems;
	}

	public EvaluateItemService getEvaluateItemService() {
		return evaluateItemService;
	}

	public void setEvaluateItemService(EvaluateItemService evaluateItemService) {
		this.evaluateItemService = evaluateItemService;
	}

	public EvaluateItem getEvaluateItem() {
		return evaluateItem;
	}

	public void setEvaluateItem(EvaluateItem evaluateItem) {
		this.evaluateItem = evaluateItem;
	}

	/**
	 * ����������:�ռ�����EvaluateItem������,�������ݽ���EvaluateItemService, �����ݲ��뵽������
	 * 
	 * @return: String
	 */
	public String createEvaluateItem() {
		logger.info("-----[into createEvaluateItem method ]---------");
		// ׼������Ӳ����������
		evaluateItem.setCreateDate(new Date());
		evaluateItem.setStatu("y");// y��ʾ�������������
		Integer adminId = (Integer)ActionContext.getContext().getSession().get("nowAdminId");
		evaluateItem.setAdminId(adminId);
		evaluateItemService.createEvaluateItem(evaluateItem);
		return "createEvaluateItemSuccess";
	}

	/**
	 * ����������:չʾ���еĿ�ѡ������,�Ա�ѡ���Ϊ ģ��
	 * 
	 * @return: String
	 */
	public String showEvaluateItems() {
		logger.info("-----[into showEvaluateItems method ]---------");
		evaluateItems = evaluateItemService.showEvaluateItems();
		System.out.println(evaluateItems);
		return "showEvaluateItems";
	}

	/**
	 * ����������:���ɾ�����Ƴ���Ӧid��������
	 * 
	 * @return: String
	 */
	public String removeEvaluateItem() {
		logger.info("-----[into removeEvaluateItem method ]---------");
		String[] ss = removeItem.split("-");
		System.out.println(ss.length);
		for(String s:ss){
			Integer id = Integer.parseInt(s);
			evaluateItemService.removeEvaluateItem(id);
		}
		return "removeEvaluateItem";
	}

	/**
	 * ����������:����EvaluateItem������
	 * 
	 * @return: String
	 */
	public String modifyEvaluateItem() {
		logger.info("-----[into modifyEvaluateItem method ]---------");
		Integer adminId = (Integer)ActionContext.getContext().getSession().get("nowAdminId");
		modifyEvaluateItem.setAdminId(adminId);// �������ĸ�����Ա�����޸�
		modifyEvaluateItem.setCreateDate(new Date());// ����ʱ��
		modifyEvaluateItem.setStatu("y");// ����
		logger.debug(modifyEvaluateItem);
		evaluateItemService.modifyEvaluateItem(modifyEvaluateItem);
		return "modifyEvaluateItem";
	}

	public String showEvaluateItemById() {
		logger.info("-----[into showEvaluateItemById method ]---------");
		evaluateItemById = evaluateItemService
				.showEvaluateItemById(evaluateItemId);
		return "showEvaluateItemById";
	}
}
