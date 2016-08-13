package com.evaluateyourself.dao;
import java.util.Collection;
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
	public List<Users> findAll();
	
	/**
	 * Method create new User in Users data table
	 * @param user new User to add
	 */
    public int save(Users user);
    
    /**
     * @param user
     * @return
     */
    public boolean update(Users user);
    
    public boolean delete(Users user);
    
    public Users findByPk(int pk);
    
    public Users findByLogin(String login);
    
    public Collection<Users> findByLastName(String lastName);
    
    public String getAllInfo();
    
    
    
    
}
