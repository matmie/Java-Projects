/**
 * 
 */
package com.evaluateyourself.webstore.domain;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 *
 */
public class Customer {
	private int customerId;
	private String name;
	private String address;
	private boolean noOfOrdersMade;
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
	public Customer(int customerId, String name, String address, boolean noOfOrdersMade) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.address = address;
		this.noOfOrdersMade = noOfOrdersMade;
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
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
		result = prime * result + customerId;
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
		if (customerId != other.customerId)
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + "]";
	}
}
