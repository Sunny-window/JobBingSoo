package com.bingsoo.job.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bingsoo.job.entity.Member;
import com.bingsoo.job.entity.Notice;
import com.bingsoo.job.repository.NoticeRepository;

@CrossOrigin("*")
@RequestMapping("/sub")
@RestController
public class SubController {

    @Autowired
    private NoticeRepository nr;
    
    @GetMapping("/notice/{username}")
    public List<Notice> myNoticeList(@PathVariable("username")String username){
        Member reciever = new Member();
        reciever.setUsername(username);
        return nr.findAllByReciever(reciever);
    }

}
