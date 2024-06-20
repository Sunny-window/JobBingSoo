package com.bingsoo.job.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bingsoo.job.entity.Member;
import com.bingsoo.job.entity.Notice;
import com.bingsoo.job.jwtToken.JWTUtil;
import com.bingsoo.job.repository.NoticeRepository;

@CrossOrigin("*")
@RequestMapping("/sub")
@RestController
public class SubController {

    @Autowired
    private NoticeRepository nr;
    
    @GetMapping("/notice")
    public List<Notice> myNoticeList(@RequestHeader("Authorization") String token){
        boolean isValid = JWTUtil.validateToken(token.substring(7));
        if (!isValid) {
            return null;
        }
        String username = JWTUtil.getUsername(token.substring(7));
        Member reciever = new Member();
        reciever.setUsername(username);
        return nr.findAllByReciever(reciever);
    }

}
