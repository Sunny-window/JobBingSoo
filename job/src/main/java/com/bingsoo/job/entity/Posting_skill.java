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

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Posting_skill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ps_code;
	
	@ManyToOne
	@JoinColumn(name="post_code")
	private Posting post_code;
	
	private String stack;
	
	
}
