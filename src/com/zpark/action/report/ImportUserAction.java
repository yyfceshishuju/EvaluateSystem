package com.zpark.action.report;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.zpark.entity.User;
import com.zpark.exception.ImportException;
import com.zpark.service.ReportDataService;
import com.zpark.util.MD5Util;

@Controller
@Scope("prototype")
public class ImportUserAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private ReportDataService reportDataService;
	private static Logger logger = Logger.getLogger(ImportUserAction.class);
	private String clazz;
	private String name;
	private File upload; // 临时的，会在请求结束后由struts删除 aaa
	private String uploadFileName; // 上传文件的原始文件名 aaaFileName
	private String uploadContentType;
	
	public ReportDataService getReportDataService() {
		return reportDataService;
	}
	public void setReportDataService(ReportDataService reportDataService) {
		this.reportDataService = reportDataService;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
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
		System.out.println(upload+"----------------upload");
		if(upload == null) {
			return ERROR;
		}
		logger.debug("原始文件名：" +uploadFileName);
		InputStream is = null;
		try {
			logger.debug(upload.getPath());
			is = new FileInputStream(upload);
			List<User>  list = 	readInfo(is,clazz);
			for(User user:list){
				logger.debug(user);
				if((!user.getClazz().equals(clazz))){
					return ERROR;
				}
			}
			reportDataService.createUsers(list);
		} catch (Exception e) {
			logger.debug(e.getMessage());
			return ERROR;
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
				}
			}
		}
		return SUCCESS;
	}

	public static List<User> readInfo(InputStream is,String clazz) throws Exception {
		List<User> list = new ArrayList<User>();
		HSSFWorkbook workbook = new HSSFWorkbook(is);
		// 拿到xls文件下面的所有sheet
		try{
			for (int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
				HSSFSheet sheet = workbook.getSheetAt(sheetIndex);
				User user = null;	
				for (int rowNum = 2; rowNum <= sheet.getLastRowNum(); rowNum++) {
					HSSFRow row = sheet.getRow(rowNum);
					user = new User();
					for (short cellnum = 0; cellnum <= row.getLastCellNum(); cellnum++) {
						HSSFCell cell = row.getCell(cellnum);
						switch(cellnum){
						case 0:
							String coptId = cell.getStringCellValue();
							String strId = clazz+coptId;
							int id = Integer.parseInt(strId);
							user.setId(id);
							break;
						case 1:
							String name = cell.getStringCellValue();
							user.setName(name);
							break;
						case 2:
							String password = cell.getStringCellValue();
							user.setPassword(password);
							break;
						case 3:
							String passwordQuestion = cell.getStringCellValue();
							user.setPasswordQuestion(passwordQuestion);
							break;
						case 4:
							String passwordAnswer = cell.getStringCellValue();
							user.setPasswordAnswer(passwordAnswer);
							break;
						case 5:
								String date = cell.getStringCellValue();
								SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
								Date date1 = dateFormat.parse(date);
								user.setCreateDate(new java.sql.Date (date1.getTime()));
								break;
						case 6:
							String cla = cell.getStringCellValue();
							user.setClazz(cla);
							break;
						case 7:
							String statu = cell.getStringCellValue();
							user.setStatu(statu);
							break;
						case 8:
							String ip = cell.getStringCellValue();
							user.setIp(ip);
							break;						
						}
					}
					list.add(user);
				}	
			}
		}catch(Exception e){
			throw new ImportException("文件格式错误，读取失败");
		}
		return list;
	}
}
