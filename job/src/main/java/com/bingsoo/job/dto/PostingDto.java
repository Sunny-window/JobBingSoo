package com.bingsoo.job.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostingDto {
    private Long post_code;
    private String title;
    private Date deadline;
    private String area;
    private String company_name;
}
