package com.bingsoo.job.dto;

public class SubscribeRequest {
    private long postCode;
    private String rid;

    
    public long getPostCode() {
        return postCode;
    }

    public void setPostCode(long postCode) {
        this.postCode = postCode;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }
}