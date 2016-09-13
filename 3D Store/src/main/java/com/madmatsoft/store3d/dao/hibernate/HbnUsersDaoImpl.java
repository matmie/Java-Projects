/**
 * 
 */
package com.madmatsoft.store3d.dao.hibernate;

import org.hibernate.Query;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.stereotype.Repository;

import com.madmatsoft.store3d.dao.UsersDao;
import com.madmatsoft.store3d.model.Users;

/**
 * 1) Before Impl DAO clases must need to provide DAO Interface
 * 2) In DAO interface create signatures with model object
 * 3) In DAO implementation get Connection from connection pool
 */
/**
 * @author Mateusz
 * Repository class with methods uses to Users objects manipulate  
 */
@Repository
public class HbnUsersDaoImpl extends AbstractHbnDao<Users> implements UsersDao {

	@Override
	public Users findByLogin(String login) {
		Query query = super.getCurrentSession().createQuery("from Users where uslogin = :uslogin");
		query.setParameter("uslogin", login);
		query.setResultTransformer(new AliasToBeanResultTransformer(Users.class));
		return (Users)query.list().get(0);
	}

    
}
