package models;

import play.data.format.Formats;

import play.data.validation.Constraints;
import play.db.jpa.JPA;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "application_detail")
public class ApplicationDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "course_title")
	private String courseTitle;
	@Column(name = "app_code")
	private String code;
	@Column(name = "location_")
	private String location;
	@Column(name = "mode_of_attendance")
	private String modeAttendance;
	@Column(name = "faculty")
	private String faculty;
	@Column(name = "start_date")
	private Date startDate;
	@Column(name = "finish_date")
	private Date finishDate;
	@Column(name = "status")
	private String status;
	@Column(name = "admission_officer")
	private String admissionOfficer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getModeAttendance() {
		return modeAttendance;
	}

	public void setModeAttendance(String modeAttendance) {
		this.modeAttendance = modeAttendance;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAdmissionOfficer() {
		return admissionOfficer;
	}

	public void setAdmissionOfficer(String admissionOfficer) {
		this.admissionOfficer = admissionOfficer;
	}

}
