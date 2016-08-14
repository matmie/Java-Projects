/**
 * 
 */
package com.evaluateyourself.webstore.domain.repository;

import java.util.List;

import com.evaluateyourself.webstore.domain.Customer;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 *
 */
public interface CustomerRepository {
	List<Customer> getAllCustomers();
}
