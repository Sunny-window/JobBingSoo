package com.bingsoo.job.jwtToken;

import java.io.IOException;
import java.util.Enumeration;

import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTFilter extends OncePerRequestFilter{
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
	        throws ServletException, IOException {
	    System.out.println("JWTFiter...................");
		String path = request.getRequestURI();
		Enumeration<String> headers = request.getHeaderNames();
		while(headers.hasMoreElements()) {
			System.out.println(headers.nextElement());
		}

		
		
	    // 로그인 경로는 필터를 통과시키기
	    if (path.equals("/auth/login") || path.startsWith("/main") || path.equals("/manager/find-postings") || path.startsWith("/sub") ||path.startsWith("/cs")) {
	        
	    	System.out.println("login 통과");
	    	
	    	filterChain.doFilter(request, response);
	        return;
	    }

	    String authHeader = request.getHeader("Authorization");
	    System.out.println("authHeader ......." + authHeader);
	    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
	    	System.out.println("No token!!!!");
	        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Missing or invalid Authorization header.");
	        return;
	    }

	    String token = authHeader.substring(7);
	    Claims claims;
	    try {
	        claims = JWTUtil.parseToken(token);
	    } catch (Exception e) {
	        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token.");
	        return;
	    }

	    String role = claims.get("role", String.class);

	 // 역할에 따른 경로 접근 제어
	    if (path.startsWith("/ice") && !"COM".equals(role)) {
	        response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access to this path is forbidden.");
	        return;
	    }

	    if (path.startsWith("/redbean") && !"BEAN".equals(role)) {
	        response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access to this path is forbidden.");
	        return;
	    }

	    if (path.startsWith("/manager") && !"ADMIN".equals(role)) {
	        response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access to this path is forbidden.");
	        return;
	    }

	    filterChain.doFilter(request, response);
	}
}