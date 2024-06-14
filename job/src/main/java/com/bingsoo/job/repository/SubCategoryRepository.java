package com.bingsoo.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bingsoo.job.entity.SubCategory;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory,Long> {
    
}
