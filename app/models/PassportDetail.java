package models;

import play.db.jpa.JPA;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "passport_detail")
public class PassportDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
	@Column(name = "passport_number")
	private String passportNumber;
	@Column(name = "expiry_date")
	private Date expiryDate;
	@Column(name = "name_on_passport")
	private String nameOnPassport;
	@Column(name = "place_issue")
	private String placeOfIssue;
	@Column(name = "issue_date")
	private Date issueDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="nationality_fk")
	public Nationality nationality;

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaceOfIssue() {
		return placeOfIssue;
	}

	public void setPlaceOfIssue(String placeOfIssue) {
		this.placeOfIssue = placeOfIssue;
	}

	public Date getPassportExpiryDate() {
		return expiryDate;
	}

	public void setPassportExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getNameOnPassport() {
		return nameOnPassport;
	}

	public void setNameOnPassport(String nameOnPassport) {
		this.nameOnPassport = nameOnPassport;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	
	

}
