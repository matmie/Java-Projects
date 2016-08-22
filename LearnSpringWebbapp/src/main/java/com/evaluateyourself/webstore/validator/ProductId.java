/**
 * 
 */
package com.evaluateyourself.webstore.validator;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import javax.validation.Constraint;
import javax.validation.Payload;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 *
 */
@Target({METHOD,FIELD,ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = ProductIdValidator.class)//Wskazujemy która klasa dokonuje walidacji
@Documented
public @interface ProductId {
	String message() default "{com.evaluateyourserf.webstore.validator.ProductId.message}";
	Class<?>[] groups() default {};
	public abstract Class<? extends Payload>[] payload() default {};
}
