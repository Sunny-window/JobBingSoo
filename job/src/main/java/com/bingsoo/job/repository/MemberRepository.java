package com.bingsoo.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bingsoo.job.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String>{

}
