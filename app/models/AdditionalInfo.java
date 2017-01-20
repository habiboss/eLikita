package models;

import play.db.jpa.JPA;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "additional_info")
public class AdditionalInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "criminal_conviction")
	private String criminalConviction;
	@Column(name = "bring_partner")
	private String bring_partner;
	@Column(name = "disability")
	private String disability;
	@Column(name = "ethnicity")
	private String etchnicity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCriminalConviction() {
		return criminalConviction;
	}

	public void setCriminalConviction(String criminalConviction) {
		this.criminalConviction = criminalConviction;
	}

	public String getBring_partner() {
		return bring_partner;
	}

	public void setBring_partner(String bring_partner) {
		this.bring_partner = bring_partner;
	}

	public String getDisability() {
		return disability;
	}

	public void setDisability(String disability) {
		this.disability = disability;
	}

	public String getEtchnicity() {
		return etchnicity;
	}

	public void setEtchnicity(String etchnicity) {
		this.etchnicity = etchnicity;
	}

}
