package com.bingsoo.job.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bingsoo.job.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String>{

	List<Member> findByRole(String string);

	Member findByUsername(String username);
	
	List<Member> findByJoinDateBetween(LocalDate startDate, LocalDate endDate);

	Optional<Member> findById(String username);

}
