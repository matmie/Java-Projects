/**
 * 
 */
package com.evaluateyourself.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 */
@Entity
@Table(name="messagesresources", schema="public")
public class MessagesResources implements Serializable{
	
	
	private static final long serialVersionUID = 2751825859577807978L;
	@Id
	@Column(name="mrid", nullable=false, unique=true)
	@GeneratedValue
	private int mrid;
	
	
	@Column(name="mrcode", nullable=false, length=100)
	private String mrcode;
	
	@Column(name="pol", nullable=false, length=500)
	private String pol;

	/**
	 * @return the mrid
	 */
	public int getMrid() {
		return mrid;
	}

	/**
	 * @param mrid the mrid to set
	 */
	public void setMrid(int mrid) {
		this.mrid = mrid;
	}

	/**
	 * @return the mrcode
	 */
	public String getMrcode() {
		return mrcode;
	}

	/**
	 * @param mrcode the mrcode to set
	 */
	public void setMrcode(String mrcode) {
		this.mrcode = mrcode;
	}

	/**
	 * @return the pol
	 */
	public String getPol() {
		return pol;
	}

	/**
	 * @param pol the pol to set
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mrcode == null) ? 0 : mrcode.hashCode());
		result = prime * result + mrid;
		result = prime * result + ((pol == null) ? 0 : pol.hashCode());
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
		MessagesResources other = (MessagesResources) obj;
		if (mrcode == null) {
			if (other.mrcode != null)
				return false;
		} else if (!mrcode.equals(other.mrcode))
			return false;
		if (mrid != other.mrid)
			return false;
		if (pol == null) {
			if (other.pol != null)
				return false;
		} else if (!pol.equals(other.pol))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MessagesResources [mrid=" + mrid + ", mrcode=" + mrcode + ", pol=" + pol + "]";
	}
	
	
	
	
}
