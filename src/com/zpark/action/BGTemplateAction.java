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
	// �ռ���Ҫ������templateId
	private Integer useableTemplateId;
	// �ռ�����Ҫ�����templateid
	private Integer frozenTemplateId;
	// ����template�ռ�������
	private Template template;
	// �޸�template�ռ�������
	private Template modifyTemplate;
	// ɾ��template�ռ���id
	private String removeId;
	// չʾ����ģ�������
	@EasyUI
	private List<Template> templates;
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
	//δ����ģ��չʾ�Ĳ�����
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
	 * ����������:��һ��Template�������ݲ��뵽���ݿ���
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
		templateService.createTemplate(template);// ����ģ��
		return "createTemplateSuccess";
	}

	/**
	 * 
	 * ����������:��Template����ɾ��
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
	 * ����������:��Template���и���
	 * @return: String
	 */
	public String modifyTemplate() {
		logger.info("------------[into modifyTemplate method]-----------");
		templateService.modifyTemplate(modifyTemplate);
		return "modifyTemplate";
	}

	/**
	 * 
	 * ����������:չʾ���е�ģ��
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
	 * ����������:������ģ��ΪĬ��ģ��
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
	 * ����������:��ģ�����Ϊ����״̬
	 * 
	 * @return: String
	 */
	public String setTemplateUseable() {
		templateService.setTemplateUseable(useableTemplateId);
		return "setTemplateUseable";
	}

	/**
	 * ����������:����ģ��,ʹ֮������
	 * 
	 * @return: String
	 */
	public String frozenTemplate() {
		templateService.frozenTemplate(frozenTemplateId);
		return "setTemplateUseable";
	}
	
	/**
	 * ����������:Ϊ���ģ���������չʾ����
	 * @return: String
	 */
	public String showEvaluateItemsForTemplate() {
		logger.info("------------[into showEvaluateItemsForTemplate method]-----------");
		evaluateItems = evaluateItemService.showEvaluateItemsForTemplate();
		return "showEvaluateItemsForTemplate";
	}
}
