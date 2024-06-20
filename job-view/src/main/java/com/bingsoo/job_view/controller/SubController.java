package com.bingsoo.job_view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/sub")
@Controller
public class SubController {
    @RequestMapping("/search")
    public String sub(){
        return "sub/search_result";
    }
}
