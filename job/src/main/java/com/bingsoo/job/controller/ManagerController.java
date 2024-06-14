package com.bingsoo.job.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bingsoo.job.entity.Company;
import com.bingsoo.job.entity.Cs;
import com.bingsoo.job.entity.Cs_reply;
import com.bingsoo.job.entity.Member;
import com.bingsoo.job.entity.Notice;
import com.bingsoo.job.repository.CompanyRepository;
import com.bingsoo.job.repository.CsRepository;
import com.bingsoo.job.repository.Cs_replyRepository;
import com.bingsoo.job.repository.MemberRepository;
import com.bingsoo.job.repository.NoticeRepository;

@RestController
@RequestMapping("/manager")
@CrossOrigin(origins = "http://localhost:8080")
public class ManagerController {

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

	@GetMapping("/member-all")
	public Map<String, List<?>> getData() {
		List<Member> members = memberRepository.findAll();
		List<Company> companies = companyRepository.findAll();
		Map<String, List<?>> data = new HashMap<>();
		data.put("members", members);
		data.put("companies", companies);
		return data;
	}

    @PostMapping("/notice")
    public Notice sendNotice(@RequestBody Notice notice) {
        return noticeRepository.save(notice);
    }


	@GetMapping("/admin-csList")
	public List<Cs> getCsList(@RequestParam("type") String type) {
		return csRepository.findByTypeOrderByResultAscDateAsc(type);
	}

	 @GetMapping("/cs-detail")
	    public Map<String, Object> getCsDetail(@RequestParam("cs_code") long csCode) {
	        Map<String, Object> response = new HashMap<>();
	        Cs cs = csRepository.findById(csCode).orElse(null);
	        if (cs != null) {
	            response.put("cs", cs);
	            List<Cs_reply> replies = cs_replyRepository.findByCsCode(cs);
	            response.put("replies", replies);
	        }
	        return response;
	    }

	 @PostMapping("/reply")
	 public Cs_reply addOrUpdateReply(@RequestParam("cs_code") long csCode, @RequestParam("comment") String comment, @RequestParam("reply_id") Optional<Long> replyId) {
	     Cs cs = csRepository.findById(csCode).orElse(null);
	     if (cs != null) {
	         Cs_reply reply;
	         if (replyId.isPresent()) {
	             Optional<Cs_reply> optionalReply = cs_replyRepository.findById(replyId.get());
	             if (optionalReply.isPresent()) {
	                 reply = optionalReply.get();
	             } else {
	                 reply = new Cs_reply();
	             }
	         } else {
	             reply = new Cs_reply();
	         }
	         reply.setCsCode(cs);
	         reply.setComment(comment);
	         cs.setResult("답변");
	         csRepository.save(cs);
	         return cs_replyRepository.save(reply);
	     }
	     return null;
	 }

	    @PostMapping("/reply/{replyId}/edit")
	    public Cs_reply editReply(@PathVariable("replyId") long replyId, @RequestParam("comment") String comment) {
	        Cs_reply reply = cs_replyRepository.findById(replyId).orElse(null);
	        if (reply != null) {
	            reply.setComment(comment);
	            return cs_replyRepository.save(reply);
	        }
	        return null;
	    }
}
