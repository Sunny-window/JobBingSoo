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
public class StarPoint {
	@Id
	private long star_code;
	@ManyToOne
	@JoinColumn(name = "cid")
	private Member cid;
	
	@ManyToOne
	@JoinColumn(name = "rid")
	private Member rid;
	
	private Integer point;
}
