package com.bingsoo.job.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bingsoo.job.entity.Member;
import com.bingsoo.job.jwtToken.JWTUtil;
import com.bingsoo.job.repository.MemberRepository;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:8080")
public class AuthController {
	
	@Autowired
    private MemberRepository memberRepository;

	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("role") String role, HttpServletResponse response) throws IOException {
	    Member member = memberRepository.findById(username).orElse(null);
	    Map<String, Object> result = new HashMap<>();

	    if (member == null) {
	        result.put("success", false);
	        result.put("message", "사용자 이름이 존재하지 않습니다.");
	        return ResponseEntity.status(HttpServletResponse.SC_UNAUTHORIZED).body(result);
	    }

	    if (!member.getPassword().equals(password)) {
	        result.put("success", false);
	        result.put("message", "비밀번호가 일치하지 않습니다.");
	        return ResponseEntity.status(HttpServletResponse.SC_UNAUTHORIZED).body(result);
	    }

	    if (!member.getRole().equals(role)) {
	        result.put("success", false);
	        result.put("message", "역할이 일치하지 않습니다.");
	        return ResponseEntity.status(HttpServletResponse.SC_UNAUTHORIZED).body(result);
	    }

	    String token = JWTUtil.generateToken(member.getUsername(), member.getRole());
	    response.addHeader("Authorization", "Bearer " + token);

	    result.put("success", true);
	    result.put("token", token);  // JWT 토큰을 JSON 응답에 추가

	    if ("COM".equals(member.getRole())) {
	        result.put("redirectUrl", "http://localhost:8080/main/index");
	    } else if ("BEAN".equals(member.getRole())) {
	        result.put("redirectUrl", "http://localhost:8080/main/index");
	    } else if ("ADMIN".equals(member.getRole())) {
	        result.put("redirectUrl", "http://localhost:8080/manager/youtubeplayer");
	    }

	    return ResponseEntity.ok(result);
	}
}