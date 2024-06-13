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

}
