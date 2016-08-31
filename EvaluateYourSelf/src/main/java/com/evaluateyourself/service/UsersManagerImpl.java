/**
 * 
 */
package com.evaluateyourself.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluateyourself.dao.UsersDao;
import com.evaluateyourself.model.Users;

/**
 * @author Mateusz
 *
 */
@Service
public class UsersManagerImpl implements UsersManager {
	
	@Autowired
	UsersDao usersdao;
	
	/* (non-Javadoc)
	 * @see com.evaluateyourself.service.UsersManager#getAllUsers()
	 */
	@Override
	public List<Users> getAllUsers() {
		return usersdao.getAll();
	}

	/* (non-Javadoc)
	 * @see com.evaluateyourself.service.UsersManager#addUser(com.evaluateyourself.model.Users)
	 */
	@Override
	public void addUser(Users user) {
		usersdao.create(user);
	}

}
