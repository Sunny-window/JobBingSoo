package com.bingsoo.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bingsoo.job.entity.Resume;

public interface ResumeRepository extends JpaRepository<Resume, Long>{

}
