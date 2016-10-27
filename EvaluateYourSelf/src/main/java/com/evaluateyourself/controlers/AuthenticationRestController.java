package com.evaluateyourself.controlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evaluateyourself.model.Users;
import com.evaluateyourself.model.nodb.AuthenticatedUser;
import com.evaluateyourself.utils.jwt.JwtUtil;

@RestController
@RequestMapping(value = "/authentication")
public class AuthenticationRestController {
	
	
	private Logger logger = LoggerFactory.getLogger(AuthenticationRestController.class);
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@RequestMapping("/login")
	public AuthenticatedUser login(@RequestBody Users user) {
		logger.info("Przed generowaniem: " + user.toString());
		logger.info("Po generowaniu: " + jwtUtil.generateToken(user));
		return null;
	}
	@RequestMapping("/signup")
	public Users signup(@RequestBody Users user){
		
	}
}
