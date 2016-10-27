/**
 * 
 */
package com.evaluateyourself.controlers;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.evaluateyourself.model.Users;
import com.evaluateyourself.service.UsersManager;

/**
 * @author Mateusz
 *
 */
@RestController
@RequestMapping(value = "/users")
public class UsersController {

	@Autowired
	UsersManager usersManager;
	
	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public Map<Integer,Users> getAllUsers(){
		return usersManager.getAll();
	}
	
	@RequestMapping(value = "/user/{userid}", method = RequestMethod.GET)
	public Users get(@PathVariable("userid") Integer id){
		return usersManager.get(id);
	}
	
	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public Users create(@RequestBody Users user){
		return usersManager.create(user);
	}
	
	@RequestMapping(value = "/user/delete", method = RequestMethod.DELETE)
	public void delete(@RequestBody Users user){
		usersManager.delete(user);
	}
	
	@RequestMapping(value = "/user/update", method = RequestMethod.PUT)
	public Users update(@RequestBody Users user){
		return usersManager.update(user);
	}
	
	
}
