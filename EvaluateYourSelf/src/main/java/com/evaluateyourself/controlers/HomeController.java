package com.evaluateyourself.controlers;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.hibernate.stat.SessionStatistics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.evaluateyourself.model.Users;
import com.evaluateyourself.service.UsersManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	

	@Autowired
	DriverManagerDataSource dataSource;
	
	@Autowired
	UsersManager manager;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	public HomeController() {
		//context = new ClassPathXmlApplicationContext("root-context.xml");
		//dataSource = (DriverManagerDataSource)context.getBean("myDataSource");
	} 
	
    public List<Users> populateUsers() 
    {
        List<Users> users = manager.getAllUsers();
        logger.info("Pobra³em usersow " + Integer.toString(users.size()));
        return users;
    }
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(Model model){
		boolean isClosed = false;
		try {
			isClosed = dataSource.getConnection().isClosed();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		String greetings =  "";
		if(isClosed)
		{
			greetings = greetings + " And is closed";
		}
		else
		{
			try {
				greetings = greetings + " And is open on port " + dataSource.getConnection().getMetaData().getUserName() + "asdaddwefscdd";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		model.addAttribute("allUsers", this.populateUsers());
		//greetings
		model.addAttribute("message", greetings);
		return "usersRegistration";
	}
	
}
