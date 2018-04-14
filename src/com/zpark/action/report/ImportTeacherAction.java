package com.zpark.action.report;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.zpark.entity.Admin;
import com.zpark.entity.Evaluate;
import com.zpark.entity.EvaluateDetail;
import com.zpark.entity.Teacher;
import com.zpark.entity.Template;
import com.zpark.entity.User;
import com.zpark.exception.ImportException;
import com.zpark.service.ReportDataService;
@Controller
@Scope("prototype")
public class ImportTeacherAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	@Autowired
	private ReportDataService reportDataService;
	private static Logger logger = Logger.getLogger(ImportUserAction.class);
	private String clazz;
	private String name;
	private File[] upload; // 临时的，会在请求结束后由struts删除 aaa
	private String[] uploadFileName; // 上传文件的原始文件名 aaaFileName
	private String uploadContentType;
	
	public ReportDataService getReportDataService() {
		return reportDataService;
	}
	public void setReportDataService(ReportDataService reportDataService) {
		this.reportDataService = reportDataService;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String[] getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String[] uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	
	public File[] getUpload() {
		return upload;
	}
	public void setUpload(File[] upload) {
		this.upload = upload;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String execute() {
		// 如果上传的文件类型不匹配，upload 是null
		logger.debug(upload+"----------------upload");
		if(upload == null) {
			return ERROR;
		}
		for(String str:uploadFileName){
			logger.debug("原始文件名：" +str);
		}
		logger.debug("普通的name参数:" + name);
		logger.debug("上传文件的内容类型:" + uploadContentType);
		InputStream evaluateIs = null;
		InputStream evaluateDetailIs = null;
		List<Evaluate> evaluateList = new ArrayList<Evaluate>();
		List<EvaluateDetail> evaluateDetailList = new ArrayList<EvaluateDetail>();
		try {
			evaluateIs = new FileInputStream(upload[0]);
			evaluateDetailIs = new FileInputStream(upload[1]);
			//读取教评汇总表
			evaluateList = readEvaluates(evaluateIs,clazz);
			Evaluate e = evaluateList.get(0);
			logger.debug(e);
			if(!e.getClazz().equals(clazz)){
				return ERROR;
			}
			//读取教评详情表
			evaluateDetailList = readEvaluateDetails(evaluateDetailIs,clazz);
			for(EvaluateDetail ed:evaluateDetailList){
				logger.debug(ed );
				if(!(ed.getEvaluate().getId()).equals(e.getId()) ){
					return ERROR;
				}
			}
			Map<String,Object> insertMap = new HashMap<String,Object>();
			insertMap.put("eList", evaluateList);
			insertMap.put("edList", evaluateDetailList);
			reportDataService.createTeacherEvaluate(insertMap);
			reportDataService.createTeacherEvaluateDetail(insertMap);
		} catch (Exception e) {
			logger.debug(e.getMessage());
			return ERROR;
		} finally {
			if (evaluateIs != null){
				try {
					evaluateIs.close();
				} catch (IOException e) {
				}
			}
			if(evaluateDetailIs != null){
				try{
					evaluateDetailIs.close();
				}catch(Exception e){
					
				}
			}
		}
		return SUCCESS;
	}
	
	public static List<Evaluate> readEvaluates(InputStream is,String cla) throws Exception {
		List<Evaluate> list = new ArrayList<Evaluate>();
		HSSFWorkbook workbook = new HSSFWorkbook(is);
		// 拿到xls文件下面的所有sheet
		try {
			for (int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
				HSSFSheet sheet = workbook.getSheetAt(sheetIndex);
				Evaluate evaluate = null;	
				for (int rowNum = 2; rowNum <= sheet.getLastRowNum(); rowNum++) {
					HSSFRow row = sheet.getRow(rowNum);
					evaluate = new Evaluate();
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					for (short cellnum = 0; cellnum <= row.getLastCellNum(); cellnum++) {
						HSSFCell cell = row.getCell(cellnum);
						switch(cellnum){
						case 0:
							String copyId = cell.getStringCellValue();
							String id=cla+copyId;
							evaluate.setId(Integer.parseInt(id));
							break;
						case 1:
							String clazz = cell.getStringCellValue();
							evaluate.setClazz(clazz);
							break;
						case 2:
							String clazzCount = cell.getStringCellValue();
							evaluate.setClazzCount(Integer.parseInt(clazzCount));
							break;
						case 3:
							String realCount = cell.getStringCellValue();
							evaluate.setRealCount(Integer.parseInt(realCount));
							break;
						case 4:
							String subject = cell.getStringCellValue();
							evaluate.setSubject(subject);
							break;
						case 5:
								String templateId = cell.getStringCellValue();
								Template t = new Template();
								t.setId(1);
								evaluate.setTemplate(t);
								break;
						case 6:
							String teacherId = cell.getStringCellValue();
							Teacher tea = new Teacher();
							tea.setId(Integer.parseInt(teacherId));
							evaluate.setTeacher(tea);
							break;
						case 7:
							String totalScore = cell.getStringCellValue();
							evaluate.setTotalScore(Double.parseDouble(totalScore));
							break;
						case 8:
							String scoreDetail = cell.getStringCellValue();
							evaluate.setScoreDetail(scoreDetail);
							break;
						case 9:
							String beginDate = cell.getStringCellValue();
							Date date1 = dateFormat.parse(beginDate);
							evaluate.setBeginDate(new java.sql.Date (date1.getTime()));
							break;	
						case 10:
							String endDate = cell.getStringCellValue();
							Date date2 = dateFormat.parse(endDate);
							evaluate.setEndDate(new java.sql.Date (date2.getTime()));
							break;	
						case 11:
							String createDate = cell.getStringCellValue();
							Date date3 = dateFormat.parse(createDate);
							evaluate.setCreateDate(new java.sql.Date (date3.getTime()));						break;	
						case 12:
							String statu = cell.getStringCellValue();
							evaluate.setStatu(statu);
							break;
						case 13:
							String adminId = cell.getStringCellValue();
							Admin admin = new Admin();
							admin.setId(Integer.parseInt(adminId));
							evaluate.setAdmin(admin);
							break;
						}
					}
					list.add(evaluate);
				}	
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ImportException("文件格式错误，读取讲师测评表失败");
		}
		return list;
	}
	
	public static List<EvaluateDetail> readEvaluateDetails(InputStream is,String clazz) throws Exception {
		List<EvaluateDetail> list = new ArrayList<EvaluateDetail>();
		HSSFWorkbook workbook = new HSSFWorkbook(is);
		try{
			// 拿到xls文件下面的所有sheet
			for (int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
				HSSFSheet sheet = workbook.getSheetAt(sheetIndex);
				EvaluateDetail evaluateDetail = null;	
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				for (int rowNum = 2; rowNum <= sheet.getLastRowNum(); rowNum++) {
					HSSFRow row = sheet.getRow(rowNum);
					evaluateDetail = new EvaluateDetail();
					for (short cellnum = 0; cellnum <= row.getLastCellNum(); cellnum++) {
						HSSFCell cell = row.getCell(cellnum);
						switch(cellnum){
						case 0:
							String copyId = cell.getStringCellValue();
							String id= clazz+copyId;
							evaluateDetail.setId(Integer.parseInt(id));
							break;
						case 1:
							String copyuid = cell.getStringCellValue();
							User user  = new User();
							String uid = clazz+copyuid;
							user.setId(Integer.parseInt(uid));
							evaluateDetail.setUser(user);
							break;
						case 2:
							String scoreDetail = cell.getStringCellValue();
							evaluateDetail.setScoreDetail(scoreDetail);
							break;
						case 3:
							String commendDetail = cell.getStringCellValue();
							evaluateDetail.setCommendDetail(commendDetail);
							break;
						case 4:
							String copyevaId = cell.getStringCellValue();
							String eid = clazz+copyevaId;
							Evaluate eva = new Evaluate();
							eva.setId(Integer.parseInt(eid));
							evaluateDetail.setEvaluate(eva);
							break;
						case 5:
							String score = cell.getStringCellValue();
							evaluateDetail.setTotalScore(Double.parseDouble(score));
							break;
						case 6:
							String createDate = cell.getStringCellValue();
							Date date1 = dateFormat.parse(createDate);
							evaluateDetail.setCreateDate(new java.sql.Date (date1.getTime()));
							break;			
						}
					}
					list.add(evaluateDetail);
				}	
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new ImportException("文件格式错误，读取讲师测评详细信息失败");
		}
		return list;
	}
}
