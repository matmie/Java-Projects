/**
 * 
 */
package com.evaluateyourself.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.evaluateyourself.model.Users;

/**
 * @author Mateusz
 *
 */
@Repository
@Transactional
public class UsersDAOImpl implements UsersDAO {
    
	
	@PersistenceContext
	private EntityManager manager;
	/* (non-Javadoc)
	 * @see com.evaluateyourself.dao.UsersDAO#getAllUsers()
	 */
	@Override
	public List<Users> getAllUsers() {
		List<Users> usersList = manager.createQuery("FROM Users", Users.class).getResultList();
		return usersList;
	}

	/* (non-Javadoc)
	 * @see com.evaluateyourself.dao.UsersDAO#addUser(com.evaluateyourself.model.Users)
	 */
	@Override
	public void addUser(Users user) {
		manager.persist(user);
	}

}
