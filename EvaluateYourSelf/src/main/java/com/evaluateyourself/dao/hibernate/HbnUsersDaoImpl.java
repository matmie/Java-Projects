/**
 * 
 */
package com.evaluateyourself.dao.hibernate;

import org.hibernate.Query;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.evaluateyourself.dao.UsersDao;
import com.evaluateyourself.model.Users;
import com.evaluateyourself.utils.DataFormatter;

/**
 * @author Mateusz
 */
@Repository
public class HbnUsersDaoImpl extends AbstractHbnDao<Users> implements UsersDao {

	@Override
	public Users findByEmail(String email) {
		Query query = super.getCurrentSession().createQuery("from Users where usemail = :usemail");
		query.setParameter("usemail", email);
		query.setResultTransformer(new AliasToBeanResultTransformer(Users.class));
		return (Users)query.list().get(0);
	}
    
}
