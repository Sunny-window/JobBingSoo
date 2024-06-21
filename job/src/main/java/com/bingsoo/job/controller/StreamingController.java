package com.bingsoo.job.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StreamingController {

    @Autowired
    private StreamingStatus streamingStatus;

    @PostMapping("/start-streaming")
    public String startStreaming() {
        streamingStatus.startStreaming();
        return "Streaming started";
    }

    @GetMapping("/is-streaming")
    public boolean isStreaming() {
        return streamingStatus.isStreaming();
    }
}
