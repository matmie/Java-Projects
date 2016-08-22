/**
 * 
 */
package com.evaluateyourself.webstore.domain;

import java.io.Serializable;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 *
 */
public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7489541596021655066L;
	private int customerId;
	private String name;
	private Address billingAddress;
	private String phoneNumber;
	private boolean noOfOrdersMade;
	
	
	
	/**
	 * 
	 */
	public Customer() {
		super();
	}
	/**
	 * @param customerId
	 * @param name
	 */
	public Customer(int customerId, String name) {
		super();
		this.customerId = customerId;
		this.name = name;
	}
	/**
	 * @param customerId
	 * @param name
	 * @param address
	 * @param noOfOrdersMade
	 */
	public Customer(int customerId, String name, Address address, boolean noOfOrdersMade) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.billingAddress = address;
		this.noOfOrdersMade = noOfOrdersMade;
	}
	
	
	
	/**
	 * @return the billingAddress
	 */
	public Address getBillingAddress() {
		return billingAddress;
	}
	/**
	 * @param billingAddress the billingAddress to set
	 */
	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the noOfOrdersMade
	 */
	public boolean isNoOfOrdersMade() {
		return noOfOrdersMade;
	}
	/**
	 * @param noOfOrdersMade the noOfOrdersMade to set
	 */
	public void setNoOfOrdersMade(boolean noOfOrdersMade) {
		this.noOfOrdersMade = noOfOrdersMade;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((billingAddress == null) ? 0 : billingAddress.hashCode());
		result = prime * result + customerId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (noOfOrdersMade ? 1231 : 1237);
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
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
		Customer other = (Customer) obj;
		if (billingAddress == null) {
			if (other.billingAddress != null)
				return false;
		} else if (!billingAddress.equals(other.billingAddress))
			return false;
		if (customerId != other.customerId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (noOfOrdersMade != other.noOfOrdersMade)
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", billingAddress=" + billingAddress
				+ ", phoneNumber=" + phoneNumber + ", noOfOrdersMade=" + noOfOrdersMade + "]";
	}
	
}
