/**
 * 
 */
package com.evaluateyourself.webstore.domain;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 *
 */
public class CartTest {
	
	private Cart cart;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		cart = new Cart("12345");
	}

	@Test
	public void grand_total_should_be_equals_all_summary_grands_from_cart_items() {
		
		CartItem itemcart = new CartItem(new Product("P1234","iphone",new BigDecimal(500)));
		itemcart.setQuantity(12);
		BigDecimal total = itemcart.getTotalPrice();
		cart.addCartItem(itemcart);
		
		Assert.assertEquals(cart.getGrandTotal(), total);
		
		CartItem cartitem2 = new CartItem(new Product("P3456","Laptop", new BigDecimal(12345)));
		total = total.add(cartitem2.getTotalPrice());
		
		cart.addCartItem(cartitem2);
		
		Assert.assertEquals(total, cart.getGrandTotal());
	}

}
