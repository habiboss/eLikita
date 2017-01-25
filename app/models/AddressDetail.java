package models;

import play.data.format.Formats;
import play.data.validation.Constraints;
import play.db.jpa.JPA;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "address_detail")
public class AddressDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "postcode")
	private String postcode;
	@Column(name = "house_name_number")
	private String houseNameNumber;
	@Column(name = "address")
	private String address;
	@Column(name = "address_2")
	private String address_2;
	@Column(name = "address_3")
	private String address_3;
	@Column(name = "country")
	private String country;
	@Column(name = "city")
	private String city;
	@Column(name = "region")
	private String region;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress_2() {
		return address;
	}

	public void setAddress_2(String address) {
		this.address = address;
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

}
