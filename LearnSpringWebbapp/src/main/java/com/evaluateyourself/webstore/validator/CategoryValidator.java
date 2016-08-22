/**
 * 
 */
package com.evaluateyourself.webstore.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 *
 */
@Component
public class CategoryValidator implements ConstraintValidator<Category, String> {

	@Override
	public void initialize(Category constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(Category.allowedCategories.contains(value)){
			return true;
		}
		return false;
	}

}
