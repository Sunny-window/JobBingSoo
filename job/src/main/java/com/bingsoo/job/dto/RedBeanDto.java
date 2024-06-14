package com.bingsoo.job.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RedBeanDto {
    private String name;
    private String address;
    private Date birth;
    private String gender;

}
