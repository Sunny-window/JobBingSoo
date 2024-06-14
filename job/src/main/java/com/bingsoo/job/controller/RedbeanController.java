package com.bingsoo.job.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bingsoo.job.entity.Favorite;
import com.bingsoo.job.entity.Member;
import com.bingsoo.job.entity.RedBean;
import com.bingsoo.job.entity.Resume;
import com.bingsoo.job.entity.Subscribe;
import com.bingsoo.job.repository.FavoriteRepository;
import com.bingsoo.job.repository.RedBeanRepository;
import com.bingsoo.job.repository.ResumeRepository;
import com.bingsoo.job.repository.SubscribeRepository;

@RestController
@CrossOrigin("*")
public class RedbeanController {
	@Autowired
	RedBeanRepository redBeanRepository;
	
	@Autowired
	ResumeRepository resumeRepository ;
	@Autowired
	SubscribeRepository subscribeRepository;
	
	@Autowired
	FavoriteRepository favoriteRepository;
	
	
	@PutMapping("/updateInfo")
	public String updateInfo(@RequestBody RedBean redBean) {
		System.out.println("==============================redBean : "+redBean);
		redBeanRepository.save(redBean);
		return "등록성공";
	}
	
	
	@GetMapping("/showResumeList")
	public List<Resume> showResumeList() {
		System.out.println("==============================redBean : ");
		List<Resume> list =resumeRepository.findAll();
		return list;
	}
	
	@GetMapping("/resumeDetail")
	public Resume resumeDetail(@RequestParam("resume_code") long resume_code) {
		Resume resume =resumeRepository.findRdCode(resume_code);
		return resume;
	}
	
	@GetMapping("/showResumeDetail")
	public Resume showResumeDetail(@RequestParam("resume_code") long resume_code) {
		Resume resume =resumeRepository.findRdCode(resume_code);
		return resume;
	}
	@GetMapping("/showSubscribeList")
	public List<Subscribe> showSubscribeList() {
		System.out.println("==============================redBean : ");
		List<Subscribe> list =subscribeRepository.findAll();
		return list;
	}
	@GetMapping("/showFavoriteList")
	public List<Favorite> showFavoriteList() {
		System.out.println("==============================redBean : ");
		List<Favorite> list =favoriteRepository.findAll();
		return list;
	}
	
	
	
	
}
