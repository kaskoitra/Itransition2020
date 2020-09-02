package com.example.dto;

public class RestResponseDto {

    private Integer responseCode;
    private String message;

    public RestResponseDto(Integer responseCode){
        super();
        this.responseCode = responseCode;
    }
    public RestResponseDto(Integer responseCode, String message){
        super();
        this.responseCode = responseCode;
        this.message = message;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
