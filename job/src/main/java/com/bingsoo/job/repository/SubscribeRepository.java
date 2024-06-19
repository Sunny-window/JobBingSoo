package com.bingsoo.job.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bingsoo.job.entity.Member;
import com.bingsoo.job.entity.Posting;
import com.bingsoo.job.entity.Subscribe;

public interface SubscribeRepository extends JpaRepository<Subscribe, Long>{
		

//	 boolean existsByPostCodeAndRid(Posting postCode, Member rid);


//	boolean existsByRidAndPostCode(Member rid, Posting post);
	

    List<Subscribe> findByCid(Member cid);
}
