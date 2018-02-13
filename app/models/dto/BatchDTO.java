package models.dto;

import java.sql.Timestamp;

public class BatchDTO {
    /////////////////Batch /////////////////
	private Long      id;
    private String    batchName;
    private Timestamp endDate;
    private Long      maxStudent;
    private Timestamp startDate;
    private Long      courseFk;
    /////////////////COURSE ////////////////
    private String courseTitle;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBatchName() {
		return batchName;
	}
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	public Timestamp getEndDate() {
		return endDate;
	}
	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}
	public Long getMaxStudent() {
		return maxStudent;
	}
	public void setMaxStudent(Long maxStudent) {
		this.maxStudent = maxStudent;
	}
	public Timestamp getStartDate() {
		return startDate;
	}
	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}
	public Long getCourseFk() {
		return courseFk;
	}
	public void setCourseFk(Long courseFk) {
		this.courseFk = courseFk;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
    
    
}
