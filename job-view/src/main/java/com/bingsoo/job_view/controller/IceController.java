package com.bingsoo.job_view.controller;

import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/ice")
public class IceController {
    
    @RequestMapping("/mypage")
    public String mypage(){

        return "ice/mypage";
    }

}
