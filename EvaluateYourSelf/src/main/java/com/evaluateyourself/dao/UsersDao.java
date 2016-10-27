package com.evaluateyourself.dao;

import com.evaluateyourself.model.*;
/**
 * 
 * @author Mateusz [mateusz.miernik86@gmail.com]
 */
public interface UsersDao extends Dao<Users>{
	
    public Users findByEmail(String email);
    public Users findByEmailOrLoginAndPassword(String encodedEmail, String encodedPassword);
}
