package com.bingsoo.job.dto;

public class ApplyRequest {
    private long postCode;
    private String rid;
    private long resumeCode;

    // Getters and Setters
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

    public long getResumeCode() {
        return resumeCode;
    }

    public void setResumeCode(long resumeCode) {
        this.resumeCode = resumeCode;
    }
}
