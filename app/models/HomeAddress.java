package models;

import play.db.jpa.JPA;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "home_address")
public class HomeAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "contact_address")
	private String contactAddress;
	@Column(name = "country")
	private String country;
	@Column(name = "city")
	private String city;
	@Column(name = "region")
	private String region;
	@Column(name = "postcode")
	private String postcode;
	@Column(name = "valid_until")
	private Date validUntil;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
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
