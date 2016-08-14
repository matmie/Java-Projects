/**
 * 
 */
package com.evaluateyourself.webstore.service;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 *
 */
public interface OrderService {
	void processOrder(String productId, int count);
}
