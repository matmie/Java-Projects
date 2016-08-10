/**
 * 
 */
package com.evaluateyourself.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.evaluateyourself.model.Users;
import com.evaluateyourself.service.UsersManager;

/**
 * @author Mateusz
 *
 */
@Controller
@RequestMapping(value = "/userRegistration")
@SessionAttributes("user")
public class UsersController {

	@Autowired
	UsersManager manager;

	@ModelAttribute("allUsers")
	public List<Users> populateUsers() {
		List<Users> users = manager.getAllUsers();
		return users;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String setupPage(Model model) {

		return "usersRegistration";
	}
}
