/**
 * 
 */
package com.evaluateyourself.webstore.validator;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.evaluateyourself.webstore.domain.Product;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 *
 */
public class ProductValidator implements Validator {
	@Autowired
	private javax.validation.Validator beanValidator;
	
	
	private Set<Validator> springValidators;
	
	
	/**
	 * 
	 */
	public ProductValidator() {
		super();
		springValidators = new HashSet<Validator>();
	}
	

	/**
	 * @param springValidators the springValidators to set
	 */
	public void setSpringValidators(Set<Validator> springValidators) {
		this.springValidators = springValidators;
	}


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
		Set<ConstraintViolation<Object>> constraintViolations = beanValidator.validate(target);
		for(ConstraintViolation<Object> constraintViolation: constraintViolations){
			String propertyPath = constraintViolation.getPropertyPath().toString();
			String message = constraintViolation.getMessage();
			errors.rejectValue(propertyPath,"",message);
		}
		for(Validator validator : springValidators) {
			validator.validate(target, errors);
		}
	}

}
