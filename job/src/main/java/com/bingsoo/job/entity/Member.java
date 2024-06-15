package com.bingsoo.job.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class Member {
	
	@Id
	private String username;
	
	private String password;
	private String role;
	private LocalDate joinDate;
	private String kakaoId;
}
