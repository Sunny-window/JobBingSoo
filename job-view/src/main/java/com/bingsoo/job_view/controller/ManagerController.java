package com.bingsoo.job_view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/manager")
public class ManagerController {

	@GetMapping("/member-all")
	public String managerPage() {
		return "manager/managerpage";
	}

	@GetMapping("/send_notice")
	public String sendNoticeForm(@RequestParam("receiver") String receiver, Model model) {
		model.addAttribute("receivers", receiver);
		return "manager/send_notice";
	}

	@GetMapping("/admin-csList")
	public String csList() {
		return "manager/cs_list";
	}

	@GetMapping("/admin-cs_detailAndReply")
	public String cs_detailAndReply() {
		return "manager/cs_detailAndReply";
	}


    @GetMapping("/mypage")
    public String myPage(Model model) {
        return "manager/mypage";
    }
    
    @GetMapping("/dashboard")
    public String dashboard() {
    	return "manager/dashboard";
    }
    
    @GetMapping("/kakao-share")
    public String kakaoShare() {
        return "manager/kakao_share";
    }
    
    @GetMapping("/youtubeplayer")
    public String youtubeplayer() {
        return "manager/youtubeplayer";
    }
    
    @RequestMapping("/managerLogin")
	public String managerLogin() {
		return "manager/managerLogin";
	}
	
    @RequestMapping("/apply")
    public String apply() {
    	return "manager/apply";
    }
    
    @RequestMapping("/writeResume")
    public String writeResume() {
    	return "manager/writeResume";
    }
    
    @RequestMapping("/ai")
    public String ai() {
    	return "manager/ai";
    }
}
