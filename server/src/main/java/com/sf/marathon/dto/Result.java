package com.sf.marathon.dto;

import java.io.Serializable;

public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    private String errorMsg;
    private T reponse;
    private Boolean isSuccess;

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getReponse() {
        return reponse;
    }

    public void setReponse(T reponse) {
        this.reponse = reponse;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }
}
