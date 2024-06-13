package com.bingsoo.job.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bingsoo.job.entity.Member;

@RestController
@CrossOrigin("*")
public class RedbeanController {
    
	public String updateInfo(@RequestBody Member member) {
		
		return "";
	}
	
}
