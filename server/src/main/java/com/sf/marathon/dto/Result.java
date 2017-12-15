package com.sf.marathon.dto;

import java.io.Serializable;

public class Result<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	private String errorMsg;
	private T response;
	private Boolean isSuccess = true;

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public T getResponse() {
		return response;
	}

	public void setResponse(T response) {
		this.response = response;
	}

	public Boolean getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

}
