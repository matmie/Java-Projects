/**
 * 
 */
package com.evaluateyourself.webstore.validator;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Constraint;
import javax.validation.Payload;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 * 
 */
@Target({METHOD,FIELD,ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy=CategoryValidator.class)
@Documented
public @interface Category {
	List<String> allowedCategories = new ArrayList<String>(Arrays.asList("Laptop","Tablet", "Smart Phone"));
	String message() default "{Category.product.category.validation}";
	Class<?>[] groups() default {};
	public abstract Class<? extends Payload>[] payload() default {};
}
