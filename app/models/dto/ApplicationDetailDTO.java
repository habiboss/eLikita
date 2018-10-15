package models.dto;

import java.sql.Timestamp;

public class ApplicationDetailDTO {

    private String    admissionOfficer;
    private String    code;
    private String    courseFk;
    private String    faculty;
    private Timestamp finishDate;
    private String    location_;
    private String    modeOfAttendance;
    private Timestamp startDate;
    private String    status;
    private Long      batchFk;
    private Long      id;
    private String    academicYear;
    
	public String getAdmissionOfficer() {
		return admissionOfficer;
	}
	public void setAdmissionOfficer(String admissionOfficer) {
		this.admissionOfficer = admissionOfficer;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCourseFk() {
		return courseFk;
	}
	public void setCourseFk(String courseFk) {
		this.courseFk = courseFk;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public Timestamp getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(Timestamp finishDate) {
		this.finishDate = finishDate;
	}
	public String getLocation_() {
		return location_;
	}
	public void setLocation_(String location_) {
		this.location_ = location_;
	}
	public String getModeOfAttendance() {
		return modeOfAttendance;
	}
	public void setModeOfAttendance(String modeOfAttendance) {
		this.modeOfAttendance = modeOfAttendance;
	}
	public Timestamp getStartDate() {
		return startDate;
	}
	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getBatchFk() {
		return batchFk;
	}
	public void setBatchFk(Long batchFk) {
		this.batchFk = batchFk;
	}
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
    
    
}
