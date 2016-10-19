/**
 * 
 */
package com.evaluateyourself.dao.hibernate;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.util.ReflectionUtils;

import com.evaluateyourself.dao.Dao;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 * Abstract class, which will be use as extends class for every specify Dao class
 */
public class AbstractHbnDao<T extends Object> implements Dao<T> {
	
	/**
	 * Session Factory from hibernate
	 */
	@Inject private SessionFactory sessionFactory;
	/**
	 * What class is used. Especially for CRUD methods.
	 */
	private Class<T> domainClass;
	
	/**
	 * Method returns current session
	 * @return current session
	 */
	protected Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	/**
	 * Method try to find which class is on the T generic parameter
	 * @return domain class which represents by T generic parameter 
	 */
	@SuppressWarnings("unchecked")
	private Class<T> getDomainClass(){
		if(domainClass == null){
			ParameterizedType thisType = (ParameterizedType) getClass().getGenericSuperclass();
			this.domainClass = (Class<T>) thisType.getActualTypeArguments()[0];
		}
		return domainClass;
	}
	/**
	 * Method returns domain class name
	 * @return Domain Class Name
	 */
	private String getDomainClassName(){
		return getDomainClass().getName();
	}
	@Override
	public T create(T t) {
		getCurrentSession().save(t);
		return t;
	}

	@Override
	@SuppressWarnings("unchecked")
	public T get(Serializable id) {
		return (T) getCurrentSession().get(getDomainClass(), id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public T load(Serializable id) {
		return (T) getCurrentSession().load(getDomainClass(), id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		return getCurrentSession().createQuery("from " + getDomainClassName()).list();
	}

	@Override
	public void update(T t) {
		getCurrentSession().update(t);
	}

	@Override
	public void delete(T t) {
		getCurrentSession().delete(t);
		
	}

	@Override
	public void deleteById(Serializable id) {
		getCurrentSession().delete(load(id));
	}

	@Override
	public void deleteAll() {
		getCurrentSession().createQuery("delete "+ getDomainClassName());
		
	}

	@Override
	public long count() {
		return (Long)getCurrentSession().createQuery("select count(*) from " + getDomainClassName()).uniqueResult();
	}

	@Override
	public boolean exist(Serializable id) {
		return (get(id) != null);
	}

}
