package com.bingsoo.job.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bingsoo.job.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String>{

	List<Member> findByRole(String string);

	Member findByUsername(String username);

}
