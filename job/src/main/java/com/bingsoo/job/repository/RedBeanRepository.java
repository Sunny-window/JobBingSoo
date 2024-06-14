package com.bingsoo.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import com.bingsoo.job.entity.Application;
import com.bingsoo.job.entity.Member;
import com.bingsoo.job.entity.Posting;
import com.bingsoo.job.entity.RedBean;
import com.bingsoo.job.entity.Resume;

public interface RedBeanRepository extends JpaRepository<RedBean, Long>{
	

    List<RedBean> findByRid(Member rid);
}
