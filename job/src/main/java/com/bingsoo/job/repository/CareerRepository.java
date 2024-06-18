package com.bingsoo.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bingsoo.job.entity.Career;

public interface CareerRepository extends JpaRepository<Career, Long>{
	Career findByRid(String rid);
}
