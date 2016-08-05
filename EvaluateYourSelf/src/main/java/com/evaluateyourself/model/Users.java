/**
 * 
 */
package com.evaluateyourself.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Mateusz
 *
 */
@Entity
/*uniqueConstraints= @UniqueConstraint(columnNames = {"uslogin"}) tak definiuje si� zesp� kolumn w encji, kt�ry ma byc unikalny dla ka�dego wiersza*/
@Table(name="users", schema="public", uniqueConstraints= @UniqueConstraint(columnNames = {"uslogin"}))
public class Users {
	
	@Id
	@Column(name="us_id", nullable=false, unique=true)
	@SequenceGenerator(name="Users_US_ID_seq") /*Tak ustala si� sekwencje kt�ra ma byc uzyta do generowania warto�ci klucza g��wnego(w tym przypadku)*/
	private int us_id;
	
	
	@Column(name="usfirstname", nullable=false, length=45)
	private String usFirstName;
	
	@Column(name="uslastname", nullable=false, length=45)
	private String uslastname; 
	
	@Column(name="usjoindate", nullable=false, insertable=false)
	private Date usjoindate = new Date();
	
}
