package com.bingsoo.job.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bingsoo.job.entity.Desired_area;
import com.bingsoo.job.entity.Member;

public interface Desired_areaRepository extends JpaRepository<Desired_area, Long>{

	Optional<Desired_area> findByRid(Member rid);
	
}