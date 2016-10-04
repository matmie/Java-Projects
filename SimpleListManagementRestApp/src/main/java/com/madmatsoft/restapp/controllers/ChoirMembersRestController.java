/**
 * 
 */
package com.madmatsoft.restapp.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.madmatsoft.restapp.model.ChoirMember;
import com.madmatsoft.restapp.model.service.ChoirMemberService;
import com.madmatsoft.restapp.validation.ValidationError;
import com.madmatsoft.restapp.validation.ValidationErrorBuilder;

/**
 * @author Mateusz Miernik
 *
 */
@RestController
public class ChoirMembersRestController {
	
	@Autowired
	private ChoirMemberService choirMemberService;
	
	@RequestMapping(value="/membersList/getAll", method=RequestMethod.GET)
	public List<ChoirMember> getAll(){
		return choirMemberService.getAll();
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/membersList/add")
	public ChoirMember create(@Valid @RequestBody ChoirMember choirMember){
        //throw new IllegalArgumentException(choirMember.toString());
		return choirMemberService.read(choirMemberService.create(choirMember));
	}
	
	@RequestMapping(value="/membersList/update/{choirMemberId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void update(@PathVariable(value = "choirMemberId") long choirMemberId, @Valid @RequestBody ChoirMember choirMember){
		choirMemberService.update(choirMemberId, choirMember);
	}
	
	@RequestMapping(value = "/membersList/delete/{choirMemberId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(value = "choirMemberId") long choirMemberId) {
		choirMemberService.delete(choirMemberId);
	}
	
	@ExceptionHandler
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ValidationError handleException(MethodArgumentNotValidException exception){
		return createValidationError(exception);
	}
	
	private ValidationError createValidationError(MethodArgumentNotValidException exception){
		return ValidationErrorBuilder.fromBindingErrors(exception.getBindingResult());
	}
	
}
