/**
 * 
 */
package com.evaluateyourself.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 * Class represents information about type of information added by user(Skype, Mail, GG etc) 
 */
@Entity
@Table(name="usersinformationstypes", schema="public", uniqueConstraints=@UniqueConstraint(columnNames={"uitname"}))
public class UsersInformationsTypes implements Serializable {

	private static final long serialVersionUID = -42321453586030020L;
	
	/**
	 * UsersInformationsTypes primary key (id)
	 */
	@Id
	@Column(name="uitid", nullable=false, unique=true)
	@GeneratedValue
	private int uitid;
	
	/**
	 * Represents icon
	 */
	@Lob
	@Column(name="uiticon", nullable=true)
	private byte[] uiticon;
	
	/**
	 * Type of information name
	 */
	@Column(name="uitname", nullable=false)
	private String uitname;
    
	/**
	 * Collection of {@link com.evaluateyourself.model.UsersInformations UsersInformations} objects
	 */
	@OneToMany(cascade=CascadeType.REMOVE, mappedBy="uiuitid", targetEntity=com.evaluateyourself.model.UsersInformations.class)
	private Collection<UsersInformations> usersInformationColl;
	/**
	 * @param uitname Name of property
	 */
	public UsersInformationsTypes(String uitname) {
		super();
		this.uitname = uitname;
	}
	/**
	 * @param uiticon icon to set
	 * @param uitname information type name
	 */
	public UsersInformationsTypes(byte[] uiticon, String uitname) {
		super();
		this.uiticon = uiticon;
		this.uitname = uitname;
	}
	/**
	 * @return the uitid
	 */
	public int getUitid() {
		return uitid;
	}
	/**
	 * @param uitid the uitid to set
	 */
	public void setUitid(int uitid) {
		this.uitid = uitid;
	}
	/**
	 * @return the uiticon
	 */
	public byte[] getUiticon() {
		return uiticon;
	}
	/**
	 * @param uiticon the uiticon to set
	 */
	public void setUiticon(byte[] uiticon) {
		this.uiticon = uiticon;
	}
	/**
	 * @return the uitname
	 */
	public String getUitname() {
		return uitname;
	}
	/**
	 * @param uitname the uitname to set
	 */
	public void setUitname(String uitname) {
		this.uitname = uitname;
	}
	/**
	 * @return the usersInformationColl
	 */
	public Collection<UsersInformations> getUsersInformationColl() {
		return usersInformationColl;
	}
	/**
	 * @param usersInformationColl the usersInformationColl to set
	 */
	public void setUsersInformationColl(Collection<UsersInformations> usersInformationColl) {
		this.usersInformationColl = usersInformationColl;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UsersInformationsTypes [uitid=" + uitid + ", uiticon=" + Arrays.toString(uiticon) + ", uitname="
				+ uitname + ", usersInformationColl=" + usersInformationColl + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(uiticon);
		result = prime * result + uitid;
		result = prime * result + ((uitname == null) ? 0 : uitname.hashCode());
		result = prime * result + ((usersInformationColl == null) ? 0 : usersInformationColl.hashCode());
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
		UsersInformationsTypes other = (UsersInformationsTypes) obj;
		if (!Arrays.equals(uiticon, other.uiticon))
			return false;
		if (uitid != other.uitid)
			return false;
		if (uitname == null) {
			if (other.uitname != null)
				return false;
		} else if (!uitname.equals(other.uitname))
			return false;
		if (usersInformationColl == null) {
			if (other.usersInformationColl != null)
				return false;
		} else if (!usersInformationColl.equals(other.usersInformationColl))
			return false;
		return true;
	}
	
	
	
	
}
