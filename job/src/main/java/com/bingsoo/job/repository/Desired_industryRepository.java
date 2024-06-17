package com.bingsoo.job.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bingsoo.job.entity.Desired_industry;
import com.bingsoo.job.entity.Member;

public interface Desired_industryRepository extends JpaRepository<Desired_industry, Long>{
	Optional<Desired_industry> findByRid(Member rid);

}
