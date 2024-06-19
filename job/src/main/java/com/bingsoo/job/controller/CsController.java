package com.bingsoo.job.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bingsoo.job.entity.Cs;
import com.bingsoo.job.entity.FAQ;
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
    public void deleteCs(@RequestParam("csCode")String code){
        crrepo.deleteByCsCode(Long.parseLong(code));
        cr.deleteById(Long.parseLong(code));
    }
}