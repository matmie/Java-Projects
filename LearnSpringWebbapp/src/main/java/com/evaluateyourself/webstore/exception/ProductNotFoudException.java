package com.evaluateyourself.webstore.exception;

public class ProductNotFoudException extends RuntimeException{

	private static final long serialVersionUID = 7702892145874755764L;
	private String productId;
	
	
	/**
	 * @param productId
	 */
	public ProductNotFoudException(String productId) {
		super();
		this.productId = productId;
	}


	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}
	
	

}
