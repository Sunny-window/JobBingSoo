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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Favorite {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long favorCode;
	
	@ManyToOne
	@JoinColumn(name="post_code")
	private Posting postCode;
	@ManyToOne
	@JoinColumn(name="username")
	private Member username ;
	
	
	
}
