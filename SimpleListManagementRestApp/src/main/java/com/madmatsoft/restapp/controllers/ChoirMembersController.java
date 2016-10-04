/**
 * 
 */
package com.madmatsoft.restapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.madmatsoft.restapp.model.service.ChoirMemberService;

/**
 * @author Mateusz Miernik
 *
 */
@Controller
public class ChoirMembersController {
	
	@Autowired 
	private ChoirMemberService choirMemberService;
	
	@RequestMapping("/membersList")
	public String listAllMembers(Model model){
        
		return "index";
	}
	
}
