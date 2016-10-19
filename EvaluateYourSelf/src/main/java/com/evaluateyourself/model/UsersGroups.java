/**
 * 
 */
package com.evaluateyourself.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com] Class represents many
 *         to many connection between {@link com.evaluateyourself.model.Users
 *         Users} and {@link com.evaluateyourself.model.UsersGroups Groups}.
 */
@Entity
@Table(name = "usersgroups", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = { "ugusid",
		"uggrid" }))
public class UsersGroups implements Serializable {

	private static final long serialVersionUID = -8743117262911849944L;

	@Id
	@Column(name = "ugid", nullable = false, unique = false)
	@GeneratedValue
	private int ugid;
	

	@ManyToOne(targetEntity = com.evaluateyourself.model.Users.class, optional = false)
	@JoinColumn(name = "ugusid", referencedColumnName = "usid", nullable = false, insertable = true, updatable = true)
	private Users ugusid;
	
	/**
	 * Field represents foreign key to {@link com.evaluateyourself.model.Groups Groups} table
	 */
	@ManyToOne(targetEntity = com.evaluateyourself.model.Groups.class, optional = false)
	@JoinColumn(name = "uggrid", referencedColumnName = "grid", nullable = false, insertable = true, updatable = true)
	private Groups uggrid;
    
	/**
	 * 
	 * @param ugusid user id from {@link com.evaluateyourself.model.Users Users}
	 * @param uggrid user group from {@link com.evaluateyourself.model.Groups Groups}
	 */
	public UsersGroups(Users ugusid, Groups uggrid) {
		super();
		this.ugusid = ugusid;
		this.uggrid = uggrid;
	}

	/**
	 * @return the ugid
	 */
	public int getUgid() {
		return ugid;
	}

	/**
	 * @param ugid the ugid to set
	 */
	public void setUgid(int ugid) {
		this.ugid = ugid;
	}

	/**
	 * @return the ugusid
	 */
	public Users getUgusid() {
		return ugusid;
	}

	/**
	 * @param ugusid the ugusid to set
	 */
	public void setUgusid(Users ugusid) {
		this.ugusid = ugusid;
	}

	/**
	 * @return the uggrid
	 */
	public Groups getUggrid() {
		return uggrid;
	}

	/**
	 * @param uggrid the uggrid to set
	 */
	public void setUggrid(Groups uggrid) {
		this.uggrid = uggrid;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UsersGroups [ugid=" + ugid + ", ugusid=" + ugusid + ", uggrid=" + uggrid + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uggrid == null) ? 0 : uggrid.hashCode());
		result = prime * result + ugid;
		result = prime * result + ((ugusid == null) ? 0 : ugusid.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsersGroups other = (UsersGroups) obj;
		if (uggrid == null) {
			if (other.uggrid != null)
				return false;
		} else if (!uggrid.equals(other.uggrid))
			return false;
		if (ugid != other.ugid)
			return false;
		if (ugusid == null) {
			if (other.ugusid != null)
				return false;
		} else if (!ugusid.equals(other.ugusid))
			return false;
		return true;
	}
	
	

}
