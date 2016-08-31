/**
 * 
 */
package com.evaluateyourself.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 * Generic DAO interface, which will be use with any specific DAO(UsersDAO, ContactsDAO etc.)
 */
public interface Dao<T extends Object> {
	
	void create(T t);
	T get(Serializable id);
	T load(Serializable id);
	List<T> getAll();
	void update(T t);
	void delete(T t);
	void deleteById(Serializable id);
	void deleteAll();
	long count();
	boolean exist(Serializable id);
}
