/**
 * 
 */
package com.evaluateyourself.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.ObjectNotFoundException;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 * Generic DAO interface, which will be use with any specific DAO(UsersDAO, ContactsDAO etc.)
 */
public interface Dao<T extends Object> {
	/**
	 * Create T domain object representation into DataSource 
	 * @param t Model object
	 */
	T create(T t);
	/**
	 * Method search for object, which has primary_key = id
	 * @param id Specified id for T model object for search
	 * @return T Model object with id
	 */
	T get(Serializable id);
	/**
	 * Method returns temporary object without hitting the database 
	 * @param Id specified primary key for search object
	 * @return T T object represents row. If no row found, it will throws {@link ObjectNotFoundException ObjectNotFoundException}
	 */
	T load(Serializable id);
	/**
	 * Get all rows of table represents by T model object
	 * @return List of all rows in data source
	 */
	List<T> getAll();
	/**
	 * Update row represents by T model object 
	 * @param t Model Object
	 */
	void update(T t);
	/**
	 * Remove a persistent instance from data store.
	 * @param t Model object
	 */
	void delete(T t);
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
