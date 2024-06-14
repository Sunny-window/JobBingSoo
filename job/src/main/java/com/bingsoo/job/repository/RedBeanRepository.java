package com.bingsoo.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.bingsoo.job.entity.Application;
import com.bingsoo.job.entity.Member;
import com.bingsoo.job.entity.Posting;
import com.bingsoo.job.entity.RedBean;

public interface RedBeanRepository extends JpaRepository<RedBean, Long>{

    List<RedBean> findByRid(Member rid);
}
