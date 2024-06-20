package com.bingsoo.job.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bingsoo.job.dto.PostingDto;
import com.bingsoo.job.dto.RedBeanDto;
import com.bingsoo.job.entity.MainCategory;
import com.bingsoo.job.entity.Member;
import com.bingsoo.job.entity.Notice;
import com.bingsoo.job.entity.Posting;
import com.bingsoo.job.entity.RedBean;
import com.bingsoo.job.entity.Application;
import com.bingsoo.job.entity.Company;
import com.bingsoo.job.entity.SubCategory;
import com.bingsoo.job.entity.Subscribe;
import com.bingsoo.job.jwtToken.JWTUtil;
import com.bingsoo.job.repository.ApplicationRepository;
import com.bingsoo.job.repository.CompanyRepository;
import com.bingsoo.job.repository.MainCategoryRepository;
import com.bingsoo.job.repository.NoticeRepository;
import com.bingsoo.job.repository.PostingRepository;
import com.bingsoo.job.repository.RedBeanRepository;
import com.bingsoo.job.repository.SubCategoryRepository;
import com.bingsoo.job.repository.SubscribeRepository;

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

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private NoticeRepository noticeRepository;

    @Autowired
    private SubscribeRepository subscribeRepository;

    // @GetMapping("/redbean-per-mypost/{postCode}")
    // public List<Application> redBeanApplication(@PathVariable("postCode") Long
    // postCode ) {
    // Posting posting = new Posting();
    // posting.setPost_code(postCode);
    // return applicationRepository.findByPostCode(posting);
    // }

    @GetMapping("/redbean-per-mypost")
    public List<RedBeanDto> RedBeanList(@RequestParam("postcode") Long postCode) {

        List<RedBeanDto> reds = applicationRepository.findRedBeanByRid(postCode);

        return reds;

    }

    @GetMapping("/my-postings")
    public List<PostingDto> postingList(@RequestHeader("Authorization") String token) {
        String actualToken = token.substring(7);
        String tokenname = JWTUtil.getUsername(actualToken);
        System.out.println(tokenname);
        List<PostingDto> dtos = postingRepository.findPostingListDtosByCid(tokenname);

        return dtos;
    }

    @DeleteMapping("/posting/{post_code}")
    public void deletePostingById(@PathVariable("post_code") Long postCode) {

        postingRepository.deleteById(postCode);
    }

    @PostMapping("/posting")
    public Posting posting(@RequestBody Posting posting, @RequestHeader("Authorization") String token) {
        String actualToken = token.substring(7);
        String tokenname = JWTUtil.getUsername(actualToken);
        // 로그인 전 임시 member
        Member member = new Member();
        member.setUsername(tokenname);
        // 공고를 저장하고 반환
        posting.setCid(member);
        postingRepository.save(posting);
        // 해당 기업을 관심기업으로 설정한 회원들에게 알림 생성 및 저장
        Company company = companyRepository.findByCid(posting.getCid()).get();
        List<Subscribe> subscribeList = subscribeRepository.findByCid(posting.getCid());

        for (Subscribe subscribe : subscribeList) {
            Notice notice = new Notice();
            notice.setReciever(subscribe.getRid());
            notice.setSender(posting.getCid());
            notice.setMessage(company.getCompany_name() + "에 새로운 공고가 등록되었습니다.");
            notice.setType("기업알림");
            noticeRepository.save(notice);
        }

        return postingRepository.save(posting);
    }

    @GetMapping("/infomation")
    public Company infomation(@RequestHeader("Authorization") String token) {
        String actualToken = token.substring(7);
        String tokenname = JWTUtil.getUsername(actualToken);
        Member member = new Member();
        member.setUsername(tokenname);
        return companyRepository.findByCid(member).get();
    }

    @GetMapping("/posting/{post_code}")
    public Posting posting(@PathVariable("post_code") Long postCode) {
        return postingRepository.findById(postCode).orElse(null);
    }

    @PutMapping("/posting/{post_code}")
    public Posting updatePosting(@PathVariable("post_code") Long postCode, @RequestBody Posting posting) {
        Posting posting2 = postingRepository.findById(postCode).get();

        posting2.setTitle(posting.getTitle());
        posting2.setHead_count(posting.getHead_count());
        posting2.setEdu_type(posting.getEdu_type());
        posting2.setEmployment_type(posting.getEmployment_type());
        posting2.setCareer(posting.getCareer());
        posting2.setPay(posting.getPay());
        posting2.setArea(posting.getArea());
        posting2.setDeadline(posting.getDeadline());
        posting2.setManager_tel(posting.getManager_tel());
        posting2.setMain_content(posting.getMain_content());

        return postingRepository.save(posting2);
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

    @PostMapping("/reject")
    public Application reject(@RequestParam("app_code") Long appCode) {
        Application application = applicationRepository.findById(appCode).get();

        application.setResult("불합격");

        return applicationRepository.save(application);
    }

    @PostMapping("/approve")
    public Application approve(@RequestParam("app_code") Long appCode) {
        Application application = applicationRepository.findById(appCode).get();

        application.setResult("합격");

        return applicationRepository.save(application);
    }

}
