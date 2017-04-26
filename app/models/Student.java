package models;

import java.util.Date;
import play.data.format.Formats;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import play.data.validation.Constraints;
import interfaces.GenderCategory;

@Entity
@SequenceGenerator(name = "student_seq", sequenceName = "student_id_seq" )
@Table(name = "student_detail")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
	private Long id;
	@Constraints.Required
	@Column(name = "title")
	private String title;
	@Constraints.Required
	@Column(name = "first_name")
	private String firstName;
	@Constraints.Required
	@Column(name = "family_name")
	private String familyName;
	@Column(name = "middle_name")
	private String middleName;
	@Column(name = "prefered_name")
	private String preferedName;
	@Constraints.Required
	@Column(name = "gender")
	private GenderCategory gender;
	@Constraints.Required
	@Formats.DateTime(pattern = "dd/MM/yyyy")
	@Column(name = "date_of_birth")
	private Date dateOfBirth;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getPreferedName() {
		return preferedName;
	}
	public void setPreferedName(String preferedName) {
		this.preferedName = preferedName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public GenderCategory getGender() {
		return gender;
	}
	public void setGender(GenderCategory gender) {
		this.gender = gender;
	}
	
	
	
}
