/**
 * 
 */
package com.evaluateyourself.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluateyourself.webstore.domain.Customer;
import com.evaluateyourself.webstore.domain.repository.CustomerRepository;
import com.evaluateyourself.webstore.service.CustomerService;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	/* (non-Javadoc)
	 * @see com.evaluateyourself.webstore.service.CustomerService#getAllCustomers()
	 */
	public List<Customer> getAllCustomers() {
		return customerRepository.getAllCustomers();
	}

}
