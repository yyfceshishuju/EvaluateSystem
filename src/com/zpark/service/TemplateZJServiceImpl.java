package com.zpark.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zpark.dao.AdminDAO;
import com.zpark.dao.EvaluateZjDao;
import com.zpark.dao.TemplateItemLinkZJDAO;
import com.zpark.dao.TemplateZJDAO;
import com.zpark.entity.Admin;
import com.zpark.entity.Evaluate;
import com.zpark.entity.EvaluateItem;
import com.zpark.entity.Template;
import com.zpark.entity.TemplateItemLink;
import com.zpark.entity.ZJEvaluate;
import com.zpark.entity.ZJEvaluateItem;
import com.zpark.entity.ZJTemplate;
import com.zpark.entity.ZJTemplateItemLink;
import com.zpark.util.PageUtil;

@Service
public class TemplateZJServiceImpl implements TemplateZJService {
	private Logger logger = Logger.getLogger(TemplateZJServiceImpl.class);
	@Autowired
	private AdminDAO adminDAO;
	@Autowired
	private TemplateZJDAO templateZJDAO;
	@Autowired
	private TemplateItemLinkZJDAO templateItemLinkZJDAO;
	@Autowired
	private EvaluateZjDao evaluteZjDao;
	
	public EvaluateZjDao getEvaluteZjDao() {
		return evaluteZjDao;
	}

	public void setEvaluteZjDao(EvaluateZjDao evaluteZjDao) {
		this.evaluteZjDao = evaluteZjDao;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public AdminDAO getAdminDAO() {
		return adminDAO;
	}

	public void setAdminDAO(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

	public TemplateZJDAO getTemplateZJDAO() {
		return templateZJDAO;
	}

	public void setTemplateZJDAO(TemplateZJDAO templateZJDAO) {
		this.templateZJDAO = templateZJDAO;
	}

	public TemplateItemLinkZJDAO getTemplateItemLinkZJDAO() {
		return templateItemLinkZJDAO;
	}

	public void setTemplateItemLinkZJDAO(
			TemplateItemLinkZJDAO templateItemLinkZJDAO) {
		this.templateItemLinkZJDAO = templateItemLinkZJDAO;
	}

	@Override
	@Transactional
	public void createZJTemplate(ZJTemplate zJtemplate) {
		// TODO Auto-generated method stub
		logger.info("--------[into createZJTemplate method]--------");
		Integer id = templateZJDAO.queryId();
		zJtemplate.setId(id);
		templateZJDAO.saveZJTemplate(zJtemplate);
		logger.info(zJtemplate.getId());
		// 维护关系表
		for (ZJEvaluateItem e : zJtemplate.getZjevaluateItems()) {
			TemplateItemLink templateItemLink = new TemplateItemLink();
			templateItemLink.setTemplateId(zJtemplate.getId());
			templateItemLink.setEvaluateItemId(e.getId());
			logger.debug("模板中的测评想的id:" + zJtemplate.getId() + "--------"
					+ e.getId());
			ZJTemplateItemLink tek = new ZJTemplateItemLink();
			tek.setEvaluateItemZjId(e.getId());
			tek.setTemplateZjId(zJtemplate.getId());
			templateZJDAO.saveZJRelativity(tek);
		}
	}

	@Override
	@Transactional
	public void removeZJTemplate(Integer id) {
		// TODO Auto-generated method stub
		logger.info("--------[into removeZJTemplate method]--------");
		templateItemLinkZJDAO.deleteByZJTemplateId(id);
		templateZJDAO.deleteZJTemplate(id);
	}

	@Override
	@Transactional
	public void modifyZJTemplate(ZJTemplate template) {
		// TODO Auto-generated method stub
		logger.info("--------[into modifyZJTemplate method]--------");
		templateZJDAO.updateZJTemplate(template);
	}

	@Override
	@Transactional
	public ZJTemplate showZJTemplateById(Integer id) {
		// TODO Auto-generated method stub
		logger.info("--------[into showZJTemplateById method]--------");
		return templateZJDAO.queryZJTemplateById(id);
	}

	@Override
	@Transactional
	public List<ZJTemplate> showZJTemplates() {
		// TODO Auto-generated method stub
		logger.info("--------[into showZJTemplates method]--------");
		PageUtil.setTotal(templateZJDAO.queryZJTemplateMaxRows());
		List<ZJTemplate> list = templateZJDAO.queryAllZJTemplate(
				PageUtil.getFirstResult(), PageUtil.getLastResult());
		for(ZJTemplate t:list){
			Admin admin = adminDAO.queryAdminById(t.getAdminId());
			t.setAdminName(admin.getUsername());
			List<ZJEvaluate> evs = evaluteZjDao.queryEvaluateByTemplateId(t.getId());
			if(evs.size()>0){
				t.setIsDelete("n");
			}else{
				t.setIsDelete("y");
			}
		}
		return list;
	}

	@Override
	@Transactional
	public void SetZJTemplateDefault(ZJTemplate template) {
		// TODO Auto-generated method stub
		logger.info("--------[into SetZJTemplateDefault method]--------");
		List<ZJTemplate> list = showZJTemplates();
		for (ZJTemplate t : list) {
			t.setIsDefault("n");
			templateZJDAO.updateZJTemplate(t);
		}
		template.setIsDefault("y");
		templateZJDAO.updateZJTemplate(template);
	}

	@Override
	@Transactional
	public void setZJTemplateUseable(Integer uSeableZJTemplateId) {
		// TODO Auto-generated method stub
		logger.info("--------[into setZJTemplateUseable method]--------");
		ZJTemplate template = templateZJDAO.queryZJTemplateById(uSeableZJTemplateId);
		template.setStatu("y");
		templateZJDAO.updateZJTemplate(template);
	}

	@Override
	@Transactional
	public void frozenZJTemplate(Integer frozenZJTemplateId) {
		// TODO Auto-generated method stub
		logger.info("--------[into frozenZJTemplate method]--------");
		ZJTemplate template = templateZJDAO.queryZJTemplateById(frozenZJTemplateId);
		template.setStatu("n");
		templateZJDAO.updateZJTemplate(template);
	}

}
