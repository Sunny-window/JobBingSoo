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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class Resume {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long resume_code;
	
	@ManyToOne
	@JoinColumn(name = "rid")
	private Member rid;
	private String title;
	private String edu_name;
	private String edu_type;
	private String edu_major;
	private LocalDate edu_state;
	private String graduate_date;
	private String employmemt_type;
	private String photoUrl;
	private Integer desired_pay;
	private Character public_type;
	
	
}
