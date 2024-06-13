package com.bingsoo.job.entity;

import jakarta.persistence.Entity;
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

public class Company {
	
	@Id
	private String cno;
	
	@ManyToOne
	@JoinColumn(name = "cid")
	private Member cid;
	
	private String company_name;
	private String size;
	private String ceo;
	private String tel;
	private String address;
	private Integer sales;
	private String manager_name;
	private String manager_tel;
	private String manager_email;
}
