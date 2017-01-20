package models;

import play.data.validation.Constraints;
import play.db.jpa.JPA;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "emergency_contact_detail")
public class EmergencyContactDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name")
	private String contactName;
	@Column(name = "phone_number")
	private String coontactNumber;
	@Column(name = "address")
	private String address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getCoontactNumber() {
		return coontactNumber;
	}

	public void setCoontactNumber(String coontactNumber) {
		this.coontactNumber = coontactNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
