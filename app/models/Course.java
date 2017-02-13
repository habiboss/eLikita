package models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "academic_year")
	private String academicYear;
	@Column(name = "title")
	private String courseTitle;
	@Column(name = "code")
	private String courseCode;
	@Column(name = "department")
	private String courseDepartment;
	@Column(name = "location")
	private String location;
	@Column(name = "year_of_study")
	private String yearOfStudy;
	@Column(name = "faculty")
	private String faculty;
	@Column(name = "mode_of_attendance")
	private String modeAttendance;
	@Column(name = "status")
	private String status;
	@Column(name = "start_date")
	private Date startDate;
	@Column(name = "tutor")
	private String tutor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseDepartment() {
		return courseDepartment;
	}

	public void setCourseDepartment(String courseDepartment) {
		this.courseDepartment = courseDepartment;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getYearOfStudy() {
		return yearOfStudy;
	}

	public void setYearOfStudy(String yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getModeAttendance() {
		return modeAttendance;
	}

	public void setModeAttendance(String modeAttendance) {
		this.modeAttendance = modeAttendance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getTutor() {
		return tutor;
	}

	public void setTutor(String tutor) {
		this.tutor = tutor;
	}

}
