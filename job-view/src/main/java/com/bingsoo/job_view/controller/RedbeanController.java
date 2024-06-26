package com.bingsoo.job_view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.reflect.MethodDelegate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/redbean")
public class RedbeanController {


	@RequestMapping("/mypage")
	public String mypage() {
		
		return "red_bean/mypage";
	}

	@RequestMapping("/resume_detail")
	public String detail(@RequestParam("rid") String rid, Model model){

		model.addAttribute("rid", rid);
		
		return "red_bean/resume_detail";
	}
	
	
}
