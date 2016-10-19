package com.evaluateyourself.dao;

import com.evaluateyourself.model.*;
/**
 * 
 * @author Mateusz [mateusz.miernik86@gmail.com]
 */
public interface UsersDao extends Dao<Users>{
	
    public Users findByLogin(String login);
}
