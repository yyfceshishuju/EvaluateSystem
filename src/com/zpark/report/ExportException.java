package com.zpark.report;


/**
 * 说明：导出操作的异常类
 * 
 * @author 孙帅
 */
public class ExportException extends RuntimeException {

	private static final long serialVersionUID = -7122018241810679658L;

	public ExportException(String arg0) {
		super(arg0);

	}

	public ExportException(String arg0, Throwable arg1) {
		super(arg0, arg1);

	}
}