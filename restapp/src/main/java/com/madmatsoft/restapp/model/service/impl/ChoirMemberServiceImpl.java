/**
 * 
 */
package com.madmatsoft.restapp.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madmatsoft.restapp.model.ChoirMember;
import com.madmatsoft.restapp.model.repository.ChoirMemberRepository;
import com.madmatsoft.restapp.model.service.ChoirMemberService;

/**
 * @author Mateusz Miernik
 *
 */
@Service
public class ChoirMemberServiceImpl implements ChoirMemberService {

	@Autowired
	private ChoirMemberRepository choirMemberRepository;
	
	public long create(ChoirMember choirMember) {
		return choirMemberRepository.create(choirMember);
	}

	
	public void update(long choirMemberId, ChoirMember choirMember) {
	     choirMemberRepository.update(choirMemberId, choirMember);
	}

	public List<ChoirMember> getAll() {
		return choirMemberRepository.getAll();
	}


	public void delete(long choirMemberId) {
		choirMemberRepository.delete(choirMemberId);
	}


	public ChoirMember read(long choirMemberId) {
		return choirMemberRepository.read(choirMemberId);
	}

}
