package models;

import play.db.jpa.JPA;
import javax.persistence.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "equality_data")
public class EqualityData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "country_birth")
	private String countryBirth;
	@Column(name = "ethnic_origin")
	private String ethnicOrigin;
	@Column(name = "religion")
	private String religion;
	@Column(name = "sexual_orientation")
	private String sexualOrientation;
	@Column(name = "original_gender")
	private String originalGender;
	@Column(name = "learning_disabilities")
	private String learningDisabilities;
	@Column(name = "occupation")
	private String occupation;
	@Column(name = "socio_economic_classification")
	private String socioEconimicClassification;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountryBirth() {
		return countryBirth;
	}

	public void setCountryBirth(String countryBirth) {
		this.countryBirth = countryBirth;
	}

	public String getEthnicOrigin() {
		return ethnicOrigin;
	}

	public void setEthnicOrigin(String ethnicOrigin) {
		this.ethnicOrigin = ethnicOrigin;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getSexualOrientation() {
		return sexualOrientation;
	}

	public void setSexualOrientation(String sexualOrientation) {
		this.sexualOrientation = sexualOrientation;
	}

	public String getOriginalGender() {
		return originalGender;
	}

	public void setOriginalGender(String originalGender) {
		this.originalGender = originalGender;
	}

	public String getLearningDisabilities() {
		return learningDisabilities;
	}

	public void setLearningDisabilities(String learningDisabilities) {
		this.learningDisabilities = learningDisabilities;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getSocioEconimicClassification() {
		return socioEconimicClassification;
	}

	public void setSocioEconimicClassification(String socioEconimicClassification) {
		this.socioEconimicClassification = socioEconimicClassification;
	}

}
