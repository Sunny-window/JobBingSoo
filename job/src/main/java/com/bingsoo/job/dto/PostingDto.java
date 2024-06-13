package com.bingsoo.job.dto;

import java.sql.Date;
import java.time.LocalDate;

import com.bingsoo.job.entity.Company;
import com.bingsoo.job.entity.Posting;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostingDto {
    private String title;
    private Date deadline;
    private String address;
    private String company_name;
    private String ceo;
}
