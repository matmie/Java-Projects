/**
 * 
 */
package com.madmatsoft.restapp.validation;

import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;



/**
 * @author Mateusz Miernik
 *
 */
@Target({METHOD,FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = ChoirMemberDuplicateIdValidator.class)
@Documented
public @interface ChoirMemberDuplicateId {
	String message() default "{ChoirMember.choirMemberId.validation.ChoirMemberDuplicateId}";
	Class<?>[] groups() default {};
	public abstract Class<? extends Payload>[] payload() default {};
}
