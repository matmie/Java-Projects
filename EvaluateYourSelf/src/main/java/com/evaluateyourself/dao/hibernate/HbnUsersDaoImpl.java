/**
 * 
 */
package com.evaluateyourself.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.evaluateyourself.dao.UsersDao;
import com.evaluateyourself.model.Users;
/**
 * @author Mateusz
 */
@Repository
public class HbnUsersDaoImpl extends AbstractHbnDao<Users> implements UsersDao {

	private Logger logger = LoggerFactory.getLogger(HbnUsersDaoImpl.class);
	
	@Override
	public Users findByEmail(String email) {
		Query query = super.getCurrentSession().createQuery("from Users where usemail = :email");
		query.setParameter("email", email);
		List<Users> resultList = (List<Users>)query.list();
		if(resultList.isEmpty()){
			return null;
		}
		return (Users)resultList.get(0);
	}

	@Override
	public Users findByEmailOrLoginAndPassword(String encodedEmail, String encodedPassword) {
		// TODO Auto-generated method stub
		return null;
	}
    
}
