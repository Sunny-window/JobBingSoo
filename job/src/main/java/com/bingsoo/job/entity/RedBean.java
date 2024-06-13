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

public class RedBean {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long rb_code;
	
	@ManyToOne
	@JoinColumn(name = "rid")
	private Member rid;
	
	private String name;
	private Date birth;
	private String tel;
	private String address;
	private String email;
	private String gender;
	private String military;          
	
}
