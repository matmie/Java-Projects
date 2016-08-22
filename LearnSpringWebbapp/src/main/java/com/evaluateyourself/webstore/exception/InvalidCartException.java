/**
 * 
 */
package com.evaluateyourself.webstore.exception;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 *
 */
public class InvalidCartException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1039363122541427876L;
	
	private String cartId;

	/**
	 * @param cartId
	 */
	public InvalidCartException(String cartId) {
		super();
		this.cartId = cartId;
	}

	/**
	 * @return the cartId
	 */
	public String getCartId() {
		return cartId;
	}
	
	
}
