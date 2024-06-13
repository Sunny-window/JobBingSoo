package com.bingsoo.job.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bingsoo.job.entity.Company;
import com.bingsoo.job.entity.Member;
import com.bingsoo.job.entity.Notice;
import com.bingsoo.job.repository.CompanyRepository;
import com.bingsoo.job.repository.MemberRepository;
import com.bingsoo.job.repository.NoticeRepository;

@RestController
@RequestMapping("/manager")
@CrossOrigin(origins = "http://localhost:8080")
public class ManagerController {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    CompanyRepository companyRepository;
    
    @Autowired
    private NoticeRepository noticeRepository;
    
    @GetMapping("/member-all")
    public Map<String, List<?>> getData() {
        List<Member> members = memberRepository.findAll();
        List<Company> companies = companyRepository.findAll();
        Map<String, List<?>> data = new HashMap<>();
        data.put("members", members);
        data.put("companies", companies);
        return data;
    }
    
    @PostMapping("/notice")
    public Notice sendNotice(@RequestBody Notice notice) {
        return noticeRepository.save(notice);
    }
}
