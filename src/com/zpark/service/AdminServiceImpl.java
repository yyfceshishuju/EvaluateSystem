package com.zpark.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.zpark.dao.AdminDAO;
import com.zpark.entity.Admin;

@Service
public class AdminServiceImpl implements AdminService {
	private Logger logger = Logger.getLogger(AdminServiceImpl.class);

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	@Autowired
	private AdminDAO adminDAO;

	public AdminDAO getAdminDAO() {
		return adminDAO;
	}

	public void setAdminDAO(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Admin showAdminById(Integer id) {
		logger.info("---[into showAdminById method]----");
		// TODO Auto-generated method stub
		return adminDAO.queryAdminById(id);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public boolean login(String username, String password) {
		logger.info("---[into login method]----");
		// TODO Auto-generated method stub
		Admin admin = adminDAO.queryAdminByUsername(username);
		try {
			if (password.equals(admin.getPassword()))
				return true;
		} catch (Exception e) {
			logger.info("-----[µÇÂ½Ê§°Ü]--------");
		}
		return false;
	}

	@Override
	public Admin queryAdminByUsername(String adminName) {
		// TODO Auto-generated method stub
		logger.info("---[into queryAdminByUsername method]----");
		Admin admin = adminDAO.queryAdminByUsername(adminName);
		return admin;
	}
}
