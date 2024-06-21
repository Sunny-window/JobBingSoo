package com.bingsoo.job.controller;

import org.springframework.stereotype.Component;

@Component
public class StreamingStatus {
    private boolean isStreaming = false;

    public boolean isStreaming() {
        return isStreaming;
    }

    public void startStreaming() {
        this.isStreaming = true;
    }

    public void stopStreaming() {
        this.isStreaming = false;
    }
}
