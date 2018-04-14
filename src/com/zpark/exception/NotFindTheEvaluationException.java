package com.zpark.exception;

import org.apache.log4j.Logger;

public class NotFindTheEvaluationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorMsg;
	static Logger log = Logger.getLogger(NotFindTheEvaluationException.class);
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public NotFindTheEvaluationException(String errorMsg) {
		super();
		this.errorMsg = errorMsg;
	}
}
