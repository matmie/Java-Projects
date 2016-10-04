/**
 * 
 */
package com.madmatsoft.restapp.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.madmatsoft.restapp.validation.ChoirMemberDuplicateId;

/**
 * @author Mateusz Miernik
 *
 */
public class ChoirMember {
	
	private static long counter = 0;
	
	@NotNull(message="{ChoirMember.choirMemberId.validation.NotNull}")
	//@ChoirMemberDuplicateId(message="{ChoirMember.choirMemberId.validation.ChoirMemberDuplicateId}")
	private long choirMemberId;
	
	@NotNull(message="{ChoirMember.choirMemberName.validation.NotNull}")
	@Size(min=2,max=50,message="{ChoirMember.choirMemberName.validation.Size}")
	private String choirMemberName;
	
	@Pattern(regexp="[0-9]+", message="{ChoirMember.choirMemberPhoneNumber.validation.Pattern}")
	@NotNull(message="{ChoirMember.choirMemberPhoneNumber.validation.NotNull}")
	private String choirMemberPhoneNumber;
	
	public void setNextId(){
		this.choirMemberId = ++counter;
	}
	
	public ChoirMember()
	{
		setNextId();
	}
	
	public ChoirMember(String choirMemberName, String choirMemberPhoneNumber) {
		super();
		setNextId();
		this.choirMemberName = choirMemberName;
		this.choirMemberPhoneNumber = choirMemberPhoneNumber;
	}

	public long getChoirMemberId() {
		return choirMemberId;
	}

	public void setChoirMemberId(long choirMemberId) {
		this.choirMemberId = choirMemberId;
	}

	public String getChoirMemberName() {
		return choirMemberName;
	}

	public void setChoirMemberName(String choirMemberName) {
		this.choirMemberName = choirMemberName;
	}

	public String getChoirMemberPhoneNumber() {
		return choirMemberPhoneNumber;
	}

	public void setChoirMemberPhoneNumber(String choirMemberPhoneNumber) {
		this.choirMemberPhoneNumber = choirMemberPhoneNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (choirMemberId ^ (choirMemberId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChoirMember other = (ChoirMember) obj;
		if (choirMemberId != other.choirMemberId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ChoirMember [choirMemberId=" + choirMemberId + ", choirMemberName=" + choirMemberName
				+ ", choirMemberPhoneNumber=" + choirMemberPhoneNumber + "]";
	}
	
}
