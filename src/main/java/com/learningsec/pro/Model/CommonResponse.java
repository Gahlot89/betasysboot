package com.learningsec.pro.Model;

import org.springframework.stereotype.Component;

@Component
public class CommonResponse {

	String Message;
	String Status;
	String Data;
	
	
	
	public CommonResponse() {
	}
	public CommonResponse(String message, String status, String data) {
		Message = message;
		Status = status;
		Data = data;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getData() {
		return Data;
	}
	public void setData(String data) {
		Data = data;
	}
	
	
}
