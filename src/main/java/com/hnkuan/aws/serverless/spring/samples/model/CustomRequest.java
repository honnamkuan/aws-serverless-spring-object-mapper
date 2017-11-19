package com.hnkuan.aws.serverless.spring.samples.model;

/**
 * Created on 19/11/2017
 *
 * @author honnamkuan
 */
public class CustomRequest {

    private int id;

    private String request;

    public int getId() {
        return id;
    }

    public void setId(int pId) {
        id = pId;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String pRequest) {
        request = pRequest;
    }
}
