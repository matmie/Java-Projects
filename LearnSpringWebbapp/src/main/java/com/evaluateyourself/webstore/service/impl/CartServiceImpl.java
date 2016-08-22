/**
 * 
 */
package com.evaluateyourself.webstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluateyourself.webstore.domain.Cart;
import com.evaluateyourself.webstore.domain.repository.CartRepository;
import com.evaluateyourself.webstore.exception.InvalidCartException;
import com.evaluateyourself.webstore.service.CartService;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 *
 */
@Service
public class CartServiceImpl implements CartService {
    @Autowired
	private CartRepository cartRepository;
	/* (non-Javadoc)
	 * @see com.evaluateyourself.webstore.service.CartService#create(com.evaluateyourself.webstore.domain.Cart)
	 */
	@Override
	public Cart create(Cart cart) {
		return cartRepository.create(cart);
	}

	/* (non-Javadoc)
	 * @see com.evaluateyourself.webstore.service.CartService#update(java.lang.String, com.evaluateyourself.webstore.domain.Cart)
	 */
	@Override
	public void update(String cartId, Cart cart) {
		cartRepository.update(cartId, cart);

	}

	/* (non-Javadoc)
	 * @see com.evaluateyourself.webstore.service.CartService#read(java.lang.String)
	 */
	@Override
	public Cart read(String cartId) {
		return cartRepository.read(cartId);
	}

	/* (non-Javadoc)
	 * @see com.evaluateyourself.webstore.service.CartService#delete(java.lang.String)
	 */
	@Override
	public void delete(String cartId) {
		cartRepository.delete(cartId);

	}

	@Override
	public Cart validate(String cartId) {
		Cart cart = cartRepository.read(cartId);
		if(cart == null || (cart.getCartItems().size() == 0)){
			throw new InvalidCartException(cartId);
		}
		return cart;
	}

}
