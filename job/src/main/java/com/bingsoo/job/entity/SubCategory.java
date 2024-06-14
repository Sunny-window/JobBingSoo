package com.bingsoo.job.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class SubCategory {
    @Id
    Long sccode;
    String sub;
    
    @ManyToOne
    @JoinColumn(name= "mccode")
    MainCategory mccode;
}
