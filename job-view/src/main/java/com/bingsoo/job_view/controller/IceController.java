package com.bingsoo.job_view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ice")
public class IceController {
    
    @RequestMapping("/mypage")
    public String mypage(){

        return "ice/mypage";
    }

    @RequestMapping("/employ_notice_list")
    public String employ_notice_list(){

        return "ice/employ_notice_list";
    }

    @RequestMapping("/red_bean_list")
    public String red_bean_list(){

        return "ice/red_bean_list";
    }

    @RequestMapping("employ_notice_form")
    public String employ_notice_form(){

        return "ice/employ_notice_form";
    }

    @RequestMapping("infomation")
    public String infomation(){

        return "ice/infomation";
    }

}
