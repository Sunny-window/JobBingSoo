package com.bingsoo.job.config;

public class CorsFilter {
/*
	 @Override
	    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
	        HttpServletResponse response = (HttpServletResponse) res;
	        HttpServletRequest request = (HttpServletRequest) req;

	        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
	        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
	        response.setHeader("Access-Control-Max-Age", "36000000");
	        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
	        response.setHeader("Access-Control-Allow-Credentials", "true");

	        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
	        	System.out.println("option if..............");
	            response.setStatus(HttpServletResponse.SC_OK);
	        } else {
	            try {
	            	System.out.println("option else try........");
					chain.doFilter(req, res);
				} catch (java.io.IOException e) {
					e.printStackTrace();
				} catch (ServletException e) {
					e.printStackTrace();
				}
	        }
	    }

	    @Override
	    public void init(FilterConfig filterConfig) {
	    }

	    @Override
	    public void destroy() {
	    }
*/    
}
