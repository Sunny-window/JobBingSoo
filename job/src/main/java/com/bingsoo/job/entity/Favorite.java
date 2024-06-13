package com.bingsoo.job.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Favorite {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long favor_code;
	
	@ManyToOne
	@JoinColumn(name="post_code")
	private Posting post_code;
	@ManyToOne
	@JoinColumn(name="username")
	private Member username ;
	
	
	
}
