package com.bingsoo.job_view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/redbean")
public class RedbeanController {
    
	@RequestMapping("/mypage")
	public String mypage() {
		
		return "red_bean/mypage";
	}
	
	
	
}
