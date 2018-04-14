package com.zpark.action;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zpark.entity.ZJEvaluateItem;
import com.zpark.service.EvaluateItemZJService;
import com.zpark.util.EasyUI;

@Controller
@Scope("prototype")
public class BGEvaluateZJAction extends ActionSupport {
	private Logger logger = Logger.getLogger(BGEvaluateZJAction.class);

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	// Service�����
	@Autowired
	private EvaluateItemZJService evaluateItemZJService;
	// ����EvaluateItem���ռ��������
	private ZJEvaluateItem zJevaluateItem;
	private String itemName;
	private Integer itemScore;
	private String itemCategory;
	private ZJEvaluateItem modifyEvaluateItem;

	public ZJEvaluateItem getModifyEvaluateItem() {
		return modifyEvaluateItem;
	}

	public void setModifyEvaluateItem(ZJEvaluateItem modifyEvaluateItem) {
		this.modifyEvaluateItem = modifyEvaluateItem;
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

	// ɾ�����������ռ���id
	private String removeItem;
	// �����������ռ�������
	private ZJEvaluateItem modifyZJEvaluateItem;
	// ����id��ѯ����EvaluateItem
	@EasyUI
	private ZJEvaluateItem evaluateItemById;
	// ��ѯevaluateItem��id
	private Integer evaluateItemId;
	// չʾ�����������evaluateItems
	@EasyUI
	private List<ZJEvaluateItem> zJevaluateItems;

	public EvaluateItemZJService getEvaluateItemZJService() {
		return evaluateItemZJService;
	}

	public void setEvaluateItemZJService(
			EvaluateItemZJService evaluateItemZJService) {
		this.evaluateItemZJService = evaluateItemZJService;
	}

	public ZJEvaluateItem getzJevaluateItem() {
		return zJevaluateItem;
	}

	public void setzJevaluateItem(ZJEvaluateItem zJevaluateItem) {
		this.zJevaluateItem = zJevaluateItem;
	}

	public String getRemoveItem() {
		return removeItem;
	}

	public void setRemoveItem(String removeItem) {
		this.removeItem = removeItem;
	}

	public ZJEvaluateItem getModifyZJEvaluateItem() {
		return modifyZJEvaluateItem;
	}

	public void setModifyZJEvaluateItem(ZJEvaluateItem modifyZJEvaluateItem) {
		this.modifyZJEvaluateItem = modifyZJEvaluateItem;
	}

	public ZJEvaluateItem getEvaluateItemById() {
		return evaluateItemById;
	}

	public void setEvaluateItemById(ZJEvaluateItem evaluateItemById) {
		this.evaluateItemById = evaluateItemById;
	}

	public Integer getEvaluateItemId() {
		return evaluateItemId;
	}

	public void setEvaluateItemId(Integer evaluateItemId) {
		this.evaluateItemId = evaluateItemId;
	}

	public List<ZJEvaluateItem> getzJevaluateItems() {
		return zJevaluateItems;
	}

	public void setzJevaluateItems(List<ZJEvaluateItem> zJevaluateItems) {
		this.zJevaluateItems = zJevaluateItems;
	}

	/**
	 * ����������:�ռ�����ZJEvaluateItem������,�������ݽ���EvaluateItemZJService, �����ݲ��뵽������
	 * 
	 * @return: String
	 */
	public String createZJEvaluateItem() {
		logger.info("-----[into createZJEvaluateItem method ]---------");
		// ׼������Ӳ����������
		ZJEvaluateItem zJE = new ZJEvaluateItem();
		zJE.setItemCategory(itemCategory);
		zJE.setItemName(itemName);
		zJE.setItemScore(itemScore);
		zJE.setCreateDate(new Date());
		zJE.setStatu("y");// y��ʾ�������������
		Integer adminId = (Integer) ActionContext.getContext().getSession()
				.get("nowAdminId");
		zJE.setAdminId(adminId);
		evaluateItemZJService.createZJEvaluateItem(zJE);
		return "createZJEvaluateItem";
	}

	/**
	 * ����������:չʾ���еĿ�ѡ������,�Ա�ѡ���Ϊ ģ��
	 * 
	 * @return: String
	 */
	public String showZJEvaluateItems() {
		logger.info("-----[into showZJEvaluateItems method ]---------");
		zJevaluateItems = evaluateItemZJService.showZJEvaluateItems();
		return "showZJEvaluateItems";
	}

	/**
	 * ����������:���ɾ�����Ƴ���Ӧid��������
	 * 
	 * @return: String
	 */
	public String removeZJEvaluateItem() {
		logger.info("-----[into removeZJEvaluateItem method ]---------");
		String[] ss = removeItem.split("-");
		for (String s : ss) {
			Integer id = Integer.parseInt(s);
			evaluateItemZJService.removeZJEvaluateItem(id);
		}
		return "removeZJEvaluateItem";
	}

	/**
	 * ����������:����ZJEvaluateItem������
	 * 
	 * @return: String
	 */
	public String modifyZJEvaluateItem() {
		logger.info("-----[into modifyZJEvaluateItem method ]---------");
		Integer adminId = (Integer) ActionContext.getContext().getSession()
				.get("nowAdminId");
		modifyEvaluateItem.setAdminId(adminId);// �������ĸ�����Ա�����޸�
		modifyEvaluateItem.setCreateDate(new Date());// ����ʱ��
		modifyEvaluateItem.setStatu("y");// ����
		logger.debug(modifyEvaluateItem);
		evaluateItemZJService.modifyZJEvaluateItem(modifyEvaluateItem);
		return "modifyZJEvaluateItem";
	}

	/**
	 * ����������:����idչʾ��Ӧ�����̵Ľ�����
	 * 
	 * @return: String
	 */
	public String showZJEvaluateItemById() {
		logger.info("-----[into showZJEvaluateItemById method ]---------");
		evaluateItemById = evaluateItemZJService
				.showZJEvaluateItemById(evaluateItemId);
		return "showZJEvaluateItemById";
	}
}
