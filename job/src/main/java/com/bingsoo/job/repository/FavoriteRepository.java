package com.bingsoo.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bingsoo.job.entity.Favorite;

public interface FavoriteRepository extends JpaRepository<Favorite, Long>{

}
