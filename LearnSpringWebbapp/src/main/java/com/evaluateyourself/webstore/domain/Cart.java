package com.evaluateyourself.webstore.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class Cart implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4906431256432174911L;
	//Logger logger= Logger.getLogger(Cart.class);
	private String cartId;
	private Map<String, CartItem> cartItems;
	private BigDecimal grandTotal;
	
	
	/**
	 * 
	 */
	public Cart() {
		this.cartItems = new HashMap<String, CartItem>();
		this.grandTotal = new BigDecimal(0);
	}
	/**this.
	 * @param cartId
	 */
	public Cart(String cartId) {
		this.cartItems = new HashMap<String, CartItem>();
		this.grandTotal = new BigDecimal(0);
		this.cartId = cartId;
	}
	/**
	 * @return the cartId
	 */
	public String getCartId() {
		return cartId;
	}
	/**
	 * @param cartId the cartId to set
	 */
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	/**
	 * @return the cartItems
	 */
	public Map<String, CartItem> getCartItems() {
		return cartItems;
	}
	/**
	 * @param cartItems the cartItems to set
	 */
	public void setCartItems(Map<String, CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	/**
	 * @return the grandTotal
	 */
	public BigDecimal getGrandTotal() {
		return grandTotal;
	}
	/**
	 * @param grandTotal the grandTotal to set
	 */
	public void setGrandTotal(BigDecimal grandTotal) {
		this.grandTotal = grandTotal;
	}
	
	public void addCartItem(CartItem item){
		String productId = item.getProduct().getProductId();
		if(cartItems.containsKey(productId)){
			CartItem existingCartItem = cartItems.get(productId);
			existingCartItem.setQuantity(existingCartItem.getQuantity() + item.getQuantity());
			cartItems.put(productId, existingCartItem);
		}
		else
		{
			cartItems.put(productId, item);
		}
		updateGrandTotal();
	}
	public void removeCartItem(CartItem item){
		String productId = item.getProduct().getProductId();
		cartItems.remove(productId);
		updateGrandTotal();
	}
	
	public void updateGrandTotal() {
		grandTotal = new BigDecimal(0);
		for(CartItem item: cartItems.values()){
			grandTotal = grandTotal.add(item.getTotalPrice());
		}
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cartId == null) ? 0 : cartId.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if (cartId == null) {
			if (other.cartId != null)
				return false;
		} else if (!cartId.equals(other.cartId))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", cartItems=" + cartItems + ", grandTotal=" + grandTotal + "]";
	}
	
	
	
	
	
	
}
