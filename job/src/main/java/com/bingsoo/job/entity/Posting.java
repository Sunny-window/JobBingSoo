package com.bingsoo.job.entity;

import java.time.LocalDate;

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
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class Posting {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long post_code;
	
	@ManyToOne
	@JoinColumn(name="cid")
	@ToString.Exclude
	private Member cid;
	private String title;
	
	private Integer head_count;
	private String edu_type;
	private String career;
	private String employment_type;
	private Integer pay;
	private String area;
	private String industry;
	private String job;
	private LocalDate postedDate;
	private LocalDate deadline;
	private String manager_tel;
	private String main_content;
	
	
}
