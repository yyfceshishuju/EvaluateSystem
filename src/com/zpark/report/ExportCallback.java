package com.zpark.report;

/**
 * 数据导出的回调接口，用来获得导出过程需要的相关数据
 * 
 * @author 孙帅
 * @version 1.0
 * 
 */
public interface ExportCallback<T> {

	/**
	 * 得到导出文件名
	 */
	public String getFileName();

	/**
	 * 得到导出文件的标题
	 */
	public String getTitle();

	/**
	 * 得到表头
	 */
	public String[] getHeaders();

	/**
	 * 根据传来的对象，得到一行数据
	 */
	public Object[] getRow(T rowObject);
}
