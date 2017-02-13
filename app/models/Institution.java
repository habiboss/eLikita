package models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "institution")
public class Institution {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "name")
	private String institutionName;
	@Column(name = "address")
	private String institutionAddress;
	@Column(name = "email")
	private String institutionEmail;
	@Column(name = "phone")
	private String institutionPhone;
	@Column(name = "mobile")
	private String institutionMobile;
	@Column(name = "fax")
	private String institutionFax;
	@Column(name = "website")
	private String institutionWebsite;
	@Column(name = "country")
	private String institutionCountry;
	@Column(name = "city")
	private String institutionCity;
	@Column(name = "currency")
	private String institutionCurrency;
	@Column(name = "Language")
	private String institutionLanguage;
	@Column(name = "code")
	private String institutionCode;
	@Column(name = "timeZone")
	private String institutionTimeZone;
	@Column(name = "region")
	private String institutionRegion;
	@Column(name = "postcode")
	private String institutionPostcode;
	@Column(name = "industry")
	private String industry;
	@Column(name = "status")
	private String status;
	@Column(name = "logo")
	private String institutionLogo;
	@Column(name = "created")
	private Date created;
	

}
