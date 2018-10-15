package services.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.jooq.DSLContext;
import controllers.JourneeCtrl;
import models.dto.ApplicationDetailDTO;
import schemas.public_.Tables;
import schemas.public_.tables.daos.ApplicationDetailDao;
import schemas.public_.tables.pojos.ApplicationDetail;
import schemas.public_.tables.records.ApplicationDetailRecord;

public class ApplicationDetailSvr extends ApplicationDetailDao {
	@Inject
	DSLContext sqlContext;
	@Inject
	JourneeCtrl journeeCtrl;

	@Inject
	public ApplicationDetailSvr(DSLContext sqlContext) {
		super();
		this.setConfiguration(sqlContext.configuration());
	}

	public void save(ApplicationDetail applicationDetail) {
		// TODO Auto-generated method stub
		if (findByCode(applicationDetail.getCode())) {
			super.update(applicationDetail);
		} else {
			applicationDetail.setAdmissionOfficer(journeeCtrl.getUserConnected());
			super.insert(applicationDetail);
		}
	}

	public Boolean findByCode(String code) {
		return !fetchByCode(code).isEmpty();
	}

	public ApplicationDetailRecord findByApplicationCode(String code) {
		return sqlContext.fetchOne(Tables.APPLICATION_DETAIL, Tables.APPLICATION_DETAIL.CODE.equal(code));
	}

	public void approved(String uicode) {
		ApplicationDetail applicationDetail = fetchOneByCode(uicode);
		applicationDetail.setStatus("APPROVED");
		super.update(applicationDetail);
	}
	
	public List<ApplicationDetailDTO> approvedStudentInfoDTOLst () {
		List<ApplicationDetail> applicationDetailLst = sqlContext.selectFrom(Tables.APPLICATION_DETAIL).where(Tables.APPLICATION_DETAIL.STATUS.eq("APPROVE")).fetchInto(ApplicationDetail.class);
		List<ApplicationDetailDTO> applicationDetailDTOLst = new ArrayList<>();
		for(ApplicationDetail app: applicationDetailLst) {
			ApplicationDetailDTO applicationDetailDTO = new ApplicationDetailDTO();
			applicationDetailDTO.setId(app.getId());
			applicationDetailDTO.setAcademicYear(app.getAcademicYear());
			applicationDetailDTO.setAdmissionOfficer(app.getAdmissionOfficer());
			applicationDetailDTO.setCode(app.getCode());
			applicationDetailDTO.setBatchFk(app.getBatchFk());
			applicationDetailDTO.setCourseFk(app.getCourseFk());
			applicationDetailDTO.setFaculty(app.getFaculty());
			applicationDetailDTO.setFinishDate(app.getFinishDate());
			applicationDetailDTO.setId(app.getId());
			applicationDetailDTO.setLocation_(app.getLocation_());
			applicationDetailDTO.setModeOfAttendance(app.getModeOfAttendance());
			applicationDetailDTO.setStartDate(app.getStartDate());
			applicationDetailDTO.setStatus(app.getStatus());
			applicationDetailDTOLst.add(applicationDetailDTO);
		}
		return applicationDetailDTOLst;
	}
	
	public models.util.Page<ApplicationDetailDTO> pageApplicationDetail(int page, int pageSize, String value) {
		int from_index = (page < 1 ? 0 : page - 1) * pageSize;
		final List<ApplicationDetailDTO> studentDetail = approvedStudentInfoDTOLst().stream()
				.filter(c -> c.getId().toString().contains(value) || c.getAcademicYear().contains(value))
				.collect(Collectors.toList());
		studentDetail.sort((o1, o2) -> (o1.getId().compareTo(o2.getId())));
		final List<ApplicationDetailDTO> result = studentDetail.stream().skip(from_index).limit(pageSize)
				.collect(Collectors.toList());
		return new models.util.Page<ApplicationDetailDTO>(result, studentDetail.size(), page, pageSize);
	}
}
