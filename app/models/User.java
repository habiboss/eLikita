package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "nom")
    private String nom;
	@Column(name = "status")
	private String status;
	@Column(name = "profil")
	private String profil;
    @Column(name = "who_done")
    private String whoDone;
    @Column(name = "when_delete")
    private Date whenDelete;
    @Column(name = "when_done")
    private Date whenDone;
    @Column(name = "when_update")
    private Date whenUpadate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getProfil() {
		return profil;
	}
	public void setProfil(String profil) {
		this.profil = profil;
	}
	public String getWhoDone() {
		return whoDone;
	}
	public void setWhoDone(String whoDone) {
		this.whoDone = whoDone;
	}
	public Date getWhenDelete() {
		return whenDelete;
	}
	public void setWhenDelete(Date whenDelete) {
		this.whenDelete = whenDelete;
	}
	public Date getWhenDone() {
		return whenDone;
	}
	public void setWhenDone(Date whenDone) {
		this.whenDone = whenDone;
	}
	public Date getWhenUpadate() {
		return whenUpadate;
	}
	public void setWhenUpadate(Date whenUpadate) {
		this.whenUpadate = whenUpadate;
	}
    
    

}
