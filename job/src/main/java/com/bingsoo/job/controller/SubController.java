package com.bingsoo.job.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bingsoo.job.entity.Company;
import com.bingsoo.job.entity.Member;
import com.bingsoo.job.entity.Notice;
import com.bingsoo.job.entity.Posting;
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

    @DeleteMapping("/notice")
    public ResponseEntity<String> deleteNotice(@RequestHeader("Authorization") String token, @RequestParam("ntcode") Long ntcode ){
        boolean isValid = JWTUtil.validateToken(token.substring(7));
        if (!isValid) {
            return ResponseEntity.badRequest().body("Wrong Request. need to login");
        }
        String loggedusername = JWTUtil.getUsername(token.substring(7));
        Optional<Notice> notice = nr.findById(ntcode);
        if(notice.isPresent()){
            if(notice.get().getReciever().getUsername().equals(loggedusername)){
                nr.deleteById(ntcode);
                return ResponseEntity.ok().body("success");
            }
            return ResponseEntity.badRequest().body("Can't delete it unless it's yours");
        }
        return ResponseEntity.badRequest().body("Dosen't exist");
    }

    @DeleteMapping("/notice-all")
    public ResponseEntity<String> deleteAllMyNotice(@RequestHeader("Authorization") String token){
        boolean isValid = JWTUtil.validateToken(token.substring(7));
        if (!isValid) {
            return ResponseEntity.badRequest().body("Wrong Request. Need to login ");
        }
        String loggedusername = JWTUtil.getUsername(token.substring(7));
        nr.deleteAllMyNotice(loggedusername);
        return ResponseEntity.ok().body("Clear. ");
    }

    @GetMapping("/post/{keyword}")
    public List<Posting> searchPostings(@PathVariable("keyword") String keyword){


        return null;
    } 

    @GetMapping("/company/{keyword}")
    public List<Company> searchCompanys(@PathVariable("keyword") String keyword){
        

        return null;
    } 
}
