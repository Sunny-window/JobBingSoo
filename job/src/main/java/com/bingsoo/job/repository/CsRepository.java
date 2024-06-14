package com.bingsoo.job.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bingsoo.job.entity.Cs;

public interface CsRepository extends JpaRepository<Cs, Long> {
	@Query("SELECT c FROM Cs c WHERE c.type = :type ORDER BY CASE WHEN c.result = '미답변' THEN 0 ELSE 1 END, c.date ASC")
	List<Cs> findByTypeOrderByResultAscDateAsc(@Param("type") String type);
}