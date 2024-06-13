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
public class Subscribe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long subs_code;
	
	@ManyToOne
	@JoinColumn(name="cid")
	@ToString.Exclude
	private Member cid;
	
	@ManyToOne
	@JoinColumn(name="rid")
	@ToString.Exclude
	private Member rid;
	
	
	
}
