package com.evaluateyourself.utils.jwt;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.evaluateyourself.exceptions.JwtTokenMalformedException;
import com.evaluateyourself.model.Users;
import com.evaluateyourself.model.nodb.AuthenticatedUser;
import com.evaluateyourself.model.nodb.JwtAuthenticationToken;

@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
    
	private Logger logger = LoggerFactory.getLogger(JwtAuthenticationProvider.class);
	
	@Autowired
	private JwtUtil jwtUtil;
	
	
	@Override
	public boolean supports(Class<?> authentication) {
				return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
	}
	
	@Override
	protected void additionalAuthenticationChecks(UserDetails arg0, UsernamePasswordAuthenticationToken arg1)
			throws AuthenticationException {

	}

	@Override
	protected UserDetails retrieveUser(String userEmail, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication;
		
		logger.info("Co jest w authenticaiton token: " + authentication);
		String token = jwtAuthenticationToken.getToken();
		
		Users parsedUser = jwtUtil.parseToken(token);
		
		Users usr = new Users();
		usr.setUsemail("mateuch@wp.pl");
		usr.setUsid(23);
		usr.setUsroles("admin");
		logger.info("Parsuje przykladowy token: " + jwtUtil.generateToken(usr));
		
		if(parsedUser == null){
			throw new JwtTokenMalformedException("JWT token is not valid");
		}
		
		List<GrantedAuthority> authorityList = AuthorityUtils.commaSeparatedStringToAuthorityList(parsedUser.getUsroles());
		
		return new AuthenticatedUser(parsedUser.getUsid(), parsedUser.getUsemail(), token, authorityList);
	}

}
