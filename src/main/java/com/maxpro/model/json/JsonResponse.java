package com.maxpro.model.json;


public class JsonResponse {

    private int code;
    private String status;

    public JsonResponse() {
    }

    public JsonResponse(int code, String status) {
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
        return "JsonResponse{" +
                "code=" + code +
                ", status='" + status + '\'' +
                '}';
    }
}
