package com.evaluateyourself.dao;
import java.util.Collection;
import java.util.List;

import com.evaluateyourself.model.*;
/**
 * 
 * @author Mateusz [mateusz.miernik86@gmail.com]
 * Interface define methods especially for Users table/domain
 */
public interface UsersDao extends Dao<Users>{
	/**
	 * Search user with specify login
	 * @param login Login for search
	 * @return User object represents user
	 */
    public Users findByLogin(String login);
}
