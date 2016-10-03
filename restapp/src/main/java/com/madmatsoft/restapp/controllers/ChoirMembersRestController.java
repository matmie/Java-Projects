/**
 * 
 */
package com.madmatsoft.restapp.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.madmatsoft.restapp.model.ChoirMember;
import com.madmatsoft.restapp.model.service.ChoirMemberService;

/**
 * @author Mateusz Miernik
 *
 */
@RestController
public class ChoirMembersRestController {
	
	@Autowired
	private ChoirMemberService choirMemberService;
	
	@RequestMapping(value="/membersList/getAll", method=RequestMethod.GET)
	public List<ChoirMember> getAll(){
		return choirMemberService.getAll();
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/membersList/add")
	public ChoirMember create(@RequestBody ChoirMember choirMember){
		return choirMemberService.read(choirMemberService.create(choirMember));
	}
	
	@RequestMapping(value="/membersList/update/{choirMemberId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void update(@PathVariable(value = "choirMemberId") long choirMemberId, @RequestBody ChoirMember choirMember){
		choirMemberService.update(choirMemberId, choirMember);
	}
	
	@RequestMapping(value = "/membersList/delete/{choirMemberId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(value = "choirMemberId") long choirMemberId) {
		choirMemberService.delete(choirMemberId);
	}
	
	
}
