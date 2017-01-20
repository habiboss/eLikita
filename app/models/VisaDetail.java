package models;

import play.data.format.Formats;
import play.data.validation.Constraints;
import play.db.jpa.JPA;

import javax.persistence.*;

import akka.dispatch.Foreach;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "visa_detail")
public class VisaDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	@Column(name = "visa_type")
	private String visaType;
	@Column(name = "start_date")
	private String startDate;
	@Column(name = "end_date")
	private String endDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="passport_fk")
	public PassportDetail passport_detail;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVisaType() {
		return visaType;
	}

	public void setVisaType(String visaType) {
		this.visaType = visaType;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public PassportDetail getPassport_detail() {
		return passport_detail;
	}

	public void setPassport_detail(PassportDetail passport_detail) {
		this.passport_detail = passport_detail;
	}
	
	

}
