/**
 * 
 */
package com.evaluateyourself.dao;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.evaluateyourself.model.Users;

/**
 * 1) Before Impl DAO clases must need to provide DAO Interface
 * 2) In DAO interface create signatures with model object
 * 3) In DAO implementation get Connection from connection pool
 */
/**
 * @author Mateusz
 *
 */
@Repository
@Transactional
public class UsersDAOImpl implements UsersDAO {
    
	@PersistenceContext
	public EntityManager manager;
	
	public LocalContainerEntityManagerFactoryBean entintyManagerFactory2;
	/**
	 * @param entintyManagerFactory the entintyManagerFactory to set
	 */
	public void setEntintyManagerFactory2(LocalContainerEntityManagerFactoryBean entintyManagerFactory2) {
		this.entintyManagerFactory2 = entintyManagerFactory2;
	}


	@Override
	public int save(Users user) {
		manager.persist(user);;
		manager.flush();
		return user.getUsid();
	}


	/* (non-Javadoc)
	 * @see com.evaluateyourself.dao.UsersDAO#findAll()
	 */
	@Override
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	/* (non-Javadoc)
	 * @see com.evaluateyourself.dao.UsersDAO#update(com.evaluateyourself.model.Users)
	 */
	@Override
	public boolean update(Users user) {
		// TODO Auto-generated method stub
		return false;
	}


	/* (non-Javadoc)
	 * @see com.evaluateyourself.dao.UsersDAO#delete(com.evaluateyourself.model.Users)
	 */
	@Override
	public boolean delete(Users user) {
		// TODO Auto-generated method stub
		return false;
	}


	/* (non-Javadoc)
	 * @see com.evaluateyourself.dao.UsersDAO#findByPk(int)
	 */
	@Override
	public Users findByPk(int pk) {
		// TODO Auto-generated method stub
		return null;
	}


	/* (non-Javadoc)
	 * @see com.evaluateyourself.dao.UsersDAO#findByLogin(java.lang.String)
	 */
	@Override
	public Users findByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}


	/* (non-Javadoc)
	 * @see com.evaluateyourself.dao.UsersDAO#findByLastName(java.lang.String)
	 */
	@Override
	public Collection<Users> findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}


	/* (non-Javadoc)
	 * @see com.evaluateyourself.dao.UsersDAO#getAllInfo()
	 */
	@Override
	public String getAllInfo() {
		String info = "";
		
		try {
			//manager = entintyManagerFactory2.getObject().createEntityManager();
			info = "fsfsfsd" + this.entintyManagerFactory2.getDataSource().getConnection().getSchema().trim();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println();
			e.printStackTrace();
		}
		return info;
	}
	
	
	

}
