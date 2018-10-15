package services.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.jooq.DSLContext;
import models.dto.AcademicYearDTO;
import schemas.administrator.tables.daos.AcademicYearDao;
import schemas.administrator.tables.pojos.AcademicYear;
import services.referentiel.RMonthSvr;
import services.referentiel.RStatusSvr;
import services.referentiel.RYearSvr;

public class AcademicYearSvr extends AcademicYearDao {
	@Inject
	DSLContext sqlContext;
	@Inject
	RYearSvr rYearSvr;
	@Inject
	RMonthSvr rMonthSvr;
	@Inject
	RStatusSvr rStatusSvr;

	@Inject
	public AcademicYearSvr(DSLContext sqlContext) {
		super();
		this.setConfiguration(sqlContext.configuration());
	}

	/*
	 * public List<AcademicYear> findByAcademicYear(String q) { // TODO
	 * Auto-generated method stub List<AcademicYear> academicYearLst = new
	 * ArrayList<AcademicYear>(); org.jooq.Result<AcademicYearRecord>
	 * academicYearRecord = sqlContext
	 * .selectFrom(Tables.ACADEMIC_YEAR).where(Tables.ACADEMIC_YEAR.BATCH_NAME.like(
	 * q + "%")) .fetch(); for (BatchRecord batchRecords : batchRecord) { Batch
	 * batch = new Batch(); batch.setId(batchRecords.getId());
	 * batch.setBatchName(batchRecords.getBatchName()); batchLst.add(batch); }
	 * return batchLst; }
	 */

	// @Override
	public void save(AcademicYear academicYear) {
		// TODO Auto-generated method stub
		if (!fetchById(academicYear.getId()).isEmpty()) {
			super.update(academicYear);
		} else {
			super.insert(academicYear);
		}
	}

	// @Override
	public void delete(AcademicYear academicYear) {
		// TODO Auto-generated method stub
		try {
			this.deleteById(academicYear.getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public models.util.Page<AcademicYearDTO> pageAcademicYear(int page, int pageSize, String value) {
		int from_index = (page < 1 ? 0 : page - 1) * pageSize;
		final List<AcademicYearDTO> academicYearDTO = academicYearDTOList().stream()
				.filter(c -> c.getId().toString().contains(value) || c.getStartMonthFk().contains(value))
				.collect(Collectors.toList());
		academicYearDTO.sort((o1, o2) -> (o1.getId().compareTo(o2.getId())));
		final List<AcademicYearDTO> result = academicYearDTO.stream().skip(from_index).limit(pageSize)
				.collect(Collectors.toList());
		return new models.util.Page<AcademicYearDTO>(result, academicYearDTO.size(), page, pageSize);
	}

	public List<AcademicYearDTO> academicYearDTOList() {
		List<AcademicYear> academicYearLst = findAll();
		List<AcademicYearDTO> academicYearDTOLst = new ArrayList<>();
		for (AcademicYear academicYear : academicYearLst) {
			AcademicYearDTO academicYearDTO = new AcademicYearDTO();
			academicYearDTO.setId(academicYear.getId());
			academicYearDTO.setStatusFk_id(rStatusSvr.fetchOneById(academicYear.getStatusFk()).getId());
			academicYearDTO.setStatusFk(rStatusSvr.fetchOneById(academicYear.getStatusFk()).getStatus());
			academicYearDTO.setEndMonthFk_id(rMonthSvr.fetchOneById(academicYear.getEndMonthFk()).getId());
			academicYearDTO.setEndMonthFk(rMonthSvr.fetchOneById(academicYear.getEndMonthFk()).getMonth_());
			academicYearDTO.setStartMonthFk_id(rMonthSvr.fetchOneById(academicYear.getStartMonthFk()).getId());
			academicYearDTO.setStartMonthFk(rMonthSvr.fetchOneById(academicYear.getStartMonthFk()).getMonth_());
			academicYearDTO.setEndYearFk_id(rYearSvr.fetchOneById(academicYear.getEndYearFk()).getId());
			academicYearDTO.setEndYearFk(rYearSvr.fetchOneById(academicYear.getEndYearFk()).getYear_());
			academicYearDTO.setStartYearFk_id(rYearSvr.fetchOneById(academicYear.getStartYearFk()).getId());
			academicYearDTO.setStartYearFk(rYearSvr.fetchOneById(academicYear.getStartYearFk()).getYear_());
			academicYearDTOLst.add(academicYearDTO);
		}
		return academicYearDTOLst;
	}

	public AcademicYearDTO fetchOneAcademicYearDTO(Long academicYearPK) {
		AcademicYearDTO academicYearDTO = new AcademicYearDTO();
		academicYearDTO.setId(fetchOneById(academicYearPK).getId());
		academicYearDTO.setStatusFk(rStatusSvr.fetchOneById(fetchOneById(academicYearPK).getStatusFk()).getStatus());
		academicYearDTO.setStatusFk_id(rStatusSvr.fetchOneById(fetchOneById(academicYearPK).getId()).getId());
		academicYearDTO.setEndMonthFk_id(rMonthSvr.fetchOneById(fetchOneById(academicYearPK).getId()).getId());
		academicYearDTO.setEndMonthFk(rMonthSvr.fetchOneById(fetchOneById(academicYearPK).getEndMonthFk()).getMonth_());
		academicYearDTO.setStartMonthFk_id(rMonthSvr.fetchOneById(fetchOneById(academicYearPK).getId()).getId());
		academicYearDTO.setStartMonthFk(rMonthSvr.fetchOneById(fetchOneById(academicYearPK).getStartMonthFk()).getMonth_());
		academicYearDTO.setEndYearFk_id(rYearSvr.fetchOneById(fetchOneById(academicYearPK).getId()).getId());
		academicYearDTO.setEndYearFk(rYearSvr.fetchOneById(fetchOneById(academicYearPK).getEndYearFk()).getYear_());
		academicYearDTO.setStartYearFk_id(rYearSvr.fetchOneById(fetchOneById(academicYearPK).getId()).getId());
		academicYearDTO.setStartYearFk(rYearSvr.fetchOneById(fetchOneById(academicYearPK).getStartYearFk()).getYear_());
		return academicYearDTO;
	}

}
