/**
 * 
 */
package com.evaluateyourself.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.evaluateyourself.webstore.service.OrderService;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 *
 */
@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/order/P1234/2")
	public String process(){
		orderService.processOrder("P1234", 2);
		return "redirect:/products"; //Przeniesie nas do strony /products
	}
}
