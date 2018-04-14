package com.zpark.exception;

import org.apache.log4j.Logger;


public class UserNameAndPasswordException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String errorMsg;
	static Logger log = Logger.getLogger(UserNameAndPasswordException.class);
	/**
	 * 
	 * @param errorMsg�������쳣��Ϣ
	 */
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public UserNameAndPasswordException(String errorMsg) {
		super();
		this.errorMsg = errorMsg;
	}
}
