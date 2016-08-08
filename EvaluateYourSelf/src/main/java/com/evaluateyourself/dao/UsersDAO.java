package com.evaluateyourself.dao;
import java.util.List;

import com.evaluateyourself.model.*;
/**
 * 
 * @author Mateusz
 *
 */
public interface UsersDAO {
	
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
