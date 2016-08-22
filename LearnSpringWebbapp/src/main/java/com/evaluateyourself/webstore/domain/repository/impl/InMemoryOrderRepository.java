/**
 * 
 */
package com.evaluateyourself.webstore.domain.repository.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.evaluateyourself.webstore.domain.Order;
import com.evaluateyourself.webstore.domain.repository.OrderRepository;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 *
 */
@Repository
public class InMemoryOrderRepository implements OrderRepository {
	
	private Map<Long,Order> listOfOrders;
	private long nextOrderId;
	
	
	
	/**
	 * 
	 */
	public InMemoryOrderRepository() {
		super();
		this.listOfOrders = new HashMap<Long, Order>();
		this.nextOrderId = 1000;
	}



	/* (non-Javadoc)
	 * @see com.evaluateyourself.webstore.domain.repository.OrderRepository#saveOrder(com.evaluateyourself.webstore.domain.Order)
	 */
	@Override
	public Long saveOrder(Order order) {
		order.setOrderId(getNextOrderId());
		listOfOrders.put(order.getOrderId(), order);
		return order.getOrderId();
	}
	
	private synchronized long getNextOrderId(){
		return nextOrderId++;
	}

}
