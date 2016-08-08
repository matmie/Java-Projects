/**
 * 
 */
package com.evaluateyourself.model;

import java.security.Timestamp;
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
/*uniqueConstraints= @UniqueConstraint(columnNames = {"uslogin"}) tak definiuje siê zespó³ kolumn w encji, który ma byc unikalny dla ka¿dego wiersza*/
@Table(name="users", schema="public", uniqueConstraints= @UniqueConstraint(columnNames = {"uslogin"}))
public class Users {
	
	public Users() {}
	
	public Users(String usfirstname, String uslastname, Date usjoindate, Date uscreatiotimestamp, String uslogin,
			String usemail, String uspassword) {
		super();
		this.usfirstname = usfirstname;
		this.uslastname = uslastname;
		this.usjoindate = usjoindate;
		this.uscreatiotimestamp = uscreatiotimestamp;
		this.uslogin = uslogin;
		this.usemail = usemail;
		this.uspassword = uspassword;
	}

	@Id
	@Column(name="us_id", nullable=false, unique=true)
	@SequenceGenerator(name="Users_US_ID_seq") /*Tak ustala siê sekwencje która ma byc uzyta do generowania wartoœci klucza g³ównego(w tym przypadku)*/
	private int us_id;
	
	
	@Column(name="usfirstname", nullable=false, length=45)
	private String usfirstname;
	
	@Column(name="uslastname", nullable=false, length=45)
	private String uslastname; 
	
	@Column(name="usjoindate", nullable=false, insertable=false, updatable=false)
	private Date usjoindate = new Date();
	
	@Column(name="uscreationtimestamp", nullable=false, insertable=false, updatable=false)
	private Date uscreatiotimestamp;
	
	@Column(name="uslogin", nullable=false, length=40, insertable=true, updatable=false)
	private String uslogin;
	
	@Column(name="usemail", nullable=true, length=60, insertable=true, updatable=false)
	private String usemail;
	

	public int getus_id() {
		return us_id;
	}

	public void setus_id(int us_id) {
		this.us_id = us_id;
	}

	public String getusfirstname() {
		return usfirstname;
	}

	public void setusfirstname(String usfirstname) {
		this.usfirstname = usfirstname;
	}

	public String getuslastname() {
		return uslastname;
	}

	public void setuslastname(String uslastname) {
		this.uslastname = uslastname;
	}

	public Date getusjoindate() {
		return usjoindate;
	}

	public void setusjoindate(Date usjoindate) {
		this.usjoindate = usjoindate;
	}

	public Date getuscreatiotimestamp() {
		return uscreatiotimestamp;
	}

	public void setuscreatiotimestamp(Date uscreatiotimestamp) {
		this.uscreatiotimestamp = uscreatiotimestamp;
	}

	public String getuslogin() {
		return uslogin;
	}

	public void setuslogin(String uslogin) {
		this.uslogin = uslogin;
	}

	public String getusemail() {
		return usemail;
	}

	public void setusemail(String usemail) {
		this.usemail = usemail;
	}

	public String getuspassword() {
		return uspassword;
	}

	public void setuspassword(String uspassword) {
		this.uspassword = uspassword;
	}

	@Column(name="uspassword", nullable=false, length=500, insertable=true, updatable=false)
	private String uspassword;
	
	@Override
    public String toString() {
        return "User [id=" + us_id + ", firstName=" + usfirstname
                + ", lastName=" + uslastname + ", email=" + usemail
                + ", login=" + uslogin + "]";
    }
	
}
