package com.bingsoo.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bingsoo.job.entity.MainCategory;

@Repository
public interface MainCategoryRepository extends JpaRepository<MainCategory,Long> {
    
	//@Query(value="SELECT main FROM main_category", nativeQuery=true )
	//public List<MainCategory> findMainCategory();
	
}
