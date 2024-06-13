package com.bingsoo.job.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
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
public class Certificate {
	@Id
	long certi_code;
	
	@ManyToOne
	@JoinColumn(name="resume_code")
	@ToString.Exclude
	Resume resume_code;
	@ManyToOne
	@JoinColumn(name="rid")
	@ToString.Exclude
	Member rid;
	
	String stack;
	LocalDate optain_date;
	String issuer;
	
	
	
}
