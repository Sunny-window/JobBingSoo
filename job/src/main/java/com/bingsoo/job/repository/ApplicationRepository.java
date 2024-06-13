package com.bingsoo.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bingsoo.job.entity.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

}
