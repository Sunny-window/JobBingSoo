package com.bingsoo.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bingsoo.job.entity.Favorite;
import com.bingsoo.job.entity.Member;
import com.bingsoo.job.entity.Posting;

public interface FavoriteRepository extends JpaRepository<Favorite, Long>{
	
	 boolean existsByPostCodeAndUsername(Posting postCode, Member username);
}
