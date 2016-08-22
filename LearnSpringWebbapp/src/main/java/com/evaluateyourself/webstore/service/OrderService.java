/**
 * 
 */
package com.evaluateyourself.webstore.service;

import com.evaluateyourself.webstore.domain.Order;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 *
 */
public interface OrderService {
	void processOrder(String productId, int count);
	Long saveOrder(Order order);
}
