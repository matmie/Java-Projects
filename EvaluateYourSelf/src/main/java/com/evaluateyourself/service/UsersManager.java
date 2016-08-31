/**
 * 
 */
package com.evaluateyourself.service;

import java.util.List;


import com.evaluateyourself.model.Users;

/**
 * @author Mateusz
 *
 */
public interface UsersManager {
	
	/**
	 * Get all users from the Users table
	 * @return all users from database
	 */
	public List<Users> getAllUsers();
	
	/**
	 * Method create new User in Users data table
	 * @param user new User to add
	 */
    public void addUser(Users user);
   
}
