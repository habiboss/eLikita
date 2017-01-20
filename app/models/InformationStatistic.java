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
@Table(name = "information_statistic")
public class InformationStatistic {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "about_us")
	private String aboutUs;
	@Column(name = "other_about_us")
	private String otherAboutUs;
	@Column(name = "other_application")
	private Date otherApp;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAboutUs() {
		return aboutUs;
	}

	public void setAboutUs(String aboutUs) {
		this.aboutUs = aboutUs;
	}

	public String getOtherAboutUs() {
		return otherAboutUs;
	}

	public void setOtherAboutUs(String otherAboutUs) {
		this.otherAboutUs = otherAboutUs;
	}

	public Date getOtherApp() {
		return otherApp;
	}

	public void setOtherApp(Date otherApp) {
		this.otherApp = otherApp;
	}

}