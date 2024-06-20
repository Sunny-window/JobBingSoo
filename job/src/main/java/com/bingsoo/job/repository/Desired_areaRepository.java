package com.bingsoo.job.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bingsoo.job.entity.Desired_area;
import com.bingsoo.job.entity.Member;

public interface Desired_areaRepository extends JpaRepository<Desired_area, Long>{

	Optional<Desired_area> findByRid(Member rid);
	 @Query("SELECT da FROM Desired_area da WHERE da.rid = :member")
	    List<Desired_area> findAllByRid(@Param("member") Member member);
	
}