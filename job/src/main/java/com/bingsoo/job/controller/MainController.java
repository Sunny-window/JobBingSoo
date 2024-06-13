package com.bingsoo.job.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bingsoo.job.entity.Company;
import com.bingsoo.job.entity.Member;
import com.bingsoo.job.entity.RedBean;
import com.bingsoo.job.repository.CompanyRepository;
import com.bingsoo.job.repository.MemberRepository;
import com.bingsoo.job.repository.RedBeanRepository;

@RestController
@RequestMapping("/main")
public class MainController {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private RedBeanRepository redBeanRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @PostMapping("/join-form/job-seeker")
    public ResponseEntity<String> registerMember(@RequestParam("username") String username,
                                                 @RequestParam("password") String password,
                                                 @RequestParam("name") String name,
                                                 @RequestParam("tel") String tel,
                                                 @RequestParam("address") String address,
                                                 @RequestParam("email") String email,
                                                 @RequestParam("birth") String birth,
                                                 @RequestParam("gender") String gender,
                                                 @RequestParam("military") String military) {
        
    	Date birthDate = null;
    	try {
    	    birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(birth);
    	} catch (ParseException e) {
    	    e.printStackTrace();
    	}
    	
    	// Member 엔티티 생성 및 저장
        Member member = Member.builder()
                .username(username)
                .password(password)
                .role("ROLE_RED_BEAN")
                .build();
        member = memberRepository.save(member);

        // RedBean 엔티티 생성 및 저장
        RedBean redBean = RedBean.builder()
                .rid(member)
                .name(name)
                .tel(tel)
                .address(address)
                .email(email)
                .birth(birthDate)
                .gender(gender)
                .military(military)
                .build();
        redBeanRepository.save(redBean);

        return ResponseEntity.ok("일반 회원 가입 성공");
    }


    @PostMapping("/join-form/company")
    public ResponseEntity<String> registerCompany(@RequestParam("username") String username,
                                                  @RequestParam("password") String password,
                                                  @RequestParam("cno") String cno,
                                                  @RequestParam("companyName") String companyName,
                                                  @RequestParam("size") String size,
                                                  @RequestParam("ceo") String ceo,
                                                  @RequestParam("tel") String tel,
                                                  @RequestParam("sales") Integer sales,
                                                  @RequestParam("address") String address,
                                                  @RequestParam("managerName") String managerName,
                                                  @RequestParam("managerTel") String managerTel,
                                                  @RequestParam("managerEmail") String managerEmail) {
        // Member 엔티티 생성 및 저장
        Member member = Member.builder()
                .username(username)
                .password(password)
                .role("ROLE_ICE")
                .build();
        member = memberRepository.save(member);

        // Company 엔티티 생성 및 저장
        Company company = Company.builder()
                .cno(cno)
                .cid(member)
                .company_name(companyName)
                .size(size)
                .ceo(ceo)
                .tel(tel)
                .sales(sales)
                .address(address)
                .manager_name(managerName)
                .manager_tel(managerTel)
                .manager_email(managerEmail)
                .build();
        companyRepository.save(company);

        return ResponseEntity.ok("기업 회원 가입 성공");
    }
}
