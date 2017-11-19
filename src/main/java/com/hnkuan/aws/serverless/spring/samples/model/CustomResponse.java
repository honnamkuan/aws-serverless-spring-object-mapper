package com.hnkuan.aws.serverless.spring.samples.model;

/**
 * Created on 19/11/2017
 *
 * @author honnamkuan
 */
public class CustomResponse {

    private String message;

    private int errorCode;

    public String getMessage() {
        return message;
    }

    public void setMessage(String pMessage) {
        message = pMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int pErrorCode) {
        errorCode = pErrorCode;
    }
}
