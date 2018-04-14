package com.zpark.exception;

public class PasswordModifyError extends RuntimeException{
	public PasswordModifyError(String messag){
		super(messag);
	}
}
