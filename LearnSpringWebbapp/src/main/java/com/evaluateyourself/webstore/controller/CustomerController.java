/**
 * 
 */
package com.evaluateyourself.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.evaluateyourself.webstore.service.CustomerService;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 *
 */
@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/customers")
	public String allcustomers(Model model){
		model.addAttribute("customers", customerService.getAllCustomers());
		return "customers";
	}
}
