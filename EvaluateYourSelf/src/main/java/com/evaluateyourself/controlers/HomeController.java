package com.evaluateyourself.controlers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private ApplicationContext context; 
	private DriverManagerDataSource dataSource;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	public HomeController() {
		context = new ClassPathXmlApplicationContext("root-context.xml");
		dataSource = (DriverManagerDataSource)context.getBean("myDataSource");
	} 
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(Model model){
		String greetings = "Greetings, Spring MVC! and Postgresql is " + dataSource.getUrl();
		model.addAttribute("message", greetings);
		return "test";
	}
	
}
