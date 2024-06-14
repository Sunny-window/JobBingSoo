package com.bingsoo.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bingsoo.job.entity.RedBean;
import com.bingsoo.job.entity.Resume;

public interface RedBeanRepository extends JpaRepository<RedBean, Long>{
	

}
