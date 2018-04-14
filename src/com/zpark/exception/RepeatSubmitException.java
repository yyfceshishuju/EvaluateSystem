package com.zpark.exception;

import org.apache.log4j.Logger;

public class RepeatSubmitException extends RuntimeException {
	/**
	 * 设置异常信息
	 */
	private static final long serialVersionUID = 1L;
	private String errorMsg;
	static Logger log = Logger.getLogger(RepeatSubmitException.class);
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public RepeatSubmitException(String errorMsg) {
		super();
		this.errorMsg = errorMsg;
	}
}
