/**
 * 
 */
package com.evaluateyourself.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com] This entity represents
 *         informations about groups of users. Every user can be joined to many
 *         different groups.
 */
@Entity
@Table(name = "groups", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = { "grname" }))
public class Groups implements Serializable {

	private static final long serialVersionUID = -780653927453257776L;

	@Id
	@Column(name = "grid", nullable = false, unique = true)
	@SequenceGenerator(name = "groupsgridseq")
	private int grid;

	@Column(name = "grname", length = 45, insertable = true, updatable = true, unique = true)
	private String name;

	/**
	 * To tabela USERSGROUPS zawiera pole uggrid które odnosi siê do pola grid w
	 * tej klasie, dlatego te¿ z poziomu tej klasy: 1) Nie tworzymy pola w bazie
	 * za pomoc¹ adnotacji JoinColumn bo mamy pole grid 2) Wiemy, ¿e je¿eli
	 * usuniemy grupê to nale¿y tak¿e usun¹c wszystkie wpisy z tabeli
	 * USERSGROUPS, do tego celu u¿ywamy mapowania mappedBy które wskazuje na
	 * zadeklarowane pole w bazie w tabeli USERSGROUPS oraz deklaracji cascade,
	 * która mówi w tym przpadku, o usuwaniu wszystkich powi¹zañ
	 */
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "uggrid")
	private Collection<UsersGroups> usersgroupscoll;
	
	/**
	 * @param name group name 
	 * @param usersgroupscoll collections of users join to this new group
	 */
	public Groups(String name, Collection<UsersGroups> usersgroupscoll) {
		super();
		this.name = name;
		this.usersgroupscoll = usersgroupscoll;
	}
    
	/**
	 * @param name group name
	 */
	public Groups(String name) {
		super();
		this.name = name;
	}

	/**
	 * @return the grid
	 */
	public int getGrid() {
		return grid;
	}

	/**
	 * @param grid the grid to set
	 */
	public void setGrid(int grid) {
		this.grid = grid;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Groups [grid=" + grid + ", name=" + name + ", usersgroupscoll=" + usersgroupscoll + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + grid;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((usersgroupscoll == null) ? 0 : usersgroupscoll.hashCode());
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
		Groups other = (Groups) obj;
		if (grid != other.grid)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (usersgroupscoll == null) {
			if (other.usersgroupscoll != null)
				return false;
		} else if (!usersgroupscoll.equals(other.usersgroupscoll))
			return false;
		return true;
	}

	

}
