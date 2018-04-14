package com.zpark.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zpark.entity.EvaluateItem;
import com.zpark.entity.Template;
import com.zpark.service.EvaluateItemService;
import com.zpark.service.TemplateService;
import com.zpark.util.EasyUI;

@Controller
@Scope("prototype")
public class BGTemplateAction extends ActionSupport {
	// 收集需要开启的templateId
	private Integer useableTemplateId;
	// 收集的需要冻结的templateid
	private Integer frozenTemplateId;
	// 创建template收集的数据
	private Template template;
	// 修改template收集的数据
	private Template modifyTemplate;
	// 删除template收集的id
	private String removeId;
	// 展示所有模板的数据
	@EasyUI
	private List<Template> templates;
	// 创建模板时候添加的名字
	private String templateName;
	// 添加模板收集的测评想id
	// private String evaluateItemId;
	private String[] evaluateItemId;
	private String[] evaluateItemId2;
	
	public String[] getEvaluateItemId2() {
		return evaluateItemId2;
	}
	public void setEvaluateItemId2(String[] evaluateItemId2) {
		this.evaluateItemId2 = evaluateItemId2;
	}

	// 置为默认的id
	private Integer templateDefaultId;
	//未创建模板展示的测评想
	@EasyUI
	private List<EvaluateItem> evaluateItems;
	
	public List<EvaluateItem> getEvaluateItems() {
		return evaluateItems;
	}
	public void setEvaluateItems(List<EvaluateItem> evaluateItems) {
		this.evaluateItems = evaluateItems;
	}

	public Integer getUseableTemplateId() {
		return useableTemplateId;
	}

	public void setUseableTemplateId(Integer useableTemplateId) {
		this.useableTemplateId = useableTemplateId;
	}

	public Integer getFrozenTemplateId() {
		return frozenTemplateId;
	}

	public void setFrozenTemplateId(Integer frozenTemplateId) {
		this.frozenTemplateId = frozenTemplateId;
	}

	public Integer getTemplateDefaultId() {
		return templateDefaultId;
	}

	public void setTemplateDefaultId(Integer templateDefaultId) {
		this.templateDefaultId = templateDefaultId;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String[] getEvaluateItemId() {
		return evaluateItemId;
	}

	public void setEvaluateItemId(String[] evaluateItemId) {
		this.evaluateItemId = evaluateItemId;
	}

	public List<Template> getTemplates() {
		return templates;
	}

	public void setTemplates(List<Template> templates) {
		this.templates = templates;
	}

	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

	public Template getModifyTemplate() {
		return modifyTemplate;
	}

	public void setModifyTemplate(Template modifyTemplate) {
		this.modifyTemplate = modifyTemplate;
	}

	public String getRemoveId() {
		return removeId;
	}

	public void setRemoveId(String removeId) {
		this.removeId = removeId;
	}

	private Logger logger = Logger.getLogger(BGTemplateAction.class);

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	@Autowired
	private TemplateService templateService;
	@Autowired
	private EvaluateItemService evaluateItemService;

	public EvaluateItemService getEvaluateItemService() {
		return evaluateItemService;
	}

	public void setEvaluateItemService(EvaluateItemService evaluateItemService) {
		this.evaluateItemService = evaluateItemService;
	}

	public TemplateService getTemplateService() {
		return templateService;
	}

	public void setTemplateService(TemplateService templateService) {
		this.templateService = templateService;
	}

	/**
	 * 方法的描述:将一个Template对象数据插入到数据库中
	 * 
	 * @return: String
	 */
	public String createTemplate() {
		logger.info("------------[into createTemplate method]-----------");
		System.out.println(evaluateItemId.length+"====="+evaluateItemId2.length);
		List<EvaluateItem> list = new ArrayList<EvaluateItem>();
		// String[] ids = evaluateItemId.split("-");
		logger.debug(evaluateItemId);
		for (String id : evaluateItemId) {
			Integer i = Integer.parseInt(id);
			list.add(evaluateItemService.showEvaluateItemById(i));
		}
		for(String id:evaluateItemId2){
			Integer i = Integer.parseInt(id);
			list.add(evaluateItemService.showEvaluateItemById(i));
		}
		Template template = new Template();
		template.setEvaluateItems(list);
		Integer adminId = (Integer)ActionContext.getContext().getSession().get("nowAdminId");
		template.setAdminId(adminId);
		template.setCreateDate(new Date());
		template.setIsDefault("n");
		template.setStatu("y");
		template.setTemplateName(templateName);
		logger.info(template);
		templateService.createTemplate(template);// 创建模板
		return "createTemplateSuccess";
	}

	/**
	 * 
	 * 方法的描述:将Template进行删除
	 * @return: String
	 */
	public String removeTemplate() {
		logger.info("------------[into removeTemplate method]-----------");
		String[] ids = removeId.split("-");
		for (String s : ids) {
			Integer id = Integer.parseInt(s);
			templateService.removeTemplate(id);
		}
		return "removeTemplate";
	}

	/**
	 * 方法的描述:将Template进行更新
	 * @return: String
	 */
	public String modifyTemplate() {
		logger.info("------------[into modifyTemplate method]-----------");
		templateService.modifyTemplate(modifyTemplate);
		return "modifyTemplate";
	}

	/**
	 * 
	 * 方法的描述:展示所有的模板
	 * @return: String
	 */
	public String showTemplates() {
		logger.info("------------[into showTemplates method]-----------");
		templates = templateService.showTemplates();
		logger.debug(templates);
		logger.info(templates.get(0).getId());
		return "showTemplates";
	}

	/**
	 * 方法的描述:调整该模板为默认模板
	 * 
	 * @return: String
	 */
	public String SetTemplateDefault() {
		logger.info("------------[into SetTemplateDefault method]-----------");
		logger.info(templateDefaultId.toString() + templateDefaultId.getClass());
		Template template = templateService.showTemplateById(templateDefaultId);
		templateService.SetTemplateDefault(template);
		return "SetTemplateDefault";
	}

	/**
	 * 
	 * 方法的描述:将模板调整为可用状态
	 * 
	 * @return: String
	 */
	public String setTemplateUseable() {
		templateService.setTemplateUseable(useableTemplateId);
		return "setTemplateUseable";
	}

	/**
	 * 方法的描述:冻结模板,使之不可用
	 * 
	 * @return: String
	 */
	public String frozenTemplate() {
		templateService.frozenTemplate(frozenTemplateId);
		return "setTemplateUseable";
	}
	
	/**
	 * 方法的描述:为添加模板把评测项展示出来
	 * @return: String
	 */
	public String showEvaluateItemsForTemplate() {
		logger.info("------------[into showEvaluateItemsForTemplate method]-----------");
		evaluateItems = evaluateItemService.showEvaluateItemsForTemplate();
		return "showEvaluateItemsForTemplate";
	}
}
