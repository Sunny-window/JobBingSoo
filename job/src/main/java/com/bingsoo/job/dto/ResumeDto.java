package com.bingsoo.job.dto;

import java.time.LocalDate;
import java.util.List;

import com.bingsoo.job.entity.Certificate;

import lombok.Data;
@Data
public class ResumeDto {
	private String title;
	private String name;
	private String address;
	private String tel;
	private String email;
	private String edu_name;
	private String edu_type;
	private String edu_major;
	private LocalDate edu_state;
	private String area_main;
	private String area_sub;
	private String industry;
	private String job;
	private String companyname;
	private LocalDate cardate;
	private LocalDate enddate;
	private String position;
	private List<Certificate> cer_stack;
	private List<Certificate> skill_stack;
	private LocalDate optain_date;
	private String issuer;
	
}
