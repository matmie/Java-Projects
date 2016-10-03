/**
 * 
 */
package com.madmatsoft.restapp.model.repository;

import java.util.List;
import java.util.Map;

import com.madmatsoft.restapp.model.ChoirMember;

/**
 * @author Mateusz Miernik
 *
 */
public interface ChoirMemberRepository {
	long create(ChoirMember choirMember);
	ChoirMember read(long choirMemberId);
	void update(long choirMemberId, ChoirMember choirMember);
	List<ChoirMember> getAll();
	void delete(long choirMemberId);
}
