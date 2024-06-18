package com.bingsoo.job.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bingsoo.job.entity.Company;
import com.bingsoo.job.entity.Member;



public interface CompanyRepository extends JpaRepository<Company, String> {

	Optional<Company> findByCno(String cno);



	Optional<Company> findByCid(Member member);

}
