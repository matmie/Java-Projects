/**
 * 
 */
package com.evaluateyourself.webstore.domain;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 *
 */
public class CartItemTest {
	
	private CartItem cartItem;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		cartItem = new CartItem();
	}

	@Test
	public void cartItem_total_price_should_be_equal_to_product_unit_price_in_case_of_single_quantity() {
		Product iphone = new Product("P1234","iPhone 5s",new BigDecimal(500));
		cartItem.setProduct(iphone);
		BigDecimal totalPrice = cartItem.getTotalPrice();
		Assert.assertEquals(iphone.getUnitPrice(), totalPrice);
	}

}
