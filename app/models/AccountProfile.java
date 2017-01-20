package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account_profile")
public class AccountProfile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "name")
	private String profileName;
	@Column(name = "code")
	private String codeProfile;
	@Column(name = "who_done")
    private String whoDone;
    @Column(name = "when_delete")
    private Date whenDelete;
    @Column(name = "when_done")
    private Date whenDone;
    @Column(name = "when_update")
    private Date whenUpadate;
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	public String getCodeProfile() {
		return codeProfile;
	}
	public void setCodeProfile(String codeProfile) {
		this.codeProfile = codeProfile;
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
