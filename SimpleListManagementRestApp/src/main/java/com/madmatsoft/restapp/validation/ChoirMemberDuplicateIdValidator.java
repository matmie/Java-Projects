/**
 * 
 */
package com.madmatsoft.restapp.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.madmatsoft.restapp.model.ChoirMember;
import com.madmatsoft.restapp.model.service.ChoirMemberService;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 *
 */
@Component
public class ChoirMemberDuplicateIdValidator implements ConstraintValidator<ChoirMemberDuplicateId, Long>{
	@Autowired
	private ChoirMemberService choirMemberService;
	private ChoirMemberDuplicateId choirMemberId;
	@Override
	public void initialize(ChoirMemberDuplicateId constraintAnnotation) {
		this.choirMemberId = constraintAnnotation;
	}

	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		ChoirMember choirMember = null;
		try {
			choirMember = choirMemberService.read(value);
		} catch (IllegalArgumentException e) {
			return true;
		}
		if(choirMember != null){
			return false;
		}
		return true;
	}
}

