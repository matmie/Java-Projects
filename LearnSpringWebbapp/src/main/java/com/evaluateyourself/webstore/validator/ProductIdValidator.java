/**
 * 
 */
package com.evaluateyourself.webstore.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.evaluateyourself.webstore.domain.Product;
import com.evaluateyourself.webstore.exception.ProductNotFoudException;
import com.evaluateyourself.webstore.service.ProductService;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 *
 */
@Component
public class ProductIdValidator implements ConstraintValidator<ProductId, String>{
	@Autowired
	private ProductService productService;
	private ProductId prodId;
	@Override
	public void initialize(ProductId constraintAnnotation) {
		this.prodId = constraintAnnotation;
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		Product product;
		try {
			product = productService.getProductById(value);
		} catch (ProductNotFoudException e) {
			return true;
		}
		if(product != null){
			return false;
		}
		return true;
	}
}
