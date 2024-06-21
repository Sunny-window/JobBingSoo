package com.bingsoo.job.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscribeForNameDto {
	private String rid;
	private String cid;
	private String company_name;
	private String cno;
}
