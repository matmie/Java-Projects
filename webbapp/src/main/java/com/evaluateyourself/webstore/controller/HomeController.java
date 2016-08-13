/**
 * 
 */
package com.evaluateyourself.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
