package com.evaluateyourself.controlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.evaluateyourself.model.Users;
import com.evaluateyourself.model.nodb.AuthenticatedUser;
import com.evaluateyourself.service.UsersManager;
import com.evaluateyourself.utils.jwt.JwtUtil;

@RestController
@RequestMapping(value = "/authentication")
public class AuthenticationRestController {
	
	
	private Logger logger = LoggerFactory.getLogger(AuthenticationRestController.class);
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UsersManager usersManager;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public AuthenticatedUser login(@RequestBody Users user) {
		logger.info("Przed generowaniem: " + user.toString());
		logger.info("Po generowaniu: " + jwtUtil.generateToken(user));
		return null;
	}
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public Users signup(@RequestBody Users user){
		user = usersManager.registerUser(user);
		return user;
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public String handleException(Exception e) {
	    return e.getClass().getSimpleName();
	}
}
