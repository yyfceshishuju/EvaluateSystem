package com.zpark.report;

import javax.servlet.http.HttpServletResponse;

/**
 * ˵�������ݵ����ӿڡ����ڽ����ݵ�����csv,excel���ⲿ�ļ��С�
 * 
 * @author ��˧
 */
public interface IExporter {

	public void export(HttpServletResponse response, ExportCallback callback) throws ExportException;

}