package com.zpark.exception;

public class ImportException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ImportException(){};
	public ImportException(String str){
		super(str);
	}
	
}
