package com.bingsoo.job.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bingsoo.job.entity.Member;
import com.bingsoo.job.entity.Subscribe;

public interface SubscribeRepository extends JpaRepository<Subscribe, Long>{

    List<Subscribe> findByCid(Member cid);
}
