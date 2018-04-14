package com.zpark.report;

/**
 * ���ݵ����Ļص��ӿڣ�������õ���������Ҫ���������
 * 
 * @author ��˧
 * @version 1.0
 * 
 */
public interface ExportCallback<T> {

	/**
	 * �õ������ļ���
	 */
	public String getFileName();

	/**
	 * �õ������ļ��ı���
	 */
	public String getTitle();

	/**
	 * �õ���ͷ
	 */
	public String[] getHeaders();

	/**
	 * ���ݴ����Ķ��󣬵õ�һ������
	 */
	public Object[] getRow(T rowObject);
}
