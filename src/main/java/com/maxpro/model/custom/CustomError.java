package com.maxpro.model.custom;


public class CustomError {

    private int code;
    private String status;

    public CustomError() {
    }

    public CustomError(int code, String status) {
        this.code = code;
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CustomError{" +
                "code=" + code +
                ", status='" + status + '\'' +
                '}';
    }
}
