package com.bingsoo.job.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticeDto {
    private String receivers;
    private String title;
    private String content;
    private String senderUsername;

    
}
