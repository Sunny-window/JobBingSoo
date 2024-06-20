package com.bingsoo.job.controller;


import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bingsoo.job.dto.ApplyRequest;
import com.bingsoo.job.entity.Application;
import com.bingsoo.job.entity.Desired_area;
import com.bingsoo.job.entity.Desired_industry;
import com.bingsoo.job.entity.Favorite;
import com.bingsoo.job.entity.Member;
import com.bingsoo.job.entity.Posting;
import com.bingsoo.job.entity.Resume;
import com.bingsoo.job.jwtToken.JWTUtil;
import com.bingsoo.job.repository.ApplicationRepository;
import com.bingsoo.job.repository.CompanyRepository;
import com.bingsoo.job.repository.CsRepository;
import com.bingsoo.job.repository.Cs_replyRepository;
import com.bingsoo.job.repository.Desired_areaRepository;
import com.bingsoo.job.repository.Desired_industryRepository;
import com.bingsoo.job.repository.FavoriteRepository;
import com.bingsoo.job.repository.MemberRepository;
import com.bingsoo.job.repository.NoticeRepository;
import com.bingsoo.job.repository.PostingRepository;
import com.bingsoo.job.repository.ResumeRepository;

import io.jsonwebtoken.Claims;

@RestController
@RequestMapping("/content")
@CrossOrigin(origins = "http://localhost:8080")
public class ContentController {

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	CompanyRepository companyRepository;

	@Autowired
	NoticeRepository noticeRepository;

	@Autowired
	CsRepository csRepository;

	@Autowired
	Cs_replyRepository cs_replyRepository;

	@Autowired
	PostingRepository postingRepository;

	@Autowired
	Desired_areaRepository desiredAreaRepository;

	@Autowired
	Desired_industryRepository desiredIndustryRepository;

	@Autowired
	FavoriteRepository favoriteRepository;

	@Autowired
	ApplicationRepository applicationRepository;

	@Autowired
	ResumeRepository resumeRepository;
	
	@GetMapping("/find-postings")
	public List<Posting> findPostingsForUser(@RequestHeader("Authorization") String token) {
	    // JWT에서 "Bearer " 접두사 제거
	    if (token.startsWith("Bearer ")) {
	        token = token.substring(7);
	    }

	    // JWT 검증 및 사용자 이름 추출
	    if (!JWTUtil.validateToken(token)) {
	        return null;
	    }
	    Claims claims = JWTUtil.parseToken(token);
	    String username = claims.getSubject();

	    Optional<Member> memberOptional = memberRepository.findById(username);
	    if (memberOptional.isPresent()) {
	        Member member = memberOptional.get();
	        List<Desired_area> desiredAreas = desiredAreaRepository.findAllByRid(member);
	        List<Desired_industry> desiredIndustries = desiredIndustryRepository.findAllByRid(member);

	        if (!desiredAreas.isEmpty() && !desiredIndustries.isEmpty()) {
	            // 여러 지역 및 산업을 고려한 공고 검색
	            List<Posting> postings = postingRepository.findByAreaInAndIndustryIn(
	                    desiredAreas.stream().map(Desired_area::getArea_main).collect(Collectors.toList()),
	                    desiredIndustries.stream().map(Desired_industry::getIndustry).collect(Collectors.toList())
	            );
	            return postings;
	        }
	    }
	    return null;
	}
	
	 @GetMapping("/resumes")
	    public List<Resume> getResumes(@RequestHeader("Authorization") String token) {
	        // JWT에서 "Bearer " 접두사 제거
	        if (token.startsWith("Bearer ")) {
	            token = token.substring(7);
	        }

	        // JWT 검증 및 사용자 이름 추출
	        if (!JWTUtil.validateToken(token)) {
	            return null;
	        }
	        Claims claims = JWTUtil.parseToken(token);
	        String username = claims.getSubject();

	        Member member = memberRepository.findById(username).orElse(null);
	        if (member != null) {
	            return resumeRepository.findByRid(member);
	        }
	        return null;
	    }

	 @PostMapping("/apply")
	 public String apply(@RequestBody ApplyRequest request, @RequestHeader("Authorization") String token) {
	     // JWT에서 "Bearer " 접두사 제거
	     if (token.startsWith("Bearer ")) {
	         token = token.substring(7);
	     }

	     // JWT 검증 및 사용자 이름 추출
	     if (!JWTUtil.validateToken(token)) {
	         return "invalid token";
	     }
	     Claims claims = JWTUtil.parseToken(token);
	     String username = claims.getSubject();

	     Posting post = postingRepository.findById(request.getPostCode()).orElse(null);
	     Member member = memberRepository.findById(username).orElse(null);
	     Resume resume = resumeRepository.findById(request.getResumeCode()).orElse(null);

	     if (post == null || member == null || resume == null) {
	         return "fail";
	     }

	     // 이미 지원한 공고인지 확인
	     Optional<Application> existingApplication = applicationRepository.findByPostCodeAndRid(post, member);
	     if (existingApplication.isPresent()) {
	         return "already applied";
	     }

	     Application application = new Application();
	     application.setPostCode(post);
	     application.setRid(member);
	     application.setResult("지원 완료");

	     applicationRepository.save(application);
	     return "success";
	 }
	

 @PostMapping("/favorite")
 public String addFavorite(@RequestBody Map<String, String> request, @RequestHeader("Authorization") String token) {
     String postCode = request.get("postCode");

     // JWT에서 "Bearer " 접두사 제거
     if (token.startsWith("Bearer ")) {
         token = token.substring(7);
     }

     // JWT 검증 및 사용자 이름 추출
     if (!JWTUtil.validateToken(token)) {
         return "invalid token";
     }
     Claims claims = JWTUtil.parseToken(token);
     String username = claims.getSubject();

     Posting post = postingRepository.findById(Long.parseLong(postCode)).orElse(null);
     Member user = memberRepository.findById(username).orElse(null);

     if (post == null || user == null) {
         return "fail";
     }

     if (favoriteRepository.existsByPostCodeAndUsername(post, user)) { // 수정된 메서드명 사용
         return "already favorite";
     }

     Favorite favorite = new Favorite();
     favorite.setPostCode(post); // 필드명을 정확히 사용
     favorite.setUsername(user);

     favoriteRepository.save(favorite);
     return "success";
 }
 
 @GetMapping("/recommendations")
 public ResponseEntity<Map<String, Object>> getRecommendations(@RequestHeader("Authorization") String token) {
     Map<String, Object> recommendations = new HashMap<>();

     // JWT에서 "Bearer " 접두사 제거
     if (token.startsWith("Bearer ")) {
         token = token.substring(7);
     }

     // JWT 검증 및 사용자 이름 추출
     if (!JWTUtil.validateToken(token)) {
         recommendations.put("error", "Invalid token");
         return ResponseEntity.status(401).body(recommendations);
     }
     Claims claims = JWTUtil.parseToken(token);
     String username = claims.getSubject();

     Optional<Member> memberOptional = memberRepository.findById(username);
     if (memberOptional.isPresent()) {
         Member member = memberOptional.get();

         // 사용자의 이력서 목록 가져오기
         List<Resume> resumes = resumeRepository.findByRid(member);
         recommendations.put("resumes", resumes);

         // 사용자 희망 지역 및 산업 가져오기
         Optional<Desired_area> desiredAreaOptional = desiredAreaRepository.findByRid(member);
         Optional<Desired_industry> desiredIndustryOptional = desiredIndustryRepository.findByRid(member);

         // 추천 공고 목록 가져오기
         if (desiredAreaOptional.isPresent() && desiredIndustryOptional.isPresent()) {
             Desired_area desiredArea = desiredAreaOptional.get();
             Desired_industry desiredIndustry = desiredIndustryOptional.get();

             List<Posting> recommendedPostings = postingRepository.findByAreaAndIndustry(desiredArea.getArea_main(), desiredIndustry.getIndustry());
             recommendations.put("recommendedPostings", recommendedPostings);
         }
     }

     return ResponseEntity.ok(recommendations);
 }

}
