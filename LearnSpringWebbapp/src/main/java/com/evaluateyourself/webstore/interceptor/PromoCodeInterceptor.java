/**
 * 
 */
package com.evaluateyourself.webstore.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 *
 */
public class PromoCodeInterceptor extends HandlerInterceptorAdapter {
	private String promoCode;
	private String errorRedirect;
	private String offerRedirect;
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
			String givenPromoCode = request.getParameterValues("promo") == null ? "" :request.getParameterValues("promo")[0];
			if(request.getRequestURI().endsWith("products/specialOffer")){
				if(givenPromoCode.equals(promoCode)){
					response.sendRedirect(request.getContextPath()+"/" +offerRedirect);
				}else{
					response.sendRedirect(errorRedirect);
				}
				return false;
			}
		return true;
	}

	/**
	 * @return the promoCode
	 */
	public String getPromoCode() {
		return promoCode;
	}

	/**
	 * @param promoCode the promoCode to set
	 */
	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	/**
	 * @return the errorRedirect
	 */
	public String getErrorRedirect() {
		return errorRedirect;
	}

	/**
	 * @param errorRedirect the errorRedirect to set
	 */
	public void setErrorRedirect(String errorRedirect) {
		this.errorRedirect = errorRedirect;
	}

	/**
	 * @return the offerRedirect
	 */
	public String getOfferRedirect() {
		return offerRedirect;
	}

	/**
	 * @param offerRedirect the offerRedirect to set
	 */
	public void setOfferRedirect(String offerRedirect) {
		this.offerRedirect = offerRedirect;
	}
	
	
}
