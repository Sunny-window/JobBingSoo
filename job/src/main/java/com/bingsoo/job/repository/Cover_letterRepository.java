package com.bingsoo.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bingsoo.job.entity.Cover_letter;

public interface Cover_letterRepository extends JpaRepository<Cover_letter, Long>{
	
    @Query(value = "SELECT * FROM cover_letter WHERE resume_code = :resume_code", nativeQuery = true)
	Cover_letter findByResume_code(@Param("resume_code") long resume_code);
}
