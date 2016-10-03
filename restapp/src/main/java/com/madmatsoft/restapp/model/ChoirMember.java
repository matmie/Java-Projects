/**
 * 
 */
package com.madmatsoft.restapp.model;

/**
 * @author Mateusz Miernik
 *
 */
public class ChoirMember {
	
	private long choirMemberId;
	
	private String choirMemberName;
	
	private String choirMemberPhoneNumber;
	
	public ChoirMember(long choirMemberId, String choirMemberName, String choirMemberPhoneNumber) {
		super();
		this.choirMemberId = choirMemberId;
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
