package com.bingsoo.job.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bingsoo.job.entity.Cs;
import com.bingsoo.job.entity.Cs_reply;

public interface Cs_replyRepository extends JpaRepository<Cs_reply, Long> {
    List<Cs_reply> findByCsCode(Cs csCode);

    @Query(value="DELETE FROM cs_reply WHERE cs_code = :code",nativeQuery=true)
    void deleteByCsCode(@Param("code") long code);
}