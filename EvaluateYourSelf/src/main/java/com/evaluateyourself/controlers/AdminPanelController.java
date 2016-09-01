/**
 * 
 */
package com.evaluateyourself.controlers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.evaluateyourself.service.UsersManager;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 * Controller class represents admin panel for users, usersGroup, portal options managing 
 */
@Controller
@RequestMapping("/adminPanel")
public class AdminPanelController {
	
	static final Logger log = LoggerFactory.getLogger(AdminPanelController.class);
	
	@Autowired
	UsersManager usersManager;
	
	/**
	 * Method initialize all components on admin panel.
	 * TODO Using REST to managing types of informations(users,groups etc) Users, UsersGroups ets will represents by different tabs
	 * @param model Object to set attributes for JSP
	 * @return Name of JSP view
	 */
	@RequestMapping("")
	public String initializationAdminPanel(Model model){
		log.debug("Logger zadzia³a³");
		model.addAttribute("users", usersManager.getAll());
		return "adminPanel";
	}
}
