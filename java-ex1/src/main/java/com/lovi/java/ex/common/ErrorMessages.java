package com.lovi.java.ex.common;

public enum ErrorMessages {
	SIGN_IN_FAIL("please check userId and password"),
	UNABLE_TO_FOUND_RESOURSES("unable to found resourses"),
	SERVER_ERROR("unable to found resourses"), 
	USER_UPDATE_FAIL("update fail.unable to found user id"), 
	USER_DELETE_FAIL("delete fail.unable to found user id"), 
	USER_CREATE_FAIL("user create fail.user allready exists"), 
	UNABLE_TO_FOUND_USER("please check user id"), 
	INPUT_PARM_PARSE_ERROR("input parameter parse error");

	private String errorMessage;
	private ErrorMessages(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getMessage(){
		return errorMessage;
	}
}
