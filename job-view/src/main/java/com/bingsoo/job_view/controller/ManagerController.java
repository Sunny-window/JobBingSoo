package com.bingsoo.job_view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/manager")
@CrossOrigin(origins = "http://localhost:8080")
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
}
