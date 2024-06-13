package com.bingsoo.job.entity;

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
public class Cs_reply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long csr_code;
	
	@ManyToOne
	@JoinColumn(name="cs_code")
	@ToString.Exclude
	Cs cs_code;
	
	
	@ManyToOne
	@JoinColumn(name="mid")
	@ToString.Exclude
	Member mid;
	
	String comment;
	
}
