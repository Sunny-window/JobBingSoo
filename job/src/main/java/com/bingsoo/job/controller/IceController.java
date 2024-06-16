package com.bingsoo.job.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bingsoo.job.dto.PostingDto;
import com.bingsoo.job.dto.RedBeanDto;
import com.bingsoo.job.entity.MainCategory;
import com.bingsoo.job.entity.Posting;
import com.bingsoo.job.entity.SubCategory;
import com.bingsoo.job.repository.ApplicationRepository;
import com.bingsoo.job.repository.MainCategoryRepository;
import com.bingsoo.job.repository.PostingRepository;
import com.bingsoo.job.repository.RedBeanRepository;
import com.bingsoo.job.repository.SubCategoryRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/ice")
public class IceController {
    
    @Autowired
    private PostingRepository postingRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private MainCategoryRepository mainCategoryRepository;

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    // @GetMapping("/redbean-per-mypost/{postCode}")
    // public List<Application> redBeanApplication(@PathVariable("postCode") Long postCode) {
    //     Posting posting = new Posting();
    //     posting.setPost_code(postCode);
    //     return applicationRepository.findByPostCode(posting);
    // }

    @GetMapping("/redbean-per-mypost")
    public List<RedBeanDto> RedBeanList(@RequestParam("postcode") Long postCode) {
        
        List<RedBeanDto> reds = applicationRepository.findRedBeanByRid(postCode);

        return reds;

    }

    @GetMapping("/my-postings")
    public List<PostingDto> postingList(@RequestParam("cid") String cid) {
        
        List<PostingDto> dtos = postingRepository.findPostingListDtosByCid(cid);
        
        return dtos;
    }

    @DeleteMapping("/posting/{post_code}")
    public void deletePostingById(@PathVariable("post_code") Long postCode) {
        
        System.out.println(postCode);
        System.out.println(postCode);
        System.out.println(postCode);
        System.out.println(postCode);
        System.out.println(postCode);
        System.out.println(postCode);
        System.out.println(postCode);

        postingRepository.deleteById(postCode);
    }

    @PostMapping("/posting")
    public Posting posting(@RequestBody Posting posting) {

        return postingRepository.save(posting);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<MainCategory>> getAllMainCategories() {
        List<MainCategory> mainCategories = mainCategoryRepository.findAll();
        return ResponseEntity.ok(mainCategories);
    }

    @GetMapping("/categories/{mccode}/subcategories")
    public ResponseEntity<List<SubCategory>> getSubCategoriesByMainCategory(@PathVariable Long mccode) {
        MainCategory mainCategory = mainCategoryRepository.findByMccode(mccode);
        List<SubCategory> subCategories = subCategoryRepository.findByMccode(mainCategory);
        return ResponseEntity.ok(subCategories);
    }

}
