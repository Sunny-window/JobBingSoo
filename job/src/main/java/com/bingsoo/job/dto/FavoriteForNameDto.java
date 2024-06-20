package com.bingsoo.job.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteForNameDto {
	private long favor_code;
	private long post_code;
	private String username;
	private String company_name;
	
}
