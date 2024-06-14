package com.bingsoo.job.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bingsoo.job.entity.Company;



public interface CompanyRepository extends JpaRepository<Company, String> {

	Optional<Company> findByCno(String cno);
}
