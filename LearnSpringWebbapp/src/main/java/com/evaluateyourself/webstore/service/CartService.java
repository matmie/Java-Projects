/**
 * 
 */
package com.evaluateyourself.webstore.service;

import com.evaluateyourself.webstore.domain.Cart;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 *
 */
public interface CartService {
	Cart create(Cart cart);
	void update(String cartId, Cart cart);
	Cart read(String cartId);
	void delete(String cartId);
	Cart validate(String cartId);
}
