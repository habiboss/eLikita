package models;

import javax.persistence.*;

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
	
	@Column(name = "ermergency_name")
	private String ermergencyName;
	@Column(name = "ermergency_relation")
	private String ermergencyRelation;
	@Column(name = "ermergency_number")
	private String ermergencytNumber;
	@Column(name = "ermergency_address")
	private String ermergencyAddress;
	
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

	public String getErmergencyName() {
		return ermergencyName;
	}

	public void setErmergencyName(String ermergencyName) {
		this.ermergencyName = ermergencyName;
	}

	public String getErmergencyRelation() {
		return ermergencyRelation;
	}

	public void setErmergencyRelation(String ermergencyRelation) {
		this.ermergencyRelation = ermergencyRelation;
	}

	public String getErmergencytNumber() {
		return ermergencytNumber;
	}

	public void setErmergencytNumber(String ermergencytNumber) {
		this.ermergencytNumber = ermergencytNumber;
	}

	public String getErmergencyAddress() {
		return ermergencyAddress;
	}

	public void setErmergencyAddress(String ermergencyAddress) {
		this.ermergencyAddress = ermergencyAddress;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}