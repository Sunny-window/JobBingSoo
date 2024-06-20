package com.bingsoo.job.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bingsoo.job.entity.Certificate;
import com.bingsoo.job.entity.Member;

public interface CertificateRepository extends JpaRepository<Certificate, Long>{
	List<Certificate> findByRid(Member rid);
	
	@Query(value="SELECT * from Certificate where resume_code = :resume_code" , nativeQuery=true)	
	List<Certificate> findByResume_code(@Param("resume_code") long resume_code);
	
	@Query(value="DELETE FROM resume WHERE resume_code = :resume_code", nativeQuery=true)
	void deleteByRdCode(@Param("resume_code") long resume_code);
}
