/**
 * 
 */
package com.evaluateyourself.webstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluateyourself.webstore.domain.Order;
import com.evaluateyourself.webstore.domain.Product;
import com.evaluateyourself.webstore.domain.repository.OrderRepository;
import com.evaluateyourself.webstore.domain.repository.ProductRepository;
import com.evaluateyourself.webstore.service.CartService;
import com.evaluateyourself.webstore.service.OrderService;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 *
 */
@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private ProductRepository productRepository;
	/* (non-Javadoc)
	 * @see com.evaluateyourself.webstore.service.OrderService#processOrder(java.lang.String, int)
	 */
	public void processOrder(String productId, int count) {
		// TODO Auto-generated method stub
		Product productById = productRepository.getProductById(productId);
		if(productById.getUnitsInStock() < count) {
			throw new IllegalArgumentException("Zbyt ma³o towaru. Obecna liczba sztuk w magazynie: " + productById.getUnitsInStock());
		}
		productById.setUnitsInStock(productById.getUnitsInStock() - count);
	}
	
	public Long saveOrder(Order order) {
		Long orderId = orderRepository.saveOrder(order);
		cartService.delete(order.getCart().getCartId());
		return orderId;
	}

}
