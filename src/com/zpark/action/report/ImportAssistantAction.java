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
import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionSupport;
import com.zpark.entity.Admin;
import com.zpark.entity.Assistant;
import com.zpark.entity.Evaluate;
import com.zpark.entity.EvaluateDetail;
import com.zpark.entity.User;
import com.zpark.entity.ZJEvaluate;
import com.zpark.entity.ZJEvaluateDetail;
import com.zpark.entity.ZJTemplate;
import com.zpark.exception.ImportException;
import com.zpark.service.ReportDataService;
@Service
@Scope("prototype")
public class ImportAssistantAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	@Autowired
	private ReportDataService reportDataService;
	private static Logger logger = Logger.getLogger(ImportAssistantAction.class);
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
		InputStream evaluateIsZJ = null;
		InputStream evaluateDetailIsZJ = null;
		List<ZJEvaluate> evaluateListZJ = new ArrayList<ZJEvaluate>();
		List<ZJEvaluateDetail> evaluateDetailListZJ = new ArrayList<ZJEvaluateDetail>();
		try {
			evaluateIsZJ = new FileInputStream(upload[0]);
			evaluateDetailIsZJ = new FileInputStream(upload[1]);
			//读取助教教评汇总表
			evaluateListZJ = readEvaluatesZJ(evaluateIsZJ,clazz);
			ZJEvaluate ze =  evaluateListZJ.get(0);
			logger.debug(ze.getId()+"--"+ze.getSubject());
			if(!ze.getClazz().equals(clazz)){
				return ERROR;
			}
			//读取助教教评详情表
			evaluateDetailListZJ = readEvaluateDetailsZJ(evaluateDetailIsZJ,clazz);
			logger.debug("参与测评人数："+evaluateDetailListZJ.size());
			for(ZJEvaluateDetail ed:evaluateDetailListZJ){
				if(!(ed.getZjevaluate().getId()).equals(ze.getId())){
					return ERROR;
				}
			}
			Map<String,Object> insertMapZJ = new HashMap<String,Object>();
			insertMapZJ.put("eListZJ", evaluateListZJ);
			insertMapZJ.put("edListZJ", evaluateDetailListZJ);
			reportDataService.createAssistantEvaluate(insertMapZJ);
			reportDataService.createAssistantEvaluateDetail(insertMapZJ);
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug(e.getMessage());
			return ERROR;
		} finally {
			if (evaluateIsZJ != null){
				try {
					evaluateIsZJ.close();
				} catch (IOException e) {
				}
			}
			if(evaluateDetailIsZJ != null){
				try{
					evaluateDetailIsZJ.close();
				}catch(Exception e){
					
				}
			}
		}
		return SUCCESS;
	}
	
	public static List<ZJEvaluate> readEvaluatesZJ(InputStream is,String cla) throws Exception {
		List<ZJEvaluate> list = new ArrayList<ZJEvaluate>();
		logger.debug("in method importTeacherAction readEvaluates");
		HSSFWorkbook workbook = new HSSFWorkbook(is);
		// 拿到xls文件下面的所有sheet
		try {
			for (int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
				logger.debug("sheet:"+sheetIndex+"------"+workbook.getNumberOfSheets());
				HSSFSheet sheet = workbook.getSheetAt(sheetIndex);
				logger.debug("row:"+sheet.getLastRowNum());
				ZJEvaluate evaluateZJ = null;	
				for (int rowNum = 2; rowNum <= sheet.getLastRowNum(); rowNum++) {
					HSSFRow row = sheet.getRow(rowNum);
					evaluateZJ = new ZJEvaluate();
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					for (short cellnum = 0; cellnum <= row.getLastCellNum(); cellnum++) {
						HSSFCell cell = row.getCell(cellnum);
						switch(cellnum){
						case 0:
							String copyId = cell.getStringCellValue();
							String id=cla+copyId;
							evaluateZJ.setId(Integer.parseInt(id));
							break;
						case 1:
							String clazz = cell.getStringCellValue();
							evaluateZJ.setClazz(clazz);
							break;
						case 2:
							String clazzCount = cell.getStringCellValue();
							evaluateZJ.setClazzCount(Integer.parseInt(clazzCount));
							break;
						case 3:
							String realCount = cell.getStringCellValue();
							evaluateZJ.setRealCount(Integer.parseInt(realCount));
							break;
						case 4:
							String subject = cell.getStringCellValue();
							evaluateZJ.setSubject(subject);
							break;
						case 5:
								String templateId = cell.getStringCellValue();
								ZJTemplate t = new ZJTemplate();
								t.setId(1);
								evaluateZJ.setZjTemplate(t);
								break;
						case 6:
							String AssistantId = cell.getStringCellValue();
							Assistant ass = new Assistant();
							ass.setId(Integer.parseInt(AssistantId));
							evaluateZJ.setAssistant(ass);
							break;
						case 7:
							String totalScore = cell.getStringCellValue();
							evaluateZJ.setTotalScore(Double.parseDouble(totalScore));
							break;
						case 8:
							String scoreDetail = cell.getStringCellValue();
							evaluateZJ.setScoreDetail(scoreDetail);
							break;
						case 9:
							String beginDate = cell.getStringCellValue();
							Date date1 = dateFormat.parse(beginDate);
							evaluateZJ.setBeginDate(new java.sql.Date (date1.getTime()));
							break;	
						case 10:
							String endDate = cell.getStringCellValue();
							Date date2 = dateFormat.parse(endDate);
							evaluateZJ.setEndDate(new java.sql.Date (date2.getTime()));
							break;	
						case 11:
							String createDate = cell.getStringCellValue();
							Date date3 = dateFormat.parse(createDate);
							evaluateZJ.setCreateDate(new java.sql.Date (date3.getTime()));						break;	
						case 12:
							String statu = cell.getStringCellValue();
							evaluateZJ.setStatu(statu);
							break;
						case 13:
							String adminId = cell.getStringCellValue();
							Admin admin = new Admin();
							admin.setId(Integer.parseInt(adminId));
							evaluateZJ.setAdmin(admin);
							break;
						}
					}
					list.add(evaluateZJ);
				}	
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ImportException("文件格式错误，读取助教测评表失败");
		}
		return list;
	}
	
	public static List<ZJEvaluateDetail> readEvaluateDetailsZJ(InputStream is,String cla) throws Exception {
		List<ZJEvaluateDetail> list = new ArrayList<ZJEvaluateDetail>();
		HSSFWorkbook workbook = new HSSFWorkbook(is);
		try{
			// 拿到xls文件下面的所有sheet
			for (int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
				HSSFSheet sheet = workbook.getSheetAt(sheetIndex);
				ZJEvaluateDetail ZJevaluateDetail = null;	
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				for (int rowNum = 2; rowNum <= sheet.getLastRowNum(); rowNum++) {
					HSSFRow row = sheet.getRow(rowNum);
					ZJevaluateDetail = new ZJEvaluateDetail();
					for (short cellnum = 0; cellnum <= row.getLastCellNum(); cellnum++) {
						HSSFCell cell = row.getCell(cellnum);
						switch(cellnum){
						case 0:
							String copyId = cell.getStringCellValue();
							String id= cla+copyId;
							ZJevaluateDetail.setId(Integer.parseInt(id));
							break;
						case 1:
							String copyuid = cell.getStringCellValue();
							User user  = new User();
							String uid = cla+copyuid;
							user.setId(Integer.parseInt(uid));
							ZJevaluateDetail.setUser(user);
							break;
						case 2:
							String scoreDetail = cell.getStringCellValue();
							ZJevaluateDetail.setScoreDetail(scoreDetail);
							break;
						case 3:
							String commendDetail = cell.getStringCellValue();
							ZJevaluateDetail.setCommendDetail(commendDetail);
							break;
						case 4:
							String copyevaId = cell.getStringCellValue();
							String eid = cla+copyevaId;
							ZJEvaluate eva = new ZJEvaluate();
							eva.setId(Integer.parseInt(eid));
							ZJevaluateDetail.setZjevaluate(eva);
							break;
						case 5:
							String score = cell.getStringCellValue();
							ZJevaluateDetail.setTotalScore(Double.parseDouble(score));
							break;
						case 6:
							String createDate = cell.getStringCellValue();
							Date date1 = dateFormat.parse(createDate);
							ZJevaluateDetail.setCreateDate(new java.sql.Date (date1.getTime()));
							break;			
						}
					}
					list.add(ZJevaluateDetail);
				}	
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new ImportException("文件格式错误，读取助教测评相信信息失败");
		}
		return list;
	}
}
