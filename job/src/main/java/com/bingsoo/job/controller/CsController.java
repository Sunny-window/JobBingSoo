package com.bingsoo.job.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bingsoo.job.entity.Cs;
import com.bingsoo.job.entity.FAQ;
import com.bingsoo.job.jwtToken.JWTUtil;
import com.bingsoo.job.repository.CsRepository;
import com.bingsoo.job.repository.Cs_replyRepository;
import com.bingsoo.job.repository.FAQRepository;

@RestController
@RequestMapping("/cs")
@CrossOrigin(origins = "http://localhost:8080")
public class CsController {
    @Autowired
    FAQRepository fr;

    @Autowired
    CsRepository cr;

    @Autowired
    Cs_replyRepository crrepo;

    @GetMapping("/faqlist")
    public List<FAQ> getFAQList(){
        
        return fr.findAll();
    }

    @GetMapping("/cslist")
    public List<Cs> getCsList(){
        return cr.findPublicAll();
    }

    @DeleteMapping("/cs")
    public void deleteCs(@RequestParam("csCode")String code, @RequestHeader("Authorization") String token){
        // 'Bearer ' 접두사를 제거하고 실제 토큰을 추출
        String actualToken = token.substring(7);
        String tokenname =JWTUtil.getUsername(actualToken);
        String tokenrole = JWTUtil.getRole(actualToken);
        System.out.println(tokenname);
        System.out.println(tokenrole);
        System.out.println(tokenname);
        System.out.println(tokenrole);

        crrepo.deleteByCsCode(Long.parseLong(code));
        cr.deleteById(Long.parseLong(code));
    }
}