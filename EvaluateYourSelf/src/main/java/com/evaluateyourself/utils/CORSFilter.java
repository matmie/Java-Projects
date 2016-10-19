package com.evaluateyourself.utils;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * <code>
 *	<filter>
 *	  <filter-name>cors</filter-name>
 *	  <filter-class>com.evaluateyourself.utils.CORSFilter</filter-class>
 *	</filter>
 *	  
 *	<filter-mapping>
 *	  <filter-name>cors</filter-name>
 *	  <url-pattern>/*</url-pattern>
 *	</filter-mapping>
 * </code>
 */
public class CORSFilter extends OncePerRequestFilter {
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		if (request.getHeader("Access-Control-Request-Method") != null && "OPTIONS".equals(request.getMethod())) {
			response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
            response.addHeader("Access-Control-Allow-Headers", "Content-Type");
            response.addHeader("Access-Control-Allow-Headers", "access-control-allow-origin");
			response.setHeader("Access-Control-Max-Age", "1");
		}
		
		filterChain.doFilter(request, response);
	}

}
