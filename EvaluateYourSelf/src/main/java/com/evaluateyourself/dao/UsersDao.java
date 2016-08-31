package com.evaluateyourself.dao;
import java.util.Collection;
import java.util.List;

import com.evaluateyourself.model.*;
/**
 * 
 * @author Mateusz
 *
 */
public interface UsersDao extends Dao<Users>{
	 
    public Users findByPk(int pk);
    
    public Users findByLogin(String login);
    
    public Collection<Users> findByLastName(String lastName);

}
