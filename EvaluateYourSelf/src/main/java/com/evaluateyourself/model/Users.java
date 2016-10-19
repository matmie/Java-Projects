/**
 * 
 */
package com.evaluateyourself.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;


/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 * This class represents information about single user. 
 */
@Entity
@Table(name="users", schema="public", uniqueConstraints= @UniqueConstraint(columnNames = {"uslogin"}))
public class Users implements Serializable{
	
	private static final long serialVersionUID = -3041495761267330339L;
	
	/**
	 * User Id property represents primary key in database.
	 */
	@Id
	@Column(name="usid", nullable=false, unique=true)
	@GeneratedValue
	private int usid;

	/**
	 * User first name.
	 */
	@Column(name="usfirstname", nullable=true, length=45)
	private String usfirstname;
	
	/**
	 * User last name.
	 */
	@Column(name="uslastname", nullable=true, length=45)
	private String uslastname; 
	
	/**
	 * Specify date, when user joined to the community. Set current date as default  
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="usjoindate", insertable=false, updatable=false)
	private Date usjoindate;
	
	/**
	 * User login to system.
	 */
	@Column(name="uslogin", nullable=false, length=40, insertable=true, updatable=false)
	private String uslogin;
	
	/**
	 * User email address.
	 */
	@Column(name="usemail", nullable=false, length=60, insertable=true, updatable=true)
	private String usemail;
	
	/**
	 * User encrypted password by crypt algorithm.  
	 */
	@Column(name="uspassword", nullable=false, length=500, insertable=true, updatable=false)
	private String uspassword;
	
	/**
	 * Collection rows of {@link com.evaluateyourself.model.UsersGroups UsersGroups}
	 */
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy="ugusid")
	private Collection<UsersGroups> usersgroupscoll;
	
	/**
	 * Collection rows of {@link com.evaluateyourself.model.UsersInformations UsersInformations} 
	 */
	@OneToMany(cascade=CascadeType.REMOVE, mappedBy="uiusid")
	private Collection<UsersInformations> usersInfromationsColl;
	
    
	public Users(){
		
	}
	
	/**
	 * @param uslogin User login 
	 * @param usemail User email address
	 * @param uspassword User password
	 */
	public Users(String uslogin, String usemail, String uspassword) {
		super();
		this.uslogin = uslogin;
		this.usemail = usemail;
		this.uspassword = uspassword;
	}
	
	/**
	 * @return the usid
	 */
	public int getUsid() {
		return usid;
	}

	/**
	 * @param usid the usid to set
	 */
	public void setUsid(int usid) {
		this.usid = usid;
	}

	/**
	 * @return the usfirstname
	 */
	public String getUsfirstname() {
		return usfirstname;
	}

	/**
	 * @param usfirstname the usfirstname to set
	 */
	public void setUsfirstname(String usfirstname) {
		this.usfirstname = usfirstname;
	}

	/**
	 * @return the uslastname
	 */
	public String getUslastname() {
		return uslastname;
	}

	/**
	 * @param uslastname the uslastname to set
	 */
	public void setUslastname(String uslastname) {
		this.uslastname = uslastname;
	}

	/**
	 * @return the usjoindate
	 */
	public Date getUsjoindate() {
		return usjoindate;
	}

	/**
	 * @param usjoindate the usjoindate to set
	 */
	public void setUsjoindate(Date usjoindate) {
		this.usjoindate = usjoindate;
	}

	/**
	 * @return the uslogin
	 */
	public String getUslogin() {
		return uslogin;
	}

	/**
	 * @param uslogin the uslogin to set
	 */
	public void setUslogin(String uslogin) {
		this.uslogin = uslogin;
	}

	/**
	 * @return the usemail
	 */
	public String getUsemail() {
		return usemail;
	}

	/**
	 * @param usemail the usemail to set
	 */
	public void setUsemail(String usemail) {
		this.usemail = usemail;
	}

	/**
	 * @return the uspassword
	 */
	public String getUspassword() {
		return uspassword;
	}

	/**
	 * @param uspassword the uspassword to set
	 */
	public void setUspassword(String uspassword) {
		this.uspassword = uspassword;
	}

	/**
	 * @return the usersgroupscoll
	 */
	public Collection<UsersGroups> getUsersgroupscoll() {
		return usersgroupscoll;
	}

	/**
	 * @param usersgroupscoll the usersgroupscoll to set
	 */
	public void setUsersgroupscoll(Collection<UsersGroups> usersgroupscoll) {
		this.usersgroupscoll = usersgroupscoll;
	}

	/**
	 * @return the usersInfromationsColl
	 */
	public Collection<UsersInformations> getUsersInfromationsColl() {
		return usersInfromationsColl;
	}

	/**
	 * @param usersInfromationsColl the usersInfromationsColl to set
	 */
	public void setUsersInfromationsColl(Collection<UsersInformations> usersInfromationsColl) {
		this.usersInfromationsColl = usersInfromationsColl;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Users [usid=" + usid + ", usfirstname=" + usfirstname + ", uslastname=" + uslastname + ", usjoindate="
				+ usjoindate + ", uslogin=" + uslogin + ", usemail=" + usemail + ", uspassword=" + uspassword
				+ ", usersgroupscoll=" + usersgroupscoll + ", usersInfromationsColl=" + usersInfromationsColl + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((usemail == null) ? 0 : usemail.hashCode());
		result = prime * result + ((usersInfromationsColl == null) ? 0 : usersInfromationsColl.hashCode());
		result = prime * result + ((usersgroupscoll == null) ? 0 : usersgroupscoll.hashCode());
		result = prime * result + ((usfirstname == null) ? 0 : usfirstname.hashCode());
		result = prime * result + usid;
		result = prime * result + ((usjoindate == null) ? 0 : usjoindate.hashCode());
		result = prime * result + ((uslastname == null) ? 0 : uslastname.hashCode());
		result = prime * result + ((uslogin == null) ? 0 : uslogin.hashCode());
		result = prime * result + ((uspassword == null) ? 0 : uspassword.hashCode());
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
		Users other = (Users) obj;
		if (usemail == null) {
			if (other.usemail != null)
				return false;
		} else if (!usemail.equals(other.usemail))
			return false;
		if (usersInfromationsColl == null) {
			if (other.usersInfromationsColl != null)
				return false;
		} else if (!usersInfromationsColl.equals(other.usersInfromationsColl))
			return false;
		if (usersgroupscoll == null) {
			if (other.usersgroupscoll != null)
				return false;
		} else if (!usersgroupscoll.equals(other.usersgroupscoll))
			return false;
		if (usfirstname == null) {
			if (other.usfirstname != null)
				return false;
		} else if (!usfirstname.equals(other.usfirstname))
			return false;
		if (usid != other.usid)
			return false;
		if (usjoindate == null) {
			if (other.usjoindate != null)
				return false;
		} else if (!usjoindate.equals(other.usjoindate))
			return false;
		if (uslastname == null) {
			if (other.uslastname != null)
				return false;
		} else if (!uslastname.equals(other.uslastname))
			return false;
		if (uslogin == null) {
			if (other.uslogin != null)
				return false;
		} else if (!uslogin.equals(other.uslogin))
			return false;
		if (uspassword == null) {
			if (other.uspassword != null)
				return false;
		} else if (!uspassword.equals(other.uspassword))
			return false;
		return true;
	}
	
	
}
