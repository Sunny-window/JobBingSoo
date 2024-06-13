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
	private long cs_code;
	
	@ManyToOne
	@JoinColumn(name="rid")
	@ToString.Exclude
	private Member rid;
	
	private String title;
	private String content;
	private String type;
	private LocalDate Date;
	private String result;
	private String public_type;
	
	
}
