package models;

import play.data.format.Formats;
import play.data.validation.Constraints;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "address_detail")
public class AddressDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "postcode")
	private String postcode;
	@Column(name = "present_address")
	private String presentAddress;
	@Column(name = "permanent_address")
	private String permanentAddress;
	@Column(name = "country")
	private String country;
	@Column(name = "city")
	private String city;
	@Column(name = "region")
	private String region;
	@Formats.DateTime(pattern = "dd/MM/yyyy")
	@Column(name = "valid_until")
	private Date validUntil;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="student_fk")
	public Student student;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public Date getValidUntil() {
		return validUntil;
	}

	public void setValidUntil(Date validUntil) {
		this.validUntil = validUntil;
	}

	public String getPresentAddress() {
		return presentAddress;
	}

	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
