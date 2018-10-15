package services;

import java.util.List;
import java.util.stream.Collectors;
import org.jooq.DSLContext;
import com.google.inject.Inject;
import models.dto.StudentInfoDTO;
import schemas.public_.*;
import schemas.public_.tables.pojos.StudentDetail;
import schemas.public_.tables.records.StudentDetailRecord;
import services.admin.AcademicYearSvr;
import services.admin.ApplicationDetailSvr;
import services.referentiel.RCountrySvr;

public class StudentSrv extends schemas.public_.tables.daos.StudentDetailDao {
	@Inject
	DSLContext sqlContext;
	@Inject
	AddressSvr addressSvr;
	@Inject
	ContactSvr contactSvr;
	@Inject
	EmergencyContactSvr emergencyContactSvr;
	@Inject
	AdditionalInfoSvr additionalInfoSvr;
	@Inject
	EducationalDetailSvr educationalDetailSvr;
	@Inject
	NationalityDetailSvr nationalityDetailSvr;
	@Inject
	AcademicYearSvr academicYearSvr;
	@Inject
	RCountrySvr rCountrySvr;
	@Inject
	ApplicationDetailSvr applicationDetailSvr;

	@Inject
	public StudentSrv(DSLContext sqlContext) {
		super();
		this.setConfiguration(sqlContext.configuration());
	}

	// @Override
	public Long save(StudentDetail studentDetail) {
		// TODO Auto-generated method stub
		if (findByTitle(studentDetail.getId())) {
			super.update(studentDetail);
		} else {
			studentDetail.setStatus("UNAPPROVED");
			super.insert(studentDetail);
		}
		// return studentDetail.getId();
		return null;
	}

	// @Override
	public void delete(StudentDetail studentDetail) {
		// TODO Auto-generated method stub
		try {
			this.deleteById(studentDetail.getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// @Override
	public List<StudentDetail> findList() {
		// TODO Auto-generated method stub
		try {
			return findAll();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public Boolean findByTitle(Long title) {
		return !fetchById(title).isEmpty();
	}

	public models.util.Page<StudentDetail> pageStudentDetail(int page, int pageSize, String value) {
		int from_index = (page < 1 ? 0 : page - 1) * pageSize;
		final List<StudentDetail> studentDetail = findAll().stream()
				.filter(c -> c.getId().toString().contains(value) || c.getFirstName().contains(value))
				.collect(Collectors.toList());
		studentDetail.sort((o1, o2) -> (o1.getId().compareTo(o2.getId())));
		final List<StudentDetail> result = studentDetail.stream().skip(from_index).limit(pageSize)
				.collect(Collectors.toList());
		return new models.util.Page<StudentDetail>(result, studentDetail.size(), page, pageSize);
	}

	public StudentDetailRecord findByCodeUI(String codeUI) {
		return sqlContext.fetchOne(Tables.STUDENT_DETAIL, Tables.STUDENT_DETAIL.CODE_UI.equal(codeUI));
	}

	public StudentInfoDTO studentInfo(String studentPk) {
		StudentInfoDTO studentInfoDTO = new StudentInfoDTO();
 		studentInfoDTO.setAddress(addressSvr.findByStudentFk(studentPk).getAddress());
		studentInfoDTO.setAddress_id(addressSvr.findByStudentFk(studentPk).getId());
		studentInfoDTO.setCity(addressSvr.findByStudentFk(studentPk).getCity());
		studentInfoDTO.setCountry(rCountrySvr.fetchOneById(addressSvr.findByStudentFk(studentPk).getCountryFk()).getName_());
		studentInfoDTO.setCountryFk(rCountrySvr.fetchOneById(addressSvr.findByStudentFk(studentPk).getCountryFk()).getId());
		studentInfoDTO.setCriminalConviction(additionalInfoSvr.findByStudentFk(studentPk).getCriminalConviction());
		studentInfoDTO.setDateOfBirth(findByCodeUI(studentPk).getDateOfBirth());
		studentInfoDTO.setDisability(additionalInfoSvr.findByStudentFk(studentPk).getDisability());
		studentInfoDTO.setEmail(contactSvr.findByStudentFk(studentPk).getEmail());
		studentInfoDTO.setEmergency_address(emergencyContactSvr.findByStudentFk(studentPk).getAddress());
		studentInfoDTO.setEmergency_email(emergencyContactSvr.findByStudentFk(studentPk).getEmail());
		studentInfoDTO.setEthnicity(additionalInfoSvr.findByStudentFk(studentPk).getEthnicity());
		studentInfoDTO.setExpiryDate(nationalityDetailSvr.findByStudentFk(studentPk).getExpiryDate());
		studentInfoDTO.setFamilyName(findByCodeUI(studentPk).getFamilyName());
		studentInfoDTO.setFullName(emergencyContactSvr.findByStudentFk(studentPk).getFullName());
		studentInfoDTO.setLastName(findByCodeUI(studentPk).getLastName());
		studentInfoDTO.setGender(findByCodeUI(studentPk).getGender());
		studentInfoDTO.setHomeNumber(addressSvr.findByStudentFk(studentPk).getHomeNumber());
		studentInfoDTO.setIdentificationTypeFk(nationalityDetailSvr.findByStudentFk(studentPk).getIdentificationTypeFk());
		// studentInfoDTO.setInstitutionName();
		studentInfoDTO.setIssueDate(nationalityDetailSvr.findByStudentFk(studentPk).getIssueDate());
		studentInfoDTO.setIssuePlace(nationalityDetailSvr.findByStudentFk(studentPk).getIssuePlace());
		studentInfoDTO.setLastName(findByCodeUI(studentPk).getLastName());
		studentInfoDTO.setMiddleName(findByCodeUI(studentPk).getMiddleName());
		studentInfoDTO.setMobile(emergencyContactSvr.findByStudentFk(studentPk).getMobile());
		// studentInfoDTO.setMotherTongueFk(motherTongueFk);
		// studentInfoDTO.setNationality_id(nationality_id);
		// studentInfoDTO.setNationalityFk(nationalityFk);
		studentInfoDTO.setPassportNo(nationalityDetailSvr.findByStudentFk(studentPk).getPassportNo());
		studentInfoDTO.setPermanentAddress(addressSvr.findByStudentFk(studentPk).getPermanentAddress());
		// studentInfoDTO.setPermanentResidenceFk(permanentAddress);
		studentInfoDTO.setPhone(emergencyContactSvr.findByStudentFk(studentPk).getPhone());
		studentInfoDTO.setPostcode(addressSvr.findByStudentFk(studentPk).getPostcode());
		studentInfoDTO.setPreferedName(findByCodeUI(studentPk).getPreferedName());
		studentInfoDTO.setPresentAddress(addressSvr.findByStudentFk(studentPk).getPresentAddress());
		studentInfoDTO.setPrimaryNumber(addressSvr.findByStudentFk(studentPk).getPrimaryNumber());
		studentInfoDTO.setRegion(addressSvr.findByStudentFk(studentPk).getRegion());
		studentInfoDTO.setRelationship(emergencyContactSvr.findByStudentFk(studentPk).getRelationship());
		// studentInfoDTO.setReligionFk(religionFk);
		// studentInfoDTO.setResidentialStatusFk(residentialStatusFk);
		// studentInfoDTO.setStartDate(startDate);
		// studentInfoDTO.setStatus(status);
		studentInfoDTO.setStudent_id(findByCodeUI(studentPk).getId());
		studentInfoDTO.setStudentFk(findByCodeUI(studentPk).getCodeUi());
		// studentInfoDTO.setSubject(subject);
		studentInfoDTO.setTitle(findByCodeUI(studentPk).getTitle());
		// studentInfoDTO.setTitleOfQualification(titleOfQualification);
		// studentInfoDTO.setValidUntil(validUntil);
		studentInfoDTO.setAcademic_id(applicationDetailSvr.findByApplicationCode(studentPk).getId());
		studentInfoDTO.setCourseFk(applicationDetailSvr.findByApplicationCode(studentPk).getCourseFk());
		studentInfoDTO.setBatchFk(applicationDetailSvr.findByApplicationCode(studentPk).getBatchFk());
		studentInfoDTO.setApplication_status(applicationDetailSvr.findByApplicationCode(studentPk).getStatus());
		studentInfoDTO.setAcademicYear(applicationDetailSvr.findByApplicationCode(studentPk).getAcademicYear());
		studentInfoDTO.setCode(applicationDetailSvr.findByApplicationCode(studentPk).getCode());
 		// TODO: handle exception
 		return studentInfoDTO;
	}
}
