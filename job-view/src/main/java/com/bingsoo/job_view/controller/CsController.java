package com.bingsoo.job_view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cs")
public class CsController {
    
    @RequestMapping("/list")
    public String cslist(){
        return "cs/cs_list";
    }

    @RequestMapping("/detail")
    public String csdetail(){
        return "cs/cs_detail";
    }

    @RequestMapping("/regForm")
    public String csregForm(){
        return "cs/cs_regist_form";
    }
}
