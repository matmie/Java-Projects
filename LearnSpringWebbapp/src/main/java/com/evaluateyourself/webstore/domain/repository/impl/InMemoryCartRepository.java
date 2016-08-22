/**
 * 
 */
package com.evaluateyourself.webstore.domain.repository.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.evaluateyourself.webstore.domain.Cart;
import com.evaluateyourself.webstore.domain.repository.CartRepository;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 *
 */
@Repository
public class InMemoryCartRepository implements CartRepository {
	
	private Map<String,Cart> listOfCarts;
	
	
	/**
	 * 
	 */
	public InMemoryCartRepository() {
		listOfCarts = new HashMap<String,Cart>();
	}

	/* (non-Javadoc)
	 * @see com.evaluateyourself.webstore.domain.repository.CartRepository#create(com.evaluateyourself.webstore.domain.Cart)
	 */
	@Override
	public Cart create(Cart cart) {
		if(listOfCarts.containsKey(cart.getCartId())){
			throw new IllegalArgumentException(String.format("Nie mo¿na utworzyc koszyka. Koszyk o wskaznym id(%s) ju¿ istnieje.", cart.getCartId()));
		}
		listOfCarts.put(cart.getCartId(), cart);
		return cart;
	}

	/* (non-Javadoc)
	 * @see com.evaluateyourself.webstore.domain.repository.CartRepository#update(java.lang.String, com.evaluateyourself.webstore.domain.Cart)
	 */
	@Override
	public void update(String cartId, Cart cart) {
		if(!listOfCarts.containsKey(cartId)){
			throw new IllegalArgumentException(String.format("Nie mo¿na zaktualizowac koszyka. Koszyk o wskaznym id(%s) nie istnieje.", cartId));
		}
		listOfCarts.put(cartId, cart);
	}

	/* (non-Javadoc)
	 * @see com.evaluateyourself.webstore.domain.repository.CartRepository#read(java.lang.String)
	 */
	@Override
	public Cart read(String cartId) {
		return this.listOfCarts.get(cartId);
	}

	/* (non-Javadoc)
	 * @see com.evaluateyourself.webstore.domain.repository.CartRepository#delete(java.lang.String)
	 */
	@Override
	public void delete(String cartId) {
		if(!listOfCarts.containsKey(cartId)){
			throw new IllegalArgumentException(String.format("Nie mo¿na usun¹c koszyka. Koszyk o wskaznym id(%s) nie istnieje.", cartId));
		}
		this.listOfCarts.remove(cartId);
	}

}
