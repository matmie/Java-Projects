/**
 * 
 */
package com.evaluateyourself.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public Users create(Users user) {
		return usersdao.create(user);
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
	public Map<Integer,Users> getAll() {
		
		Map<Integer,Users> result = new HashMap<Integer,Users>();
		List<Users> resultList = usersdao.getAll();
		for(Users usr: resultList){
			result.put(usr.getUsid(), usr);
		}
		return result;
	}

	@Override
	@Transactional
	public Users update(Users user) {
		usersdao.update(user);
		return user;
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
