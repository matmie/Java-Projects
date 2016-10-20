package com.evaluateyourself.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="usersknowns", schema="public", uniqueConstraints= @UniqueConstraint(columnNames = {"ukfrom"}))
public class UsersKnowns implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ukis", nullable=false, updatable=false, unique=true)
	@GeneratedValue
	private Integer ukid;
	
	@Column(name="ukfrom", length=80)
	private String ukfrom;
	
	@Column(name="ukdisable")
	private boolean ukdisable;
	
	public UsersKnowns(){
		
	}
	
	public UsersKnowns(String ukfrom, boolean ukdisable) {
		this.ukfrom = ukfrom;
		this.ukdisable = ukdisable;
	}

	public Integer getUkid() {
		return ukid;
	}

	public void setUkid(Integer ukid) {
		this.ukid = ukid;
	}

	public String getUkfrom() {
		return ukfrom;
	}

	public void setUkfrom(String ukfrom) {
		this.ukfrom = ukfrom;
	}

	public boolean isUkdisable() {
		return ukdisable;
	}

	public void setUkdisable(boolean ukdisable) {
		this.ukdisable = ukdisable;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ukid == null) ? 0 : ukid.hashCode());
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
		UsersKnowns other = (UsersKnowns) obj;
		if (ukid == null) {
			if (other.ukid != null)
				return false;
		} else if (!ukid.equals(other.ukid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UsersKnowns [ukid=" + ukid + ", ukfrom=" + ukfrom + ", ukdisable=" + ukdisable + "]";
	}
	
}
