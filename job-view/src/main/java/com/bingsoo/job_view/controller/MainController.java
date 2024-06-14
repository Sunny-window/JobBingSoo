package com.bingsoo.job_view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {
    
	@RequestMapping("/regForm")
	public String regForm() {
		
		return "main/join_form";
	}
	
	@RequestMapping("/index")
	public String index() {
		
		return "main/main";
	}
	
	@RequestMapping("/comDetail")
	public String comDetail() {
		
		return "main/company_detail";
	}	
	
	@RequestMapping("/comList")
	public String comList() {
		
		return "main/company_list";
	}
	
	@RequestMapping("/loginForm")
	public String loginForm() {
		
		return "main/login_form";
	}
	
	@RequestMapping("/postDetail")
	public String postDetail() {
		
		return "main/post_detail";
	}
	
}
