package com.zpark.service;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zpark.dao.AdminDAO;
import com.zpark.dao.EvaluateDao;
import com.zpark.dao.TemplateDAO;
import com.zpark.dao.TemplateItemLinkDAO;
import com.zpark.entity.Admin;
import com.zpark.entity.Evaluate;
import com.zpark.entity.EvaluateItem;
import com.zpark.entity.Template;
import com.zpark.entity.TemplateItemLink;
import com.zpark.util.PageUtil;

@Service
public class TemplateServiceImpl implements TemplateService {

	private Logger logger = Logger.getLogger(TemplateServiceImpl.class);
	@Autowired
	private TemplateDAO templateDAO;
	@Autowired
	private AdminDAO adminDAO;
	@Autowired
	private EvaluateDao evaluateDao;
	@Autowired
	private TemplateItemLinkDAO templateItemLinkDAO;
	
	public TemplateItemLinkDAO getTemplateItemLinkDAO() {
		return templateItemLinkDAO;
	}

	public void setTemplateItemLinkDAO(TemplateItemLinkDAO templateItemLinkDAO) {
		this.templateItemLinkDAO = templateItemLinkDAO;
	}

	public EvaluateDao getEvaluateDao() {
		return evaluateDao;
	}

	public void setEvaluateDao(EvaluateDao evaluateDao) {
		this.evaluateDao = evaluateDao;
	}

	public AdminDAO getAdminDAO() {
		return adminDAO;
	}

	public void setAdminDAO(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public TemplateDAO getTemplateDAO() {
		return templateDAO;
	}

	public void setTemplateDAO(TemplateDAO templateDAO) {
		this.templateDAO = templateDAO;
	}

	@Override
	@Transactional
	public void createTemplate(Template template) {
		logger.info("--------[into createTemplate method]--------");
		Integer id = templateDAO.queryId();
		template.setId(id);
		templateDAO.saveTemplate(template);
		logger.info(template.getId());
		// 维护关系表
		for (EvaluateItem e : template.getEvaluateItems()) {
			TemplateItemLink templateItemLink = new TemplateItemLink();
			templateItemLink.setTemplateId(template.getId());
			templateItemLink.setEvaluateItemId(e.getId());
			logger.debug("模板中的测评想的id:" + template.getId() + "--------"
					+ e.getId());
			TemplateItemLink tek = new TemplateItemLink();
			tek.setEvaluateItemId(e.getId());
			tek.setTemplateId(template.getId());
			templateDAO.saveRelativity(tek);
		}
	}

	@Override
	@Transactional
	public void removeTemplate(Integer id) {
		logger.info("--------[into removeTemplate method]--------");
		templateItemLinkDAO.deleteByTemplateId(id);
		templateDAO.deleteTemplate(id);
	}

	@Override
	@Transactional
	public void modifyTemplate(Template template) {
		logger.info("--------[into modifyTemplate method]--------");
		logger.info(template);
		templateDAO.updateTemplate(template);

	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Template showTemplateById(Integer id) {
		logger.info("--------[into showTemplateById method]--------");
		return templateDAO.queryTemplateById(id);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Template> showTemplates() {
		logger.info("--------[into showTemplates method]--------");
		PageUtil.setTotal(templateDAO.queryTemplateMaxRows());
		logger.debug(PageUtil.getFirstResult()+"---"+PageUtil.getLastResult());
		List<Template> list = templateDAO.queryAllTemplate(
				PageUtil.getFirstResult(), PageUtil.getLastResult());
		for(Template t:list){
			Admin admin = adminDAO.queryAdminById(t.getAdminId());
			t.setAdminName(admin.getUsername());
			List<Evaluate> evs = evaluateDao.queryEvaluateByTemplateId(t.getId());
			if(evs.size()>0){
				t.setIsDelete("n");
			}else{
				t.setIsDelete("y");
			}
		}
		return list;
	}

	@Override
	public void SetTemplateDefault(Template template) {
		// TODO Auto-generated method stub
		logger.info("--------[into SetTemplateDefault method]--------");
		List<Template> list = showTemplates();
		for (Template t : list) {
			t.setIsDefault("n");
			templateDAO.updateTemplate(t);
		}
		template.setIsDefault("y");
		templateDAO.updateTemplate(template);
	}

	@Override
	public void setTemplateUseable(Integer uSeableTemplateId) {
		logger.info("--------[into setTemplateUseable method]--------");
		// TODO Auto-generated method stub
		Template template = templateDAO.queryTemplateById(uSeableTemplateId);
		template.setStatu("y");
		templateDAO.updateTemplate(template);
	}

	@Override
	public void frozenTemplate(Integer frozenTemplateId) {
		logger.info("--------[into frozenTemplate method]--------");
		// TODO Auto-generated method stub
		Template template = templateDAO.queryTemplateById(frozenTemplateId);
		template.setStatu("n");
		templateDAO.updateTemplate(template);
	}
}
