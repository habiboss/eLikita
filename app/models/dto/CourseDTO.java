package models.dto;

public class CourseDTO {
	
	/////////COURSE/////////
    private String code;
    private String department;
    private String title;
    private String status;
    private Long   id;
    private String description;
    private Long   syllabusFk;
    private Long   attendanceTypeFk;
    private Long   minAttendancePercentage;
    private Long   totalWorkingDays;
    /////////R ATTENDANCE TYPE//////////
    private Long   rAttendanceTypeId;
    private String rAttendanceTypeName_;
    private String rAttendanceTypeDescription;
    /////////R SYLLABUS//////////
    private Long   rSyllabusId;
    private String rSyllabusName_;
    private String rSyllabusDescription;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getSyllabusFk() {
		return syllabusFk;
	}
	public void setSyllabusFk(Long syllabusFk) {
		this.syllabusFk = syllabusFk;
	}
	public Long getAttendanceTypeFk() {
		return attendanceTypeFk;
	}
	public void setAttendanceTypeFk(Long attendanceTypeFk) {
		this.attendanceTypeFk = attendanceTypeFk;
	}
	public Long getMinAttendancePercentage() {
		return minAttendancePercentage;
	}
	public void setMinAttendancePercentage(Long minAttendancePercentage) {
		this.minAttendancePercentage = minAttendancePercentage;
	}
	public Long getTotalWorkingDays() {
		return totalWorkingDays;
	}
	public void setTotalWorkingDays(Long totalWorkingDays) {
		this.totalWorkingDays = totalWorkingDays;
	}
	public Long getrAttendanceTypeId() {
		return rAttendanceTypeId;
	}
	public void setrAttendanceTypeId(Long rAttendanceTypeId) {
		this.rAttendanceTypeId = rAttendanceTypeId;
	}
	public String getrAttendanceTypeName_() {
		return rAttendanceTypeName_;
	}
	public void setrAttendanceTypeName_(String rAttendanceTypeName_) {
		this.rAttendanceTypeName_ = rAttendanceTypeName_;
	}
	public String getrAttendanceTypeDescription() {
		return rAttendanceTypeDescription;
	}
	public void setrAttendanceTypeDescription(String rAttendanceTypeDescription) {
		this.rAttendanceTypeDescription = rAttendanceTypeDescription;
	}
	public Long getrSyllabusId() {
		return rSyllabusId;
	}
	public void setrSyllabusId(Long rSyllabusId) {
		this.rSyllabusId = rSyllabusId;
	}
	public String getrSyllabusName_() {
		return rSyllabusName_;
	}
	public void setrSyllabusName_(String rSyllabusName_) {
		this.rSyllabusName_ = rSyllabusName_;
	}
	public String getrSyllabusDescription() {
		return rSyllabusDescription;
	}
	public void setrSyllabusDescription(String rSyllabusDescription) {
		this.rSyllabusDescription = rSyllabusDescription;
	}
    
}
