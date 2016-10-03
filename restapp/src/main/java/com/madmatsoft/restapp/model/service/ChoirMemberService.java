/**
 * 
 */
package com.madmatsoft.restapp.model.service;

import java.util.List;

import com.madmatsoft.restapp.model.ChoirMember;

/**
 * @author Mateusz Miernik
 *
 */
public interface ChoirMemberService {
	long create(ChoirMember choirMember);
	ChoirMember read(long choirMemberId);
	void update(long choirMemberId, ChoirMember choirMember);
	List<ChoirMember> getAll();
	void delete(long choirMemberId);
}
