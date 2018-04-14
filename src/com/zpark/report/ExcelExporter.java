package com.zpark.report;

import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

/**
 * excel格式的数据导出类
 * 
 * @author 孙帅
 * @version 1.0
 * 
 */
public class ExcelExporter implements IExporter {

	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ExcelExporter.class);

	private final static String DEFAULT_SHEET_NAME = "report";

	private List<?> data;

	public ExcelExporter(List<?> data) {
		this.data = data;
	}

	public void export(HttpServletResponse response, ExportCallback callback) throws ExportException {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(DEFAULT_SHEET_NAME);
		sheet.setDefaultColumnWidth((short) 16);
		sheet.setAutobreaks(true);

		//设置报表标题
		HSSFCell titleCell = sheet.createRow(0).createCell((short) (callback.getHeaders().length / 2));
		titleCell.setEncoding(HSSFCell.ENCODING_UTF_16);
		titleCell.setCellValue(callback.getTitle());
		titleCell.setCellStyle(getTitleStyle(wb));

		//设置表头
		HSSFRow headRow = sheet.createRow(1);
		String[] headers = callback.getHeaders();
		for (short i = 0; i < headers.length; i++) {
			HSSFCell cell = headRow.createCell(i);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(headers[i]);
			cell.setCellStyle(getColumnHeaderStyle(wb));

		}

		//设置具体内容
		short rowNum = 0;
		for (Iterator iter = data.iterator(); iter.hasNext();) {
			Object obj = (Object) iter.next();
			HSSFRow dataRow = sheet.createRow(rowNum + 2);

			Object[] cols = callback.getRow(obj);
			for (short i = 0; i < cols.length; i++) {//colums

				HSSFCell cell = dataRow.createCell(i);
				cell.setEncoding(HSSFCell.ENCODING_UTF_16);
				cell.setCellValue(String.valueOf(cols[i]));
				cell.setCellStyle(this.getDetailStyle(wb));
			}
			rowNum++;
		}

		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment;filename="
				+ transEncode(callback.getFileName()) + ".xls");
		try {
			OutputStream out = response.getOutputStream();
			wb.write(out);
			out.flush();
		} catch (Exception e) {
			logger.error("导出excel文件时出现异常", e);
			throw new ExportException("导出excel文件时出现异常", e);
		}
	}

	private String transEncode(String old) {
		if (null == old || old.length() == 0) {
			return old;
		}
		try {
			return new String(old.getBytes("GBK"), "ISO8859_1");
		} catch (Exception e) {
			logger.error("转换[" + old + "]的编码时出错");
			return old;
		}

	}

	/**
	 * 设置报表标题的样式
	 */
	protected HSSFCellStyle getTitleStyle(HSSFWorkbook wb) {
		HSSFCellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(HSSFColor.WHITE.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_NONE);
		style.setBorderRight(HSSFCellStyle.BORDER_NONE);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);

		HSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 18);
		font.setFontName("宋体");
		font.setItalic(false);
		font.setStrikeout(false);
		font.setColor(HSSFColor.BLACK.index);
		style.setFont(font);
		return style;
	}

	/**
	 * 设置报表列标题的样式
	 */
	protected HSSFCellStyle getColumnHeaderStyle(HSSFWorkbook wb) {
		HSSFCellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(HSSFColor.WHITE.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);

		HSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 12);
		font.setFontName("宋体");
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setItalic(false);
		font.setStrikeout(false);
		font.setColor(HSSFColor.BLACK.index);
		style.setFont(font);
		return style;
	}

	/**
	 * 设置数据内容的样式
	 */
	protected HSSFCellStyle getDetailStyle(HSSFWorkbook wb) {
		HSSFCellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(HSSFColor.WHITE.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setWrapText(true);

		HSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 12);
		font.setFontName("宋体");
		font.setItalic(false);
		font.setStrikeout(false);
		font.setColor(HSSFColor.BLACK.index);
		style.setFont(font);
		return style;
	}

}