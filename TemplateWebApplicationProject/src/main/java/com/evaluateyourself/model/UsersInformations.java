/**
 * 
 */
package com.evaluateyourself.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 * Class represents table USERSINFORMATIONS which stores sets of expanded information about users as (UsersInformations_id ,User id, Information type id, Value) 
 */
@Entity
@Table(name="usersinformations", schema="public")
public class UsersInformations implements Serializable {

	private static final long serialVersionUID = -4840443530316383422L;
	/**
	 * UsersInformations private key (id)
	 */
	@Id
	@Column(name="uiid", nullable=false, unique=true)
	@SequenceGenerator(name="usersinformationsseq")
	private int uiid;
	
	/**
	 * Value of information
	 */
	@Column(name="uivalue", nullable=false, length=45)
	private String uivalue;
	
	/**
	 * User id from {@link com.evaluateyourself.model.Users Users}
	 */
	@ManyToOne(targetEntity=com.evaluateyourself.model.Users.class, optional=false)
	@JoinColumn(name="uiusid", referencedColumnName="usid", nullable=false)
	private Users uiusid;
	
	/**
	 * User information type from {@link com.evaluateyourself.model.UsersInformationsTypes UsersInformationsTypes}
	 */
	@ManyToOne(targetEntity=com.evaluateyourself.model.UsersInformationsTypes.class, optional=false)
	@JoinColumn(name="uiuitid", referencedColumnName="uitid", nullable=false)
	private UsersInformationsTypes uiuitid;

	/**
	 * @param uivalue information body
	 * @param uiusid user id from {@link com.evaluateyourself.model.Users Users}
	 * @param uiuitid information type id from {@link com.evaluateyourself.model.UsersInformationsTypes UsersInformationsTypes}
	 */
	public UsersInformations(String uivalue, Users uiusid, UsersInformationsTypes uiuitid) {
		super();
		this.uivalue = uivalue;
		this.uiusid = uiusid;
		this.uiuitid = uiuitid;
	}

	/**
	 * @return the uiid
	 */
	public int getUiid() {
		return uiid;
	}

	/**
	 * @param uiid the uiid to set
	 */
	public void setUiid(int uiid) {
		this.uiid = uiid;
	}

	/**
	 * @return the uivalue
	 */
	public String getUivalue() {
		return uivalue;
	}

	/**
	 * @param uivalue the uivalue to set
	 */
	public void setUivalue(String uivalue) {
		this.uivalue = uivalue;
	}

	/**
	 * @return the uiusid
	 */
	public Users getUiusid() {
		return uiusid;
	}

	/**
	 * @param uiusid the uiusid to set
	 */
	public void setUiusid(Users uiusid) {
		this.uiusid = uiusid;
	}

	/**
	 * @return the uiuitid
	 */
	public UsersInformationsTypes getUiuitid() {
		return uiuitid;
	}

	/**
	 * @param uiuitid the uiuitid to set
	 */
	public void setUiuitid(UsersInformationsTypes uiuitid) {
		this.uiuitid = uiuitid;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UsersInformations [uiid=" + uiid + ", uivalue=" + uivalue + ", uiusid=" + uiusid + ", uiuitid="
				+ uiuitid + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + uiid;
		result = prime * result + ((uiuitid == null) ? 0 : uiuitid.hashCode());
		result = prime * result + ((uiusid == null) ? 0 : uiusid.hashCode());
		result = prime * result + ((uivalue == null) ? 0 : uivalue.hashCode());
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
		UsersInformations other = (UsersInformations) obj;
		if (uiid != other.uiid)
			return false;
		if (uiuitid == null) {
			if (other.uiuitid != null)
				return false;
		} else if (!uiuitid.equals(other.uiuitid))
			return false;
		if (uiusid == null) {
			if (other.uiusid != null)
				return false;
		} else if (!uiusid.equals(other.uiusid))
			return false;
		if (uivalue == null) {
			if (other.uivalue != null)
				return false;
		} else if (!uivalue.equals(other.uivalue))
			return false;
		return true;
	}
}
