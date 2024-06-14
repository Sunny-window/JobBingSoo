package com.bingsoo.job.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bingsoo.job.entity.Career;
import com.bingsoo.job.entity.Certificate;
import com.bingsoo.job.entity.Cover_letter;
import com.bingsoo.job.entity.Desired_area;
import com.bingsoo.job.entity.Desired_industry;
import com.bingsoo.job.entity.Favorite;
import com.bingsoo.job.entity.RedBean;
import com.bingsoo.job.entity.Resume;
import com.bingsoo.job.entity.Subscribe;
import com.bingsoo.job.repository.CareerRepository;
import com.bingsoo.job.repository.CertificateRepository;
import com.bingsoo.job.repository.Cover_letterRepository;
import com.bingsoo.job.repository.Desired_areaRepository;
import com.bingsoo.job.repository.Desired_industryRepository;
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
	
	@Autowired
	Cover_letterRepository cover_letterRepository;
	
	@Autowired
	Desired_areaRepository desired_areaRepository;
	
	
	@Autowired
	Desired_industryRepository desired_industryRepository;
	@Autowired
	CareerRepository careerRepository;
	@Autowired
	CertificateRepository certificateRepository;
	
	
	@GetMapping("/showInfoForm")
	public String showInfoForm() {
		
		return "등록성공";
	}
	
	@PutMapping("/updateInfo")
	public String updateInfo(@RequestBody RedBean redBean) {
		System.out.println("==============================redBean : "+redBean);
		redBeanRepository.save(redBean);
		return "등록성공";
	}

	@PutMapping("/resumeUpdate")
	public String resumeUpdate(@RequestBody Resume resume
			,@RequestBody Cover_letter cover_letter
			,@RequestBody Desired_area desired_area
			,@RequestBody Desired_industry desired_industry
			,@RequestBody Career career
			,@RequestBody Certificate certificate
			) {
		System.out.println("==============================resume : "+resume);
		resumeRepository.save(resume);
		cover_letterRepository.save(cover_letter);
		desired_areaRepository.save(desired_area);
		desired_industryRepository.save(desired_industry);
		careerRepository.save(career);
		certificateRepository.save(certificate);
		return "등록성공";
	}
	
	
	@GetMapping("/showResumeList")
	public List<Resume> showResumeList() {
		List<Resume> list =resumeRepository.findAll();
		System.out.println("==============================showResumeList : "+list);
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
