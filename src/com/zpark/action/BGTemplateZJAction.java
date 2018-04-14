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
import com.zpark.entity.ZJEvaluateItem;
import com.zpark.entity.ZJTemplate;
import com.zpark.service.EvaluateItemZJService;
import com.zpark.service.TemplateZJService;
import com.zpark.util.EasyUI;

@Controller
@Scope("prototype")
public class BGTemplateZJAction extends ActionSupport {
	private Logger logger = Logger.getLogger(BGTemplateZJAction.class);
	// �ռ���Ҫ������templateId
	private Integer useableTemplateId;
	// �ռ�����Ҫ�����templateid
	private Integer frozenTemplateId;
	// ����template�ռ�������
	private ZJTemplate template;
	// �޸�template�ռ�������
	private ZJTemplate modifyTemplate;
	// ɾ��template�ռ���id
	private String removeId;
	// չʾ����ģ�������
	@EasyUI
	private List<ZJTemplate> templates;
	// ����ģ��ʱ����ӵ�����
	private String templateName;
	// ���ģ���ռ��Ĳ�����id
	// private String evaluateItemId;
	private String[] evaluateItemId;
	private String[] evaluateItemId2;

	public String[] getEvaluateItemId2() {
		return evaluateItemId2;
	}

	public void setEvaluateItemId2(String[] evaluateItemId2) {
		this.evaluateItemId2 = evaluateItemId2;
	}

	// ��ΪĬ�ϵ�id
	private Integer templateDefaultId;
	// δ����ģ��չʾ�Ĳ�����
	@EasyUI
	private List<ZJEvaluateItem> evaluateItems;
	@Autowired
	private TemplateZJService templateZJService;
	@Autowired
	private EvaluateItemZJService evaluateItemService;

	public TemplateZJService getTemplateZJService() {
		return templateZJService;
	}

	public void setTemplateZJService(TemplateZJService templateZJService) {
		this.templateZJService = templateZJService;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
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

	public ZJTemplate getTemplate() {
		return template;
	}

	public void setTemplate(ZJTemplate template) {
		this.template = template;
	}

	public ZJTemplate getModifyTemplate() {
		return modifyTemplate;
	}

	public void setModifyTemplate(ZJTemplate modifyTemplate) {
		this.modifyTemplate = modifyTemplate;
	}

	public String getRemoveId() {
		return removeId;
	}

	public void setRemoveId(String removeId) {
		this.removeId = removeId;
	}

	public List<ZJTemplate> getTemplates() {
		return templates;
	}

	public void setTemplates(List<ZJTemplate> templates) {
		this.templates = templates;
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

	public Integer getTemplateDefaultId() {
		return templateDefaultId;
	}

	public void setTemplateDefaultId(Integer templateDefaultId) {
		this.templateDefaultId = templateDefaultId;
	}

	public List<ZJEvaluateItem> getEvaluateItems() {
		return evaluateItems;
	}

	public void setEvaluateItems(List<ZJEvaluateItem> evaluateItems) {
		this.evaluateItems = evaluateItems;
	}

	public TemplateZJService getTemplateService() {
		return templateZJService;
	}

	/*
	 * public void setTemplateService(TemplateZJService templateService) {
	 * this.templateZJService = templateService; }
	 */

	public EvaluateItemZJService getEvaluateItemService() {
		return evaluateItemService;
	}

	public void setEvaluateItemService(EvaluateItemZJService evaluateItemService) {
		this.evaluateItemService = evaluateItemService;
	}

	/**
	 * ����������:��һ��Template�������ݲ��뵽���ݿ���
	 * 
	 * @return: String
	 */
	public String createTemplate() {
		logger.info("------------[into createTemplate method]-----------");
		List<ZJEvaluateItem> list = new ArrayList<ZJEvaluateItem>();
		// String[] ids = evaluateItemId.split("-");
		for (String id : evaluateItemId) {
			Integer i = Integer.parseInt(id);
			list.add(evaluateItemService.showZJEvaluateItemById(i));
		}
		for (String id : evaluateItemId2) {
			Integer i = Integer.parseInt(id);
			list.add(evaluateItemService.showZJEvaluateItemById(i));
		}
		ZJTemplate template = new ZJTemplate();
		template.setZjevaluateItems(list);
		Integer adminId = (Integer) ActionContext.getContext().getSession()
				.get("nowAdminId");
		template.setAdminId(adminId);
		template.setCreateDate(new Date());
		template.setIsDefault("n");
		template.setStatu("y");
		template.setTemplateName(templateName);
		logger.info(template);
		templateZJService.createZJTemplate(template);// ����ģ��
		return "createTemplateSuccess";
	}

	/**
	 * 
	 * ����������:��Template����ɾ��
	 * 
	 * @return: String
	 */
	public String removeTemplate() {
		logger.info("------------[into removeTemplate method]-----------");
		String[] ids = removeId.split("-");
		for (String s : ids) {
			Integer id = Integer.parseInt(s);
			templateZJService.removeZJTemplate(id);
		}
		return "removeTemplate";
	}

	/**
	 * 
	 * ����������:��Template���и���
	 * 
	 * @return: String
	 */
	public String modifyTemplate() {
		logger.info("------------[into modifyTemplate method]-----------");
		templateZJService.modifyZJTemplate(modifyTemplate);
		return "modifyTemplate";
	}

	/**
	 * 
	 * ����������:չʾ���е�ģ��
	 * 
	 * @return: String
	 */
	public String showTemplates() {
		logger.info("------------[into showTemplates method]-----------");
		templates = templateZJService.showZJTemplates();
		logger.debug(templates);
		logger.info(templates.get(0).getId());
		return "showTemplates";
	}

	/**
	 * ����������:������ģ��ΪĬ��ģ��
	 * 
	 * @return: String
	 */
	public String SetTemplateDefault() {
		logger.info("------------[into SetTemplateDefault method]-----------");
		logger.info(templateDefaultId.toString() + templateDefaultId.getClass());
		ZJTemplate template = templateZJService
				.showZJTemplateById(templateDefaultId);
		templateZJService.SetZJTemplateDefault(template);
		return "SetTemplateDefault";
	}

	/**
	 * 
	 * ����������:��ģ�����Ϊ����״̬
	 * 
	 * @return: String
	 */
	public String setTemplateUseable() {
		templateZJService.setZJTemplateUseable(useableTemplateId);
		return "setTemplateUseable";
	}

	/**
	 * ����������:����ģ��,ʹ֮������
	 * 
	 * @return: String
	 */
	public String frozenTemplate() {
		templateZJService.frozenZJTemplate(frozenTemplateId);
		return "setTemplateUseable";
	}

	/**
	 * ����������:Ϊ���ģ���������չʾ����
	 * 
	 * @return: String
	 */
	public String showEvaluateItemsForTemplate() {
		logger.info("------------[into showEvaluateItemsForTemplate method]-----------");
		evaluateItems = evaluateItemService.showZJEvaluateItemsForTemplate();
		return "showEvaluateItemsForTemplate";
	}
}
