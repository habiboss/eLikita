package models.referentiel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "r_profil")
public class RProfil {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    @Column(name = "code", nullable = false, unique = true, length = 2)
    private String codeProfil;
    @Column(name = "name", nullable = false, unique = true, length = 50)
    private String profilName;
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
	public String getCodeProfil() {
		return codeProfil;
	}
	public void setCodeProfil(String codeProfil) {
		this.codeProfil = codeProfil;
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
	public String getProfilName() {
		return profilName;
	}
	public void setProfilName(String profilName) {
		this.profilName = profilName;
	}
    
    
}
