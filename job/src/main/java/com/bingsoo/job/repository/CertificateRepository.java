package com.bingsoo.job.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bingsoo.job.entity.Certificate;
import com.bingsoo.job.entity.Member;

public interface CertificateRepository extends JpaRepository<Certificate, Long>{
	List<Certificate> findByRid(Member rid);
}
