/**
 * 
 */
package com.evaluateyourself.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 *
 */
@Controller
public class LoginController {
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	@RequestMapping(value="/loginfailed", method=RequestMethod.GET)
	public String loginerror(Model model){
		model.addAttribute("error", "true");
		return "login";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(Model model){
		return "login";
	}
}
