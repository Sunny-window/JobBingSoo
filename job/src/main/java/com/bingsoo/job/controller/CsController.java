package com.bingsoo.job.controller;

import java.util.List;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bingsoo.job.entity.Cs;
import com.bingsoo.job.entity.FAQ;
import com.bingsoo.job.entity.Member;
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
    public List<FAQ> getFAQList() {

        return fr.findAll();
    }

    @GetMapping("/cslist")
    public List<Cs> getCsList() {
        return cr.findPublicAll();
    }

    @GetMapping("/my-list")
    public List<Cs> getMyCsList(@RequestHeader("Authorization") String token ){
        String logged = JWTUtil.getUsername(token.substring(7));

        return cr.getMyList(logged);
    }

    @DeleteMapping("/cs")
    public ResponseEntity<String> deleteCs(@RequestParam("csCode") String code,
            @RequestHeader("Authorization") String token) {
        // 'Bearer ' 접두사를 제거하고 실제 토큰을 추출
        String actualToken = token.substring(7);
        String tokenname = JWTUtil.getUsername(actualToken);
        String tokenrole = JWTUtil.getRole(actualToken);
        String writer = cr.findById(Long.parseLong(code)).get().getRid().getUsername();
        if (tokenrole.equals("ADMIN") || writer.equals(tokenname)) {
            crrepo.deleteByCsCode(Long.parseLong(code));
            cr.deleteById(Long.parseLong(code));
            return ResponseEntity.ok().body("삭제되었습니다.");
        } else {
            return ResponseEntity.status(401).body("권한이 없습니다.");
        }
    }

    @PostMapping("/cs")
    public ResponseEntity<String> postCs(@RequestHeader("Authorization") String token, @RequestBody Cs cs) {
        boolean isValid = JWTUtil.validateToken(token.substring(7));
        if (!isValid) {
            return ResponseEntity.status(401).body("Unauthorized");
        }

        String username = JWTUtil.getUsername(token.substring(7));
        Member writer = new Member();
        writer.setUsername(username);
        cs.setDate(LocalDate.now());
        cs.setRid(writer);
        cs.setResult("미답변");

        cr.save(cs);
        return ResponseEntity.ok().body("저장완료");
    }
}