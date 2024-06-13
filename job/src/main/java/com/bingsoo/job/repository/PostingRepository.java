package com.bingsoo.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bingsoo.job.entity.Posting;

public interface PostingRepository extends JpaRepository<Posting, Long>{

}
