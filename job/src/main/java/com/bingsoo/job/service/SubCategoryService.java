package com.bingsoo.job.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bingsoo.job.entity.SubCategory;
import com.bingsoo.job.repository.SubCategoryRepository;

@Service
public class SubCategoryService {

	@Autowired
    private SubCategoryRepository subCategoryRepository;

    public SubCategory getSubCategory(Long sccode) {
        return subCategoryRepository.findById(sccode).orElse(null);
    }
}
