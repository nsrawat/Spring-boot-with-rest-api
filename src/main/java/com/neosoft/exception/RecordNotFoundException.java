package com.neosoft.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException {

	private String exceptionDetail;
	private Object fieldValue;
	
	public RecordNotFoundException( String exceptionDetail, String firstName) {
		super(exceptionDetail+" - "+firstName);
		this.exceptionDetail = exceptionDetail;
		this.fieldValue = firstName;
	}
		
	public String getExceptionDetail() {
		return exceptionDetail;
	}
	
	public Object getFieldValue() {
		return fieldValue;
	}
}