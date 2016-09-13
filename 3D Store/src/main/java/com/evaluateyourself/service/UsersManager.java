/**
 * 
 */
package com.evaluateyourself.service;

import java.io.Serializable;
import java.util.List;

import org.hibernate.ObjectNotFoundException;

import com.evaluateyourself.model.Users;

/**
 * @author Mateusz [mateusz.miernik86@gmail.com]
 * Interface represents set of methods for manipulation Users table 
 */
public interface UsersManager {	
	/**
	 * This method creates new User in Users data base
	 * @param user new User to add
	 */
    void create(Users user);
	/**
	 * Method search for object, which has primary_key = id
	 * @param id Specified id for Users model object for search
	 * @return Users Model object with id
	 */
	Users get(Serializable id);
	/**
	 * Method returns temporary object without hitting the database 
	 * @param Id specified primary key for search object
	 * @return Users Users object represents row. If no row found, it will throws {@link ObjectNotFoundException ObjectNotFoundException}
	 */
	Users load(Serializable id);
	/**
	 * Get all rows of table represents by Users model object
	 * @return List of all rows in data source
	 */
	List<Users> getAll();
	/**
	 * Update row represents by T model object 
	 * @param user Model Object
	 */
	void update(Users user);
	/**
	 * Remove a persistent instance from data store.
	 * @param user Model object
	 */
	void delete(Users user);
	/**
	 * Delete a persistent from data store. 
	 * @param id Primary key of model object
	 */
	void deleteById(Serializable id);
	/**
	 * Delete all persistent instances from data store 
	 */
	void deleteAll();
	/**
	 * 
	 * @return Amount of records in table represent by model object
	 */
	long count();
	/**
	 * Check if object exist in data store 
	 * @param id Primary key of model object 
	 * @return true if object exist, false otherwise
	 */
	boolean exist(Serializable id);
    
   
}
