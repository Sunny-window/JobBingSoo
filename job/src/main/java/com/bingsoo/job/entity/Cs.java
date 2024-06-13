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
public class Cs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long cs_code;
	
	@ManyToOne
	@JoinColumn(name="rid")
	@ToString.Exclude
	Member rid;
	
	String title;
	String content;
	String type;
	LocalDate Date;
	String result;
	String public_type;
	
	
}
