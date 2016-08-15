/**
 * 
 */
package com.evaluateyourself.webstore.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.evaluateyourself.webstore.utils.Utils;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 *
 */
public class AuditingInterceptor extends HandlerInterceptorAdapter{
	Logger logger = Logger.getLogger("auditLogger");
	private String user;
	private String productId;
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(request.getRequestURI().endsWith("products/add") && request.getMethod().equals("POST")){
			user = request.getRemoteUser();
			productId = request.getParameterValues("productId")[0];
		}
		return true;
	}
	
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		if((request.getRequestURI().endsWith("products/add")) && (response.getStatus() == 302)){
			logger.info(String.format("Nowy produkkt [%s] dodany przes %s dnia %s", productId, user, Utils.getCurrentTime()));
		}
			
	}
}
