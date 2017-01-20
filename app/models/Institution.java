package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import play.data.format.Formats;
import play.data.validation.Constraints;
import play.db.jpa.JPA;

@Entity
@Table(name = "institutionRegistration")
public class Institution {
	
	@Transient
	private String Querry_FindById = "SELECT institution FROM Institution institution WHERE institution.id = :id ORDER BY institution.id";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "phone")
	private String phone;
	@Column(name = "email")
	private String email;
	@Column(name = "business_name")
	private String businessName;
	@Column(name = "business_phone")
	private String businessPhone;
	@Column(name = "business_email")
	private String businessEmail;
	@Column(name = "fax")
	private String fax;
	@Column(name = "business_website")
	private String businessWebsite;
	@Column(name = "ABN")
	private String ABN;
	@Column(name = "address")
	private String address;
	@Column(name = "country")
	private String country;
	@Column(name = "city")
	private String city;
	@Column(name = "state")
	private String state;
	@Column(name = "postcode")
	private String postcode;
	@Column(name = "business_size")
	private String businessSize;
	@Column(name = "current_advertisement")
	private String currentAdvertisement;
	@Column(name = "industry")
	private String industry;
	@Column(name = "status")
	private String status;
	@Column(name = "created")
	private Date created;
	
	public Institution findById(Long id) {
		try {
			return (Institution) JPA.em().createQuery(Querry_FindById).setParameter("id", id).getSingleResult();
		} catch (Exception e) {
			return null;
		}
		
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getBusinessPhone() {
		return businessPhone;
	}

	public void setBusinessPhone(String businessPhone) {
		this.businessPhone = businessPhone;
	}

	public String getBusinessEmail() {
		return businessEmail;
	}

	public void setBusinessEmail(String businessEmail) {
		this.businessEmail = businessEmail;
	}

	public String getBusinessWebsite() {
		return businessWebsite;
	}

	public void setBusinessWebsite(String businessWebsite) {
		this.businessWebsite = businessWebsite;
	}

	public String getABN() {
		return ABN;
	}

	public void setABN(String aBN) {
		ABN = aBN;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getBusinessSize() {
		return businessSize;
	}

	public void setBusinessSize(String businessSize) {
		this.businessSize = businessSize;
	}

	public String getCurrentAdvertisement() {
		return currentAdvertisement;
	}

	public void setCurrentAdvertisement(String currentAdvertisement) {
		this.currentAdvertisement = currentAdvertisement;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

}
