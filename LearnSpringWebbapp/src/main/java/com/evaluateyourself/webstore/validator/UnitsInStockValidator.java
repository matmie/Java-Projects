/**
 * 
 */
package com.evaluateyourself.webstore.validator;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.evaluateyourself.webstore.domain.Product;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 *
 */
@Component
public class UnitsInStockValidator implements Validator {

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.isAssignableFrom(clazz);
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object target, Errors errors) {
		Product product = (Product) target;
		if( 
				(product.getUnitPrice()!= null) && 
				(new BigDecimal(10000).compareTo(product.getUnitPrice()) <= 0) &&
				(product.getUnitsInStock() > 99)
																				){
			errors.rejectValue("unitsInStock", "UnitsInStockValidator.product.unitsInStock.validation");
		}

	}

}
