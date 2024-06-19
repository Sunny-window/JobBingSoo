package com.bingsoo.job_view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


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
    public String red_bean_list(@RequestParam("postCode") Long postCode, Model model){

        model.addAttribute("postCode", postCode);
        return "ice/red_bean_list";
    }

    @RequestMapping("employ_notice_form")
    public String employ_notice_form(){

        return "ice/employ_notice_form";
    }

    @RequestMapping("employ_notice_updateForm")
    public String employ_notice_updateForm(){

        return "ice/employ_notice_updateForm";
    }

    @RequestMapping("infomation")
    public String infomation(){

        return "ice/infomation";
    }

    @RequestMapping("postDetail")
    public String postDetail(@RequestParam("postCode") Long postCode){

        return "main/post_detail" ;
    }



}
