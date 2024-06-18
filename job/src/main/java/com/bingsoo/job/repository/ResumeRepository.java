package com.bingsoo.job.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bingsoo.job.entity.Member;
import com.bingsoo.job.entity.Resume;

public interface ResumeRepository extends JpaRepository<Resume, Long>{
	@Query(value="SELECT * FROM resume WHERE resume_code = :resume_code", nativeQuery=true)
	Resume findRdCode(@Param("resume_code") long resume_code);

	List<Resume> findByRid(Member member);
	
}
