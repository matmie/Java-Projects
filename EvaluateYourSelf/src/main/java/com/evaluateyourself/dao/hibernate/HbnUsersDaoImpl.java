/**
 * 
 */
package com.evaluateyourself.dao.hibernate;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.evaluateyourself.dao.UsersDao;
import com.evaluateyourself.model.Users;

/**
 * 1) Before Impl DAO clases must need to provide DAO Interface
 * 2) In DAO interface create signatures with model object
 * 3) In DAO implementation get Connection from connection pool
 */
/**
 * @author Mateusz
 *
 */
@Repository
public class HbnUsersDaoImpl extends AbstractHbnDao<Users> implements UsersDao {

	@Override
	public Users findByPk(int pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users findByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Users> findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}
    
}
