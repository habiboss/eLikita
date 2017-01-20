package models;

import play.db.jpa.JPA;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "nationality")
public class Nationality {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
	@OneToOne
	@JoinColumn(name = "student_fk")
	private StudentDetail studentDetail;
	@Column(name = "nationality")
	private String nationality;
	@Column(name = "second_nationality")
	private String secondNationality;
	@Column(name = "country_birth")
	private String countryBirth;

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getSecondNationality() {
		return secondNationality;
	}

	public void setSecondNationality(String secondNationality) {
		this.secondNationality = secondNationality;
	}

	public String getCountryBirth() {
		return countryBirth;
	}

	public void setCountryBirth(String countryBirth) {
		this.countryBirth = countryBirth;
	}

}