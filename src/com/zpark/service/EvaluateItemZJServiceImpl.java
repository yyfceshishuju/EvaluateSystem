package com.zpark.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zpark.dao.EvaluateItemZJDAO;
import com.zpark.dao.TemplateItemLinkZJDAO;
import com.zpark.entity.ZJEvaluateItem;
import com.zpark.entity.ZJTemplateItemLink;
import com.zpark.exception.IdIsNullException;
import com.zpark.util.PageUtil;

@Service
public class EvaluateItemZJServiceImpl implements EvaluateItemZJService {
	private Logger logger = Logger.getLogger(EvaluateItemZJServiceImpl.class);
	@Autowired
	private EvaluateItemZJDAO evaluateItemZJDAO;
	@Autowired
	private TemplateItemLinkZJDAO templateItemLinkZJDAO;

	public EvaluateItemZJDAO getEvaluateItemZJDAO() {
		return evaluateItemZJDAO;
	}

	public void setEvaluateItemZJDAO(EvaluateItemZJDAO evaluateItemZJDAO) {
		this.evaluateItemZJDAO = evaluateItemZJDAO;
	}

	public TemplateItemLinkZJDAO getTemplateItemLinkZJDAO() {
		return templateItemLinkZJDAO;
	}

	public void setTemplateItemLinkZJDAO(
			TemplateItemLinkZJDAO templateItemLinkZJDAO) {
		this.templateItemLinkZJDAO = templateItemLinkZJDAO;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	@Override
	@Transactional
	public void createZJEvaluateItem(ZJEvaluateItem zJevaluateItem) {
		// TODO Auto-generated method stub
		logger.info("-------[into method createZJEvaluateItem]------");
		evaluateItemZJDAO.saveZJEvaluteItem(zJevaluateItem);
	}

	@Override
	@Transactional
	public void removeZJEvaluateItem(Integer id) {
		// TODO Auto-generated method stub
		logger.info("-------[into method removeZJEvaluateItem]------");
		if (id == null)
			throw new IdIsNullException("请指定删除某个数据（id是空的）");
		evaluateItemZJDAO.deleteZJEvaluateItem(id);
	}

	@Override
	@Transactional
	public void modifyZJEvaluateItem(ZJEvaluateItem zJevaluateItem) {
		// TODO Auto-generated method stub
		logger.info("-------[into method modifyZJEvaluateItem]------");
		evaluateItemZJDAO.updateZJEvaluateItem(zJevaluateItem);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public ZJEvaluateItem showZJEvaluateItemById(Integer id) {
		// TODO Auto-generated method stub
		logger.info("-------[into method showZJEvaluateItemById]------");
		return evaluateItemZJDAO.queryZJEvaluateItemById(id);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<ZJEvaluateItem> showZJEvaluateItems() {
		// TODO Auto-generated method stub
		logger.info("-------[into method showZJEvaluateItems]------");
		PageUtil.setTotal(evaluateItemZJDAO.queryZJEvaluateItemMaxRows());
		List<ZJEvaluateItem> list = evaluateItemZJDAO.queryAllZJEvaluateItem(
				PageUtil.getFirstResult(), PageUtil.getLastResult());
		for (ZJEvaluateItem e : list) {
			e.setAdminName(e.getAdmin().getUsername());
			List<ZJTemplateItemLink> links = templateItemLinkZJDAO
					.queryByItemId(e.getId());
			if (links.size() == 0) {
				e.setIsDelete("y");
			} else {
				e.setIsDelete("n");
			}
		}
		return list;
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<ZJEvaluateItem> showZJEvaluateItemsForTemplate() {
		// TODO Auto-generated method stub
		logger.info("-------[into method showZJEvaluateItemsForTemplate]------");
		return evaluateItemZJDAO.queryAllEvaluateItems();
	}

}
