/**
 * 
 */
package com.evaluateyourself.webstore.domain.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.evaluateyourself.webstore.domain.Address;
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
		mati.setBillingAddress(new Address("44","Lipowa","Warszawa","51-100"));
		mati.setNoOfOrdersMade(false);
		
		Customer lukasz = new Customer(2, "Lukasz Czego Ty Szukasz");
		lukasz.setBillingAddress(new Address("45","Lipowa","Warszawa","51-100"));
		lukasz.setNoOfOrdersMade(true);
		
		Customer sliwa = new Customer(3, "Sliwka wegierka");
		sliwa.setBillingAddress(new Address("46","Lipowa","Warszawa","51-100"));
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
