package com.bingsoo.job.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class MainCategory {
    @Id
    Long mccode;
    String main;
}
