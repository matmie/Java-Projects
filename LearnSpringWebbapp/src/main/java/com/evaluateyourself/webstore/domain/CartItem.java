/**
 * 
 */
package com.evaluateyourself.webstore.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 *
 */
public class CartItem implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5311740873879967592L;
	private Product product;
	private int quantity;
	private BigDecimal totalPrice;
	
	
	/**
	 * 
	 */
	public CartItem() {
		super();
		this.quantity = 1;
	}
	
	
	/**
	 * @param product
	 * @param quantity
	 * @param totalPrice
	 */
	public CartItem(Product product) {
		super();
		this.product = product;
		this.quantity = 1;
		this.totalPrice = product.getUnitPrice();
	}


	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}
	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
		this.updateTotalPrice();
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
		this.updateTotalPrice();
	}
	/**
	 * @return the totalPrice
	 */
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public void updateTotalPrice(){
		totalPrice = this.product.getUnitPrice().multiply(new BigDecimal(this.quantity));
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
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
		CartItem other = (CartItem) obj;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}
}
