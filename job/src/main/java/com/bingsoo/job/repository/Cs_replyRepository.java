package com.bingsoo.job.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bingsoo.job.entity.Cs;
import com.bingsoo.job.entity.Cs_reply;

public interface Cs_replyRepository extends JpaRepository<Cs_reply, Long> {
    List<Cs_reply> findByCsCode(Cs csCode);
}