package com.bingsoo.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bingsoo.job.entity.Career;
import com.bingsoo.job.entity.Member;

public interface CareerRepository extends JpaRepository<Career, Long>{
	public Career findByRid(Member member);
	
	
	
}
