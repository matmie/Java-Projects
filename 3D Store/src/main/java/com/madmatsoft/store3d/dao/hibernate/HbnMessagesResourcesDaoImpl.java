/**
 * 
 */
package com.madmatsoft.store3d.dao.hibernate;

import java.util.Locale;

import javax.inject.Inject;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.madmatsoft.store3d.dao.MessagesResourcesDao;
import com.madmatsoft.store3d.exceptions.CannotFindMessagesResourcesObject;
import com.madmatsoft.store3d.model.MessagesResources;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 *
 */
@Repository
public class HbnMessagesResourcesDaoImpl implements MessagesResourcesDao {
	
	/**
	 * Session Factory from hibernate
	 */
	@Inject private SessionFactory sessionFactory;
	/**
	 * Method returns current session
	 * @return current session
	 */
	protected Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public MessagesResources getMessageForLocale(String code, Locale locale) {
		String sql = "from MessagesResources where mrcode =:mrcode";
		Query query = getCurrentSession().createQuery(sql);
		query.setParameter("mrcode", code);
		MessagesResources message = null;
		try{
			message = (MessagesResources)query.list().get(0);
		}catch(IndexOutOfBoundsException ex){
			throw new CannotFindMessagesResourcesObject("Cannot find value for '" + code +"' code for '"+ locale.getISO3Language() +"' column.");
		}
		if((message == null)){
			throw new NullPointerException("Cannot find representation of '"+ code +"' code for " + locale.getISO3Language() + " language.");
		}
		return message;
	}

}
