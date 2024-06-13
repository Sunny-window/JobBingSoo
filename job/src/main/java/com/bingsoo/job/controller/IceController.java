package com.bingsoo.job.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bingsoo.job.dto.PostingDto;
import com.bingsoo.job.repository.PostingRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/ice")
public class IceController {
    
    @Autowired
    private PostingRepository postingRepository;

    // @GetMapping("/company-all")
    // public List<Company> companyAll(){

    // }

    // @GetMapping("/company/{cid}")
    // public Company 

    @GetMapping("/my-postings")
    public List<PostingDto> postingList(@RequestParam("cid") String cid) {
        
        List<PostingDto> dtos = postingRepository.findPostingListDtosByCid(cid);
        
        return dtos;
    }

    @DeleteMapping("/posting/{post_code}")
    public Long deletePostingById(@PathVariable Long postCode) {
            postingRepository.deleteById(postCode);
            return postCode;
    }
}
