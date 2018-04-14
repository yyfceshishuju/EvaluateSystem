package com.zpark.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zpark.dao.EvaluateItemDAO;
import com.zpark.dao.TemplateItemLinkDAO;
import com.zpark.entity.EvaluateItem;
import com.zpark.entity.TemplateItemLink;
import com.zpark.util.PageUtil;

@Service
// �����ݱ�עΪһ������
public class EvaluateItemServiceImpl implements EvaluateItemService {
	private Logger logger = Logger.getLogger(EvaluateItemServiceImpl.class);

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	@Autowired
	// ��������ע��
	private EvaluateItemDAO evaluateItemDAO;
	@Autowired
	private TemplateItemLinkDAO templateItemLinkDAO;

	public TemplateItemLinkDAO getTemplateItemLinkDAO() {
		return templateItemLinkDAO;
	}

	public void setTemplateItemLinkDAO(TemplateItemLinkDAO templateItemLinkDAO) {
		this.templateItemLinkDAO = templateItemLinkDAO;
	}

	public EvaluateItemDAO getEvaluateItemDAO() {
		return evaluateItemDAO;
	}

	public void setEvaluateItemDAO(EvaluateItemDAO evaluateItemDAO) {
		this.evaluateItemDAO = evaluateItemDAO;
	}

	@Override
	@Transactional
	// ���÷����������
	public void createEvaluateItem(EvaluateItem evaluateItem) {
		logger.info("--[into createEvaluateItem method]--");
		// ҵ�����
		// ����dao
		evaluateItemDAO.saveEvaluateItem(evaluateItem);
	}

	@Override
	@Transactional
	public void removeEvaluateItem(Integer id) {
		logger.info("--[into removeEvaluateItem method]--");
		// ҵ�����
		// ����dao
		logger.debug(":" + id);
		evaluateItemDAO.deleteEvaluateItem(id);
	}

	@Override
	@Transactional
	public void modifyEvaluateItem(EvaluateItem evaluateItem) {
		logger.info("--[into modifyEvaluateItem method]--");
		// ҵ�����
		// ����dao
		evaluateItemDAO.updateEvaluateItem(evaluateItem);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public EvaluateItem showEvaluateItemById(Integer id) {
		logger.info("--[into showEvaluateItemById method]--");
		// ҵ�����
		// ����dao
		EvaluateItem e = evaluateItemDAO.queryEvaluateItemById(id);
		List<TemplateItemLink> tl = templateItemLinkDAO.queryByItemId(e.getId());
		if (tl == null) {
			e.setIsDelete("y");// ����ɾ
		} else {
			e.setIsDelete("n");// ������ɾ
		}
		return e;
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<EvaluateItem> showEvaluateItems() {
		logger.info("--[into showEvaluateItems method]--");
		// ҵ�����
		// ����dao
		PageUtil.setTotal(evaluateItemDAO.queryEvaluateItemMaxRows());
		List<EvaluateItem> list = evaluateItemDAO.queryAllEvaluateItem(
				PageUtil.getFirstResult(), PageUtil.getLastResult());
		for(EvaluateItem e:list){
			e.setAdminName(e.getAdmin().getUsername());
			List<TemplateItemLink> tl = templateItemLinkDAO.queryByItemId(e.getId());
			if (tl.size()==0) {
				e.setIsDelete("y");// ����ɾ
			} else {
				e.setIsDelete("n");// ������ɾ
			}
		}
		return list;
	}

	@Override
	public List<EvaluateItem> showEvaluateItemsForTemplate() {
		logger.info("--[into showEvaluateItemsForTemplate method]--");
		return evaluateItemDAO.queryAllEvaluateItems();
	}

}
