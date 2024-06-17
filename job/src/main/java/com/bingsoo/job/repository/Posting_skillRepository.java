package com.bingsoo.job.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bingsoo.job.entity.Posting_skill;

public interface Posting_skillRepository extends JpaRepository<Posting_skill, Long>{
	@Query("SELECT ps FROM Posting_skill ps WHERE ps.post_code.post_code = :postCode")
    List<Posting_skill> findByPostCode(@Param("postCode") Long postCode);
}
