package com.bingsoo.job.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

  

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class Career {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long car_code;
	
	@ManyToOne
	@JoinColumn(name = "resume_code")
	private Resume resume_code;
	
	@ManyToOne
	@JoinColumn(name = "rid")
	private Member rid;
	
	private String companyName;
	private Date carDate;
	private Date endDate;
	private String industry;
	private String position;
	private String job;
	private String work;
	 
	
}
