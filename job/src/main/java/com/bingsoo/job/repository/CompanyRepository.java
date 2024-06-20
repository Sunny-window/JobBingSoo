package com.bingsoo.job.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bingsoo.job.entity.Company;
import com.bingsoo.job.entity.Member;

public interface CompanyRepository extends JpaRepository<Company, String> {

	Optional<Company> findByCno(String cno);

	Optional<Company> findByCid(Member member);

	@Query(value = "SELECT * FROM company WHERE company_name LIKE %:keyword% ", nativeQuery = true)
	List<Company> searchList(@Param("keyword") String keyword);
}
