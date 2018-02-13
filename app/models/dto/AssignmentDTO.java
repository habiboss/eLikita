package models.dto;

import java.sql.Timestamp;

public class AssignmentDTO {

	//////////////////Assignment ///////////////
	    private Long      assignment_id;
	    private String    assignment_title;
	    private String    assignment_description;
	    private Long      assignment_courseFk;
	    private Long      batchFk;
	    private Long      subjectFk;
	    private Timestamp assignment_dateSubmission;
	    
	//////////////////COURSE ///////////////
	    private String    course_code;
	    private String    course_title;
	    private Long      course_id;
	    
    //////////////BATCH /////////////////
	    private String    batchName;
	    private Long      batch_id;
	    
    ///////////////SUBJECT /////////////////
	    private Long    subject_id;
	    private String  subject_name;
	    
	    
		public Long getAssignment_id() {
			return assignment_id;
		}
		public void setAssignment_id(Long assignment_id) {
			this.assignment_id = assignment_id;
		}
		public String getAssignment_title() {
			return assignment_title;
		}
		public void setAssignment_title(String assignment_title) {
			this.assignment_title = assignment_title;
		}
		public String getAssignment_description() {
			return assignment_description;
		}
		public void setAssignment_description(String assignment_description) {
			this.assignment_description = assignment_description;
		}
		public Long getAssignment_courseFk() {
			return assignment_courseFk;
		}
		public void setAssignment_courseFk(Long assignment_courseFk) {
			this.assignment_courseFk = assignment_courseFk;
		}
		public Long getBatchFk() {
			return batchFk;
		}
		public void setBatchFk(Long batchFk) {
			this.batchFk = batchFk;
		}
		public Long getSubjectFk() {
			return subjectFk;
		}
		public void setSubjectFk(Long subjectFk) {
			this.subjectFk = subjectFk;
		}
		public Timestamp getAssignment_dateSubmission() {
			return assignment_dateSubmission;
		}
		public void setAssignment_dateSubmission(Timestamp assignment_dateSubmission) {
			this.assignment_dateSubmission = assignment_dateSubmission;
		}
		public String getCourse_code() {
			return course_code;
		}
		public void setCourse_code(String course_code) {
			this.course_code = course_code;
		}
		public String getCourse_title() {
			return course_title;
		}
		public void setCourse_title(String course_title) {
			this.course_title = course_title;
		}
		public Long getCourse_id() {
			return course_id;
		}
		public void setCourse_id(Long course_id) {
			this.course_id = course_id;
		}
		public String getBatchName() {
			return batchName;
		}
		public void setBatchName(String batchName) {
			this.batchName = batchName;
		}
		public Long getBatch_id() {
			return batch_id;
		}
		public void setBatch_id(Long batch_id) {
			this.batch_id = batch_id;
		}
		public Long getSubject_id() {
			return subject_id;
		}
		public void setSubject_id(Long subject_id) {
			this.subject_id = subject_id;
		}
		public String getSubject_name() {
			return subject_name;
		}
		public void setSubject_name(String subject_name) {
			this.subject_name = subject_name;
		}
	    
	    
}
