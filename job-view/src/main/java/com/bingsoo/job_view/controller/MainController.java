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
}
