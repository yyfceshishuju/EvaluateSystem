package com.zpark.report;

import javax.servlet.http.HttpServletResponse;

/**
 * 说明：数据导出接口。用于将数据导出到csv,excel等外部文件中。
 * 
 * @author 孙帅
 */
public interface IExporter {

	public void export(HttpServletResponse response, ExportCallback callback) throws ExportException;

}