/**
 * 
 */
package com.evaluateyourself.webstore.domain.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.evaluateyourself.webstore.domain.Customer;
import com.evaluateyourself.webstore.domain.repository.CustomerRepository;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 *
 */
@Repository
public class InMemoryCustomerRepository implements CustomerRepository {
    
	private List<Customer> customers = new ArrayList<Customer>();
	
	
	/**
	 * 
	 */
	public InMemoryCustomerRepository() {
		Customer mati = new Customer(1, "Mateusz Miernik");
		mati.setAddress("Wrocek Grecka 34");
		mati.setNoOfOrdersMade(false);
		
		Customer lukasz = new Customer(2, "Lukasz Czego Ty Szukasz");
		lukasz.setAddress("Aleksandrowo 1");
		lukasz.setNoOfOrdersMade(true);
		
		Customer sliwa = new Customer(3, "Sliwka wegierka");
		sliwa.setAddress("Drzewo po lewej");
		sliwa.setNoOfOrdersMade(false);
		
		customers.add(mati);
		customers.add(sliwa);
		customers.add(lukasz);
	}


	/* (non-Javadoc)
	 * @see com.evaluateyourself.webstore.domain.repository.CustomerRepository#getAllCustomers()
	 */
	public List<Customer> getAllCustomers() {
		return customers;
	}

}
