package com.evaluateyourself.webstore.domain.repository;

import com.evaluateyourself.webstore.domain.Order;

public interface OrderRepository {
	Long saveOrder(Order order);
}
