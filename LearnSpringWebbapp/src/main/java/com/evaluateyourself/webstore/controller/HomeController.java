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
public class HomeController {
	
	@RequestMapping("/")
	public String welcome(Model model){
		model.addAttribute("greeting", "Witaj w sklepie internetowym");
		model.addAttribute("tagline", "Wyj¹tkowym i jedynym sklepie internetowym");
		return "welcome";
	}
	@RequestMapping(value="/welcome/greeting", method=RequestMethod.GET)
	public String greeting(){
		return "welcome";
	}
}
