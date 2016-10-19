package com.evaluateyourself.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="languagescontrolls", schema="public")
public class LanguagesControlls {
	
	@Id
	@Column(name="lcid", nullable = false, unique = true) //TODO: Test the insertable, updatable behavior
	@GeneratedValue
	private Integer lcid;
	
	@Column(name="lcname", nullable = false, unique = true, length=200)
	private String lcname;
	
	@Column(name="lcpl", length=100)
	private String lcpl;
	
	@Column(name="lcen", length=100)
	private String lcen;
	
	@Column(name="lcfatherid", length=100)
	private String lcfatherid;
	
	@Column(name="lchaschild")
	private boolean lchaschild = false;

	public LanguagesControlls() {
		
	}

	public Integer getLcid() {
		return lcid;
	}

	public void setLcid(Integer lcid) {
		this.lcid = lcid;
	}

	public String getLcname() {
		return lcname;
	}

	public void setLcname(String lcname) {
		this.lcname = lcname;
	}

	public String getLcpl() {
		return lcpl;
	}

	public void setLcpl(String lcpl) {
		this.lcpl = lcpl;
	}

	public String getLcen() {
		return lcen;
	}

	public void setLcen(String lcen) {
		this.lcen = lcen;
	}

	public String getLcfatherid() {
		return lcfatherid;
	}

	public void setLcfatherid(String lcfatherid) {
		this.lcfatherid = lcfatherid;
	}

	public boolean isLchaschild() {
		return lchaschild;
	}

	public void setLchaschild(boolean lchaschild) {
		this.lchaschild = lchaschild;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lcid == null) ? 0 : lcid.hashCode());
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
		LanguagesControlls other = (LanguagesControlls) obj;
		if (lcid == null) {
			if (other.lcid != null)
				return false;
		} else if (!lcid.equals(other.lcid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LanguagesControlls [lcid=" + lcid + ", lcname=" + lcname + ", lcpl=" + lcpl + ", lcen=" + lcen
				+ ", lcfatherid=" + lcfatherid + ", lchaschild=" + lchaschild + "]";
	}
	
}
