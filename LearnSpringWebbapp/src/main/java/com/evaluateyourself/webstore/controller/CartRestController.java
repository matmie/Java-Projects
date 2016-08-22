package com.evaluateyourself.webstore.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.evaluateyourself.webstore.domain.Cart;
import com.evaluateyourself.webstore.domain.CartItem;
import com.evaluateyourself.webstore.domain.Product;
import com.evaluateyourself.webstore.exception.ProductNotFoudException;
import com.evaluateyourself.webstore.service.CartService;
import com.evaluateyourself.webstore.service.ProductService;

@RestController
@RequestMapping(value = "rest/cart")
public class CartRestController {
    
	Logger logger = Logger.getLogger(CartRestController.class);
	@Autowired
	private CartService cartService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(method = RequestMethod.POST)
	public Cart create(@RequestBody Cart cart, HttpServletRequest request) {
		//cart.setCartId(request.getSession(true).getId());
		return cartService.create(cart);
	}

	@RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
	public Cart read(@PathVariable(value = "cartId") String cartId) {
		return cartService.read(cartId);
	}

	@RequestMapping(value = "/{cartId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void update(@PathVariable(value = "cartId") String cartId, @RequestBody Cart cart) {
		cartService.update(cartId, cart);
	}

	@RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(value = "cartId") String cartId) {
		cartService.delete(cartId);
	}
	
	@RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addItem(@PathVariable String productId, HttpServletRequest request) {
		
		String sessionId = request.getSession(true).getId();
		Cart cart = cartService.read(sessionId);
		if(cart == null) {
			cart = cartService.create(new Cart(sessionId));
		}
		Product product = productService.getProductById(productId);
		
		if(product == null) {
			throw new IllegalArgumentException(new ProductNotFoudException(productId));
		}
		cart.addCartItem(new CartItem(product));
		cartService.update(sessionId, cart);
	}
	
	@RequestMapping(value = "/remove/{productId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeItem(@PathVariable String productId, HttpServletRequest request) {
		
		String sessionId = request.getSession(true).getId();
		Cart cart = cartService.read(sessionId);
		if(cart== null) {
			cart = cartService.create(new Cart(sessionId));
		}
		
		Product product = productService.getProductById(productId);
		if(product == null) {
			throw new IllegalArgumentException(new ProductNotFoudException(productId));
		}
		
		cart.removeCartItem(new CartItem(product));
		
		cartService.update(sessionId, cart);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST,  reason="Niepoprawne ��danie, sprawd� przesy�ane dane.")
	public void handleClientErrors(Exception ex) { }

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason="Wewn�trzny b��d serwera")
	public void handleServerErrors(Exception ex) {	}
	
}	
	