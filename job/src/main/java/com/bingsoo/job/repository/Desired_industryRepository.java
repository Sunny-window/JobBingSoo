package com.bingsoo.job.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bingsoo.job.entity.Desired_industry;
import com.bingsoo.job.entity.Member;

public interface Desired_industryRepository extends JpaRepository<Desired_industry, Long>{

	 Optional<Desired_industry> findByRid(Member rid);
	 @Query("SELECT di FROM Desired_industry di WHERE di.rid = :member")
	    List<Desired_industry> findAllByRid(@Param("member") Member member);
}