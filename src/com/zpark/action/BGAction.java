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

	// Service层对象
	@Autowired
	private EvaluateItemService evaluateItemService;
	// 创建EvaluateItem所收集输的数据
	private EvaluateItem evaluateItem;
	// 删除测评项所收集的id
	private String removeItem;
	// 更新评测所收集的数据
	private EvaluateItem modifyEvaluateItem;
	// 根据id查询到的EvaluateItem
	@EasyUI
	private EvaluateItem evaluateItemById;
	// 查询evaluateItem的id
	private Integer evaluateItemId;
	// 展示评测项的数据evaluateItems
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
	 * 方法的描述:收集创建EvaluateItem的数据,并将数据交给EvaluateItemService, 将数据插入到数据中
	 * 
	 * @return: String
	 */
	public String createEvaluateItem() {
		logger.info("-----[into createEvaluateItem method ]---------");
		// 准备新添加测评项的数据
		evaluateItem.setCreateDate(new Date());
		evaluateItem.setStatu("y");// y表示该条评测项可用
		Integer adminId = (Integer)ActionContext.getContext().getSession().get("nowAdminId");
		evaluateItem.setAdminId(adminId);
		evaluateItemService.createEvaluateItem(evaluateItem);
		return "createEvaluateItemSuccess";
	}

	/**
	 * 方法的描述:展示所有的可选评测项,以备选择成为 模板
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
	 * 方法的描述:点击删除后移除对应id的评测项
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
	 * 方法的描述:更新EvaluateItem测评项
	 * 
	 * @return: String
	 */
	public String modifyEvaluateItem() {
		logger.info("-----[into modifyEvaluateItem method ]---------");
		Integer adminId = (Integer)ActionContext.getContext().getSession().get("nowAdminId");
		modifyEvaluateItem.setAdminId(adminId);// 设置是哪个管理员做的修改
		modifyEvaluateItem.setCreateDate(new Date());// 更新时间
		modifyEvaluateItem.setStatu("y");// 可用
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
