package com.bingsoo.job.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bingsoo.job.entity.Company;
import com.bingsoo.job.repository.CompanyRepository;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }
    
    public Company getCompanyByCno(String cno) {
        return companyRepository.findByCno(cno).orElse(null);
    }
    
    public Optional<Company> getCompanyByCno2(String cno) {
        return companyRepository.findById(cno);
    }
    
}
