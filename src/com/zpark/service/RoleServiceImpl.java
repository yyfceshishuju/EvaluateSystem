package com.zpark.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zpark.dao.AssistantDAO;
import com.zpark.dao.TeacherDAO;
import com.zpark.entity.Assistant;
import com.zpark.entity.Teacher;
import com.zpark.exception.PasswordModifyError;

@Service
public class RoleServiceImpl implements RoleService {
	private Logger logger = Logger.getLogger(RoleServiceImpl.class);

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	@Autowired
	private TeacherDAO teacherDAO;
	@Autowired
	private AssistantDAO assistantDAO;

	public TeacherDAO getTeacherDAO() {
		return teacherDAO;
	}

	public void setTeacherDAO(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	public AssistantDAO getAssistantDAO() {
		return assistantDAO;
	}

	public void setAssistantDAO(AssistantDAO assistantDAO) {
		this.assistantDAO = assistantDAO;
	}

	@Override
	@Transactional
	public Teacher teacherLogin(String username, String password) {
		logger.info("-------[into method teacherLogin]-----");
		Teacher t = teacherDAO.queryTeacherByName(username);
		if (password.equals(t.getPassword()))
			return t;
		return null;
	}

	@Override
	@Transactional
	public Assistant assistantLogin(String username, String password) {
		// TODO Auto-generated method stub
		logger.info("-------[into method assistantLogin]-----");
		Assistant a = assistantDAO.queryAssistantByUsername(username);
		if (password.equals(a.getPassword()))
			return a;
		return null;
	}

	@Override
	@Transactional(rollbackFor=java.lang.RuntimeException.class)
	public void teacherModifyPassword(Integer id, String oldPassword,
			String newPassword) {
		logger.info("-------[into method teacherModifyPassword]-----");
		// TODO Auto-generated method stub
		Teacher t = teacherDAO.queryTeacherById(id);
		if (!oldPassword.equals(t.getPassword())) {
			throw new PasswordModifyError("√‹¬Î–ﬁ∏ƒ ß∞‹£¨‘≠ º√‹¬Î ‰»Î¥ÌŒÛ£°");
		}
		t.setPassword(newPassword);
		teacherDAO.updateTeacher(t);
	}

	@Override
	@Transactional(rollbackFor=java.lang.RuntimeException.class)
	public void assistantModifyPassword(Integer id, String oldPassword,
			String newPassword) {
		logger.info("-------[into method assistantModifyPassword]-----");
		// TODO Auto-generated method stub
		Assistant a = assistantDAO.queryAssistantById(id);
		if (!oldPassword.equals(a.getPassword()))
			throw new PasswordModifyError("√‹¬Î–ﬁ∏ƒ ß∞‹£¨‘≠ º√‹¬Î ‰»Î¥ÌŒÛ£°");
		a.setPassword(newPassword);
		assistantDAO.updateAssistant(a);
	}
}
