package com.zpark.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zpark.dao.EvaluateDao;
import com.zpark.dao.EvaluateZjDao;
import com.zpark.dao.ReportDataDAO;
import com.zpark.dao.UserDAO;
import com.zpark.entity.Evaluate;
import com.zpark.entity.EvaluateDetail;
import com.zpark.entity.User;
import com.zpark.entity.ZJEvaluate;
import com.zpark.entity.ZJEvaluateDetail;
import com.zpark.exception.EvaluateDaoException;
import com.zpark.exception.EvaluateServiceException;
import com.zpark.exception.EvaluateZjDaoException;
import com.zpark.exception.EvaluateZjServiceException;
import com.zpark.util.GenerationDetailUtil;

@Service
@Transactional
public class ReportDataServiceImpl implements ReportDataService {
	private static Logger logger = Logger
			.getLogger(ReportDataServiceImpl.class);
	@Autowired
	private ReportDataDAO reportDataDAO;
	@Autowired
	private EvaluateDao evaluateDao;
	@Autowired
	private UserDAO userDao;
	@Autowired
	private EvaluateZjDao evaluateZjDao;
	
	public UserDAO getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	public EvaluateZjDao getEvaluateZjDao() {
		return evaluateZjDao;
	}

	public void setEvaluateZjDao(EvaluateZjDao evaluateZjDao) {
		this.evaluateZjDao = evaluateZjDao;
	}

	public EvaluateDao getEvaluateDao() {
		return evaluateDao;
	}

	public void setEvaluateDao(EvaluateDao evaluateDao) {
		this.evaluateDao = evaluateDao;
	}

	public ReportDataDAO getReportDataDAO() {
		return reportDataDAO;
	}

	public void setReportDataDAO(ReportDataDAO reportDataDAO) {
		this.reportDataDAO = reportDataDAO;
	}

	@Override
	/**
	 * 方法描述：  插入用户信息
	 */
	@Transactional
	public void createUsers(List<User> list) throws Exception {
		try {
			logger.debug("in method reportDataServiceImpl createUsers");
			for (User user : list) {
				User u = userDao.queryUserById(user.getId());
				if(u != null){
					continue;
				}
				reportDataDAO.saveUsers(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void createTeacherEvaluate(Map<String, Object> map) throws Exception {
		List<Evaluate> eList = (List<Evaluate>) map.get("eList");
		try {
			// 插入教评信息
			for (Evaluate e : eList) {
				Evaluate eva = evaluateDao.queryEvaluateDetailByEvaluateId(e
						.getId());
				if (eva != null) {
					continue;
				}
				reportDataDAO.saveEvaluates(e);
			}
		} catch (EvaluateDaoException e) {
			logger.debug(e.getMessage());
			throw new EvaluateServiceException("dao 层错误");
		} catch (EvaluateServiceException e) {
			e.printStackTrace();
			logger.debug(e.getMessage());
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug(e.getMessage());
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void createTeacherEvaluateDetail(Map<String, Object> map)
			throws Exception {
		List<Evaluate> eList = (List<Evaluate>) map.get("eList");
		List<EvaluateDetail> edList = (List<EvaluateDetail>) map.get("edList");
		// 插入教评详细信息
		try {
			for (EvaluateDetail ed : edList) {
				reportDataDAO.saveEvaluateDetails(ed);
			}
			String stringCommendDetail = "";
			String stringScoreDetail = null;
			double averageTotalSocre = 0;
			averageTotalSocre = evaluateDao.queryAverageTotalScore(eList.get(0)
					.getId());
			DecimalFormat df = new DecimalFormat("0.000 ");
			double score = Double.parseDouble(df.format(averageTotalSocre));
			if (score == 0) {
				throw new EvaluateServiceException("无法生成平均分");
			}
			logger.debug(score);
			List<String> scoreDetailList = new ArrayList<String>();
			for (EvaluateDetail ed : edList) {
				scoreDetailList.add(ed.getScoreDetail());
			}
			stringScoreDetail = GenerationDetailUtil
					.generateCommendDetail(scoreDetailList);
			Evaluate e = new Evaluate();
			e.setId(eList.get(0).getId());
			e.setCommendDetail(stringCommendDetail);
			e.setTotalScore(score);
			e.setScoreDetail(stringScoreDetail);
			evaluateDao.updateEvaluateTotalScoreAndCommendDetail(e);
		} catch (EvaluateDaoException e) {
			logger.debug(e.getMessage());
			throw new EvaluateServiceException("dao 层错误");
		} catch (EvaluateServiceException e) {
			e.printStackTrace();
			logger.debug(e.getMessage());
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug(e);
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	/**
	 * 方法描述:插入教评信息及教评详细信息，并且生成教评结果
	 */
	public void createAssistantEvaluate(Map<String,Object>  map)
			throws Exception {
		logger.debug("method in createAssistantEvaluate");
		List<ZJEvaluate> eList = (List<ZJEvaluate>) map.get("eListZJ");
		// 插入教评信息
		try {
			for (ZJEvaluate e : eList) {
				reportDataDAO.saveEvaluatesZJ(e);
			}
		} catch (EvaluateZjDaoException e) {
			logger.debug(e.getMessage());
			throw new EvaluateZjServiceException("dao 层错误");
		} catch (EvaluateZjServiceException e) {
			e.printStackTrace();
			logger.debug(e.getMessage());
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug(e.getMessage());
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void createAssistantEvaluateDetail(Map<String, Object> map)
			throws Exception {
		List<ZJEvaluate> eList = (List<ZJEvaluate>) map.get("eListZJ");
		List<ZJEvaluateDetail> edList = (List<ZJEvaluateDetail>) map.get("edListZJ");
		try {
			// 插入教评详细信息
			for (ZJEvaluateDetail ed : edList) {
				reportDataDAO.saveEvaluateDetailsZJ(ed);
			}
			String stringCommendDetail = "";
			String stringScoreDetail = null;
			double averageTotalSocre = 0;
			averageTotalSocre = evaluateDao.queryAverageTotalScore(eList.get(0).getId());
			DecimalFormat df = new DecimalFormat("0.000 ");
			double score = Double.parseDouble(df.format(averageTotalSocre));
			if (score == 0) {
				throw new EvaluateZjServiceException("无法生成平均分");
			}
			logger.debug(score);
			List<String> scoreDetailList = new ArrayList<String>();
			for (ZJEvaluateDetail ed : edList) {
				scoreDetailList.add(ed.getScoreDetail());
			}
			stringScoreDetail = GenerationDetailUtil
					.generateCommendDetail(scoreDetailList);
			ZJEvaluate e = new ZJEvaluate();
			e.setId(eList.get(0).getId());
			e.setCommendDetail(stringCommendDetail);
			e.setTotalScore(score);
			e.setScoreDetail(stringScoreDetail);
			evaluateZjDao.updateEvaluateTotalScoreAndCommendDetail(e);
		} catch (EvaluateZjDaoException e) {
			logger.debug(e.getMessage());
			throw new EvaluateZjServiceException("dao 层错误");
		} catch (EvaluateZjServiceException e) {
			e.printStackTrace();
			logger.debug(e.getMessage());
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug(e.getMessage());
			throw e;
		}
	}

}
