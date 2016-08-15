/**
 * 
 */
package com.evaluateyourself.webstore.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.evaluateyourself.webstore.utils.Utils;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 *
 */
public class PerformanceMonitorInterceptor implements HandlerInterceptor { // Je¿eli
																			// nie
																			// chcesz
																			// implementowac
																			// wszystkich
																			// metod
																			// to
																			// zamiast
																			// implementacji
																			// interfejsu
																			// rozszerz
																			// klase
																			// HandlerInterceptorAdapter

	ThreadLocal<StopWatch> stopWatchLocal = new ThreadLocal<StopWatch>();
	Logger logger = Logger.getLogger(this.getClass());

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.
	 * servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		StopWatch stopWatch = new StopWatch(handler.toString());
		stopWatch.start(handler.toString());
		stopWatchLocal.set(stopWatch);
		logger.info("Przetwarzanie ¿¹dania do œcie¿ki: " + Utils.getURLPatch(request));
		logger.info("Przetwarzanie ¿¹danie rozpoczêto 0: " + Utils.getCurrentTime());
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.
	 * servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("Przetwarzanie ¿¹dania zakoñczono o: " + Utils.getCurrentTime());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.
	 * servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * java.lang.Object, java.lang.Exception)
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		StopWatch stopWatch = stopWatchLocal.get();
		stopWatch.stop();
		logger.info("£¹czny czas przetwarzania ¿¹dania: " + stopWatch.getTotalTimeMillis() + " ms");
		stopWatchLocal.set(null);
		logger.info(
				"=====================================================================================================");

	}

}
