/**
 * 
 */
package com.evaluateyourself.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.evaluateyourself.dao.UsersDao;
import com.evaluateyourself.model.Users;
import com.evaluateyourself.service.UsersManager;

/**
 * @author Mateusz [mateusz.miernik86@gmail.com]
 *
 */
@Service
public class UsersManagerImpl implements UsersManager {
	
	@Autowired
	UsersDao usersdao;

	@Override
	@Transactional
	public void create(Users user) {
		usersdao.create(user);
	}

	@Override
	@Transactional(readOnly=true)
	public Users get(Serializable id) {
		return usersdao.get(id);
	}

	@Override
	@Transactional(readOnly=true)
	public Users load(Serializable id) {
		return usersdao.load(id);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Users> getAll() {
		return usersdao.getAll();
	}

	@Override
	@Transactional
	public void update(Users user) {
		usersdao.update(user);
	}

	@Override
	@Transactional
	public void delete(Users user) {
		usersdao.delete(user);
	}

	@Override
	@Transactional
	public void deleteById(Serializable id) {
		usersdao.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteAll() {
		usersdao.deleteAll();
	}

	@Override
	@Transactional(readOnly=true)
	public long count() {
		return usersdao.count();
	}

	@Override
	@Transactional(readOnly=true)
	public boolean exist(Serializable id) {
		return usersdao.exist(id);
	}
	
	

}
