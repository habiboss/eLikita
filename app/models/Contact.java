package models;

import play.data.format.Formats;
import play.db.jpa.JPA;
import javax.persistence.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "contact_detail")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "primary_phoneNo")
	private Long primaryPhoneNo;
	@Column(name = "secondary_phoneNo")
	private Long secondaryPhoneNo;
	@Column(name = "skype_address")
	private String skypeAddress;
	@Column(name = "email")
	private String email;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="student_fk")
	public Student student;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPrimaryPhoneNo() {
		return primaryPhoneNo;
	}

	public void setPrimaryPhoneNo(Long primaryPhoneNo) {
		this.primaryPhoneNo = primaryPhoneNo;
	}

	public Long getSecondaryPhoneNo() {
		return secondaryPhoneNo;
	}

	public void setSecondaryPhoneNo(Long secondaryPhoneNo) {
		this.secondaryPhoneNo = secondaryPhoneNo;
	}

	public String getSkypeAddress() {
		return skypeAddress;
	}

	public void setSkypeAddress(String skypeAddress) {
		this.skypeAddress = skypeAddress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}