package com.lovi.java.ex.common;

public class ResponseMessage {
	
	private int status;
	private Object value;
	
	public ResponseMessage(int status, Object value) {
		super();
		this.status = status;
		this.value = value;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	
	
}
