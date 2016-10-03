/**
 * 
 */
package com.madmatsoft.restapp.model.repository.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.madmatsoft.restapp.model.ChoirMember;
import com.madmatsoft.restapp.model.repository.ChoirMemberRepository;

/**
 * @author Mateusz Miernik
 *
 */
@Repository
public class ChoirMemberRepositoryImpl implements ChoirMemberRepository {
	
	Logger logger = Logger.getLogger(ChoirMemberRepositoryImpl.class);

	private List<ChoirMember> choirMemberList = new ArrayList<ChoirMember>();
	
	public ChoirMemberRepositoryImpl(){
		
		ChoirMember chmem1 = new ChoirMember("Mateusz", "123234234");
		ChoirMember chmem2 = new ChoirMember("Piotr", "123456654");
		ChoirMember chmem3 = new ChoirMember("Błażej", "355456785");
		ChoirMember chmem4 = new ChoirMember("Ania", "355456785");
		
		choirMemberList.add(chmem1);
		choirMemberList.add(chmem2);
		choirMemberList.add(chmem3);
		choirMemberList.add(chmem4);
	}
	
	
	
	public long create(ChoirMember choirMember) {
		checkIdExists(choirMember.getChoirMemberId());
		choirMemberList.add(choirMember);
		return choirMember.getChoirMemberId();
	}


	public void update(long actualChoirMemberId, ChoirMember choirMember) {
		if(actualChoirMemberId != choirMember.getChoirMemberId()){
			checkIdExists(choirMember.getChoirMemberId());
		}
		for(Iterator<ChoirMember> iterator = choirMemberList.iterator();iterator.hasNext();){
			ChoirMember chmem = iterator.next();
			if(chmem.getChoirMemberId() == actualChoirMemberId){
				iterator.remove();
				break;
			}
		}
	    choirMemberList.add(choirMember);
	}

	public List<ChoirMember> getAll() {
		if(this.choirMemberList.size() > 0) {
			Collections.sort(this.choirMemberList, new Comparator<ChoirMember>() {
				public int compare(ChoirMember o1, ChoirMember o2) {
					return o1.getChoirMemberName().compareTo(o2.getChoirMemberName());
				}
			});
		}
		return this.choirMemberList;
	}


	public void delete(long choirMemberId) {
		boolean found = false;
		for(Iterator<ChoirMember> iterator = choirMemberList.iterator();iterator.hasNext();){
			ChoirMember chmem = iterator.next();
			if(chmem.getChoirMemberId() == choirMemberId){
				found = true;
				iterator.remove();
			}
		}
		if(!found){
			throw new IllegalArgumentException("There is no choir member with id = " + choirMemberId);
		}
	}
	public ChoirMember read(long choirMemberId) {
		ChoirMember chmem = null;
		for(Iterator<ChoirMember> iterator = choirMemberList.iterator();iterator.hasNext();){
			chmem = iterator.next();
			if(chmem.getChoirMemberId() == choirMemberId){
				break;
			}
		}
		if(chmem == null){
			throw new IllegalArgumentException("There is no choir member with id = " + choirMemberId);
		}
		return chmem;
	}
	
	private void checkIdExists(long choirMemberId){
		for(ChoirMember chmem: this.choirMemberList){
			if(chmem.getChoirMemberId() == choirMemberId){
				throw new IllegalArgumentException("There is choir member with id = " + choirMemberId);
			}
		}
	}

}
