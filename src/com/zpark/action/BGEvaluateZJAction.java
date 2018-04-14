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
	// Service层对象
	@Autowired
	private EvaluateItemZJService evaluateItemZJService;
	// 创建EvaluateItem所收集输的数据
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

	// 删除测评项所收集的id
	private String removeItem;
	// 更新评测所收集的数据
	private ZJEvaluateItem modifyZJEvaluateItem;
	// 根据id查询到的EvaluateItem
	@EasyUI
	private ZJEvaluateItem evaluateItemById;
	// 查询evaluateItem的id
	private Integer evaluateItemId;
	// 展示评测项的数据evaluateItems
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
	 * 方法的描述:收集创建ZJEvaluateItem的数据,并将数据交给EvaluateItemZJService, 将数据插入到数据中
	 * 
	 * @return: String
	 */
	public String createZJEvaluateItem() {
		logger.info("-----[into createZJEvaluateItem method ]---------");
		// 准备新添加测评项的数据
		ZJEvaluateItem zJE = new ZJEvaluateItem();
		zJE.setItemCategory(itemCategory);
		zJE.setItemName(itemName);
		zJE.setItemScore(itemScore);
		zJE.setCreateDate(new Date());
		zJE.setStatu("y");// y表示该条评测项可用
		Integer adminId = (Integer) ActionContext.getContext().getSession()
				.get("nowAdminId");
		zJE.setAdminId(adminId);
		evaluateItemZJService.createZJEvaluateItem(zJE);
		return "createZJEvaluateItem";
	}

	/**
	 * 方法的描述:展示所有的可选评测项,以备选择成为 模板
	 * 
	 * @return: String
	 */
	public String showZJEvaluateItems() {
		logger.info("-----[into showZJEvaluateItems method ]---------");
		zJevaluateItems = evaluateItemZJService.showZJEvaluateItems();
		return "showZJEvaluateItems";
	}

	/**
	 * 方法的描述:点击删除后移除对应id的评测项
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
	 * 方法的描述:更新ZJEvaluateItem测评项
	 * 
	 * @return: String
	 */
	public String modifyZJEvaluateItem() {
		logger.info("-----[into modifyZJEvaluateItem method ]---------");
		Integer adminId = (Integer) ActionContext.getContext().getSession()
				.get("nowAdminId");
		modifyEvaluateItem.setAdminId(adminId);// 设置是哪个管理员做的修改
		modifyEvaluateItem.setCreateDate(new Date());// 更新时间
		modifyEvaluateItem.setStatu("y");// 可用
		logger.debug(modifyEvaluateItem);
		evaluateItemZJService.modifyZJEvaluateItem(modifyEvaluateItem);
		return "modifyZJEvaluateItem";
	}

	/**
	 * 方法的描述:根据id展示对应的助教的教评项
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
