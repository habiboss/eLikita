package models.dto;

import java.sql.Timestamp;

public class StudentInfoDTO {
	////////// Application Info////////////
	private String admissionOfficer;
	private String code;
	private String courseFk;
	private String faculty;
	private Timestamp finishDate;
	private String location_;
	private String modeOfAttendance;
	private Timestamp application_startDate;
	private String application_status;
	private Long batchFk;
	private Long application_id;
	private String academicYear;
	////////// Personal Info////////////
	private Timestamp dateOfBirth;
	private String title;
	private String firstName;
	private String lastName;
	private Long student_id;
	private String gender;
	private String codeUi;
	private String status;
	private String middleName;
	private String preferedName;
	private String familyName;
	////////// Address Info////////////
	private String city;
	private String postcode;
	private String address;
	private String region;
	private Long address_id;
	private String studentFk;
	private String permanentAddress;
	private Long primaryNumber;
	private Long homeNumber;
	private String email;
	private Long countryFk;
	private String country;
	private String presentAddress;
	private Timestamp validUntil;
	////////// Academic Qualification Info////////////
	private Long academic_id;
	private String dateOfAward;
	private Timestamp endDate;
	private String institutionName;
	private String otherAchievement;
	private String titleOfQualification;
	private String result;
	private Timestamp startDate;
	private String subject;
	////////// Additional Info////////////
	private Long id;
	private Long disabilityFk;
	private Long ethnicityFk;
	private Long motherTongueFk;
	private Long religionFk;
	private String criminalConviction;
	private String bringPartner;
	private String disability;
	private String ethnicity;
	////////// Emergency Info////////////
	private Long phone;
	private Long mobile;
	private String emergency_email;
	private Long emergency_id;
	private String fullName;
	private String emergency_address;
	private String relationship;
	////////// Nationality Info////////////
	private Long nationality_id;
	private Long nationalityFk;
	private Long permanentResidenceFk;
	private Long residentialStatusFk;
	private String passportNo;
	private Timestamp issueDate;
	private Timestamp expiryDate;
	private String issuePlace;
	private String nameOnPassport;
	private Long identificationTypeFk;

	public Timestamp getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Timestamp dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getStudent_id() {
		return student_id;
	}

	public void setStudent_id(Long student_id) {
		this.student_id = student_id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCodeUi() {
		return codeUi;
	}

	public void setCodeUi(String codeUi) {
		this.codeUi = codeUi;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getPreferedName() {
		return preferedName;
	}

	public void setPreferedName(String preferedName) {
		this.preferedName = preferedName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Long getAddress_id() {
		return address_id;
	}

	public void setAddress_id(Long address_id) {
		this.address_id = address_id;
	}

	public String getStudentFk() {
		return studentFk;
	}

	public void setStudentFk(String studentFk) {
		this.studentFk = studentFk;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public Long getPrimaryNumber() {
		return primaryNumber;
	}

	public void setPrimaryNumber(Long primaryNumber) {
		this.primaryNumber = primaryNumber;
	}

	public Long getHomeNumber() {
		return homeNumber;
	}

	public void setHomeNumber(Long homeNumber) {
		this.homeNumber = homeNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getCountryFk() {
		return countryFk;
	}

	public void setCountryFk(Long countryFk) {
		this.countryFk = countryFk;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPresentAddress() {
		return presentAddress;
	}

	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}

	public Timestamp getValidUntil() {
		return validUntil;
	}

	public void setValidUntil(Timestamp validUntil) {
		this.validUntil = validUntil;
	}

	public Long getAcademic_id() {
		return academic_id;
	}

	public void setAcademic_id(Long academic_id) {
		this.academic_id = academic_id;
	}

	public String getDateOfAward() {
		return dateOfAward;
	}

	public void setDateOfAward(String dateOfAward) {
		this.dateOfAward = dateOfAward;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public String getOtherAchievement() {
		return otherAchievement;
	}

	public void setOtherAchievement(String otherAchievement) {
		this.otherAchievement = otherAchievement;
	}

	public String getTitleOfQualification() {
		return titleOfQualification;
	}

	public void setTitleOfQualification(String titleOfQualification) {
		this.titleOfQualification = titleOfQualification;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDisabilityFk() {
		return disabilityFk;
	}

	public void setDisabilityFk(Long disabilityFk) {
		this.disabilityFk = disabilityFk;
	}

	public Long getEthnicityFk() {
		return ethnicityFk;
	}

	public void setEthnicityFk(Long ethnicityFk) {
		this.ethnicityFk = ethnicityFk;
	}

	public Long getMotherTongueFk() {
		return motherTongueFk;
	}

	public void setMotherTongueFk(Long motherTongueFk) {
		this.motherTongueFk = motherTongueFk;
	}

	public Long getReligionFk() {
		return religionFk;
	}

	public void setReligionFk(Long religionFk) {
		this.religionFk = religionFk;
	}

	public String getCriminalConviction() {
		return criminalConviction;
	}

	public void setCriminalConviction(String criminalConviction) {
		this.criminalConviction = criminalConviction;
	}

	public String getBringPartner() {
		return bringPartner;
	}

	public void setBringPartner(String bringPartner) {
		this.bringPartner = bringPartner;
	}

	public String getDisability() {
		return disability;
	}

	public void setDisability(String disability) {
		this.disability = disability;
	}

	public String getEthnicity() {
		return ethnicity;
	}

	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getEmergency_email() {
		return emergency_email;
	}

	public void setEmergency_email(String emergency_email) {
		this.emergency_email = emergency_email;
	}

	public Long getEmergency_id() {
		return emergency_id;
	}

	public void setEmergency_id(Long emergency_id) {
		this.emergency_id = emergency_id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmergency_address() {
		return emergency_address;
	}

	public void setEmergency_address(String emergency_address) {
		this.emergency_address = emergency_address;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public Long getNationality_id() {
		return nationality_id;
	}

	public void setNationality_id(Long nationality_id) {
		this.nationality_id = nationality_id;
	}

	public Long getNationalityFk() {
		return nationalityFk;
	}

	public void setNationalityFk(Long nationalityFk) {
		this.nationalityFk = nationalityFk;
	}

	public Long getPermanentResidenceFk() {
		return permanentResidenceFk;
	}

	public void setPermanentResidenceFk(Long permanentResidenceFk) {
		this.permanentResidenceFk = permanentResidenceFk;
	}

	public Long getResidentialStatusFk() {
		return residentialStatusFk;
	}

	public void setResidentialStatusFk(Long residentialStatusFk) {
		this.residentialStatusFk = residentialStatusFk;
	}

	public String getPassportNo() {
		return passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	public Timestamp getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Timestamp issueDate) {
		this.issueDate = issueDate;
	}

	public Timestamp getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Timestamp expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getIssuePlace() {
		return issuePlace;
	}

	public void setIssuePlace(String issuePlace) {
		this.issuePlace = issuePlace;
	}

	public String getNameOnPassport() {
		return nameOnPassport;
	}

	public void setNameOnPassport(String nameOnPassport) {
		this.nameOnPassport = nameOnPassport;
	}

	public Long getIdentificationTypeFk() {
		return identificationTypeFk;
	}

	public void setIdentificationTypeFk(Long identificationTypeFk) {
		this.identificationTypeFk = identificationTypeFk;
	}

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

	public Timestamp getApplication_startDate() {
		return application_startDate;
	}

	public void setApplication_startDate(Timestamp application_startDate) {
		this.application_startDate = application_startDate;
	}

	public String getApplication_status() {
		return application_status;
	}

	public void setApplication_status(String application_status) {
		this.application_status = application_status;
	}

	public Long getBatchFk() {
		return batchFk;
	}

	public void setBatchFk(Long batchFk) {
		this.batchFk = batchFk;
	}

	public Long getApplication_id() {
		return application_id;
	}

	public void setApplication_id(Long application_id) {
		this.application_id = application_id;
	}

	public String getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}
}
