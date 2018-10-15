package services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.jooq.DSLContext;
import models.dto.AssignmentDTO;
import schemas.public_.tables.daos.AssignSubjectDao;
import schemas.public_.tables.pojos.AssignSubject;
import services.referentiel.RClassTypeSvr;

public class AssignSubjectSvr extends AssignSubjectDao{
	@Inject
	DSLContext sqlContext;
	@Inject
	BatchSvr batchSvr;
	@Inject
	CourseSvr courseSvr;
	@Inject
	RClassTypeSvr rClassTypeSvr;
	
	@Inject
	public AssignSubjectSvr(DSLContext sqlContext) {
		super();
		this.setConfiguration(sqlContext.configuration());
	}
	
/*	public List<AssignSubject> findByAssignSubject(String q) {
		// TODO Auto-generated method stub
		List<AssignSubject> assignSubjectLst = new ArrayList<AssignSubject>();
		org.jooq.Result<AssignSubjectRecord> AssignSubjectRecord = sqlContext
				.selectFrom(schemas.public_.tables.AssignSubject.ASSIGN_SUBJECT).where(schemas.public_.tables.AssignSubject.ASSIGN_SUBJECT.TITLE.like(q + "%"))
				.fetch();
		for (AssignSubjectRecord AssignSubjectRecords : AssignSubjectRecord) {
			AssignSubject AssignSubject = new AssignSubject();
			AssignSubject.setId(AssignSubjectRecords.getId());
			AssignSubject.setTitle(AssignSubjectRecords.getTitle());
			AssignSubjectLst.add(AssignSubject);
		}
		return AssignSubjectLst;
	}*/
	
	
	public void save(AssignSubject assignSubject) {
		// TODO Auto-generated method stub
		if (!fetchById(assignSubject.getId()).isEmpty()) {
			super.update(assignSubject);
		} else {
			super.insert(assignSubject);
		}
	}

	
	public void delete(AssignSubject assignSubject) {
		// TODO Auto-generated method stub
		try {
			this.deleteById(assignSubject.getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
 
	public List<AssignmentDTO> assignSubjectDTOList () {
		List<AssignSubject> assignSubjectLst = findAll();
 		List<AssignmentDTO> assignSubjectDTOLst = new ArrayList<>();
 			for(AssignSubject assignSubject: assignSubjectLst) {
 				AssignmentDTO assignSubjectDTO = new AssignmentDTO();
 				assignSubjectDTO.setAssignment_id(assignSubject.getId());
  				assignSubjectDTO.setAssignment_courseFk(assignSubject.getCourseFk());
  				assignSubjectDTO.setCourse_title(courseSvr.fetchOneById(assignSubject.getCourseFk()).getTitle());
 				assignSubjectDTO.setBatch_id(assignSubject.getBatchFk());
 				assignSubjectDTO.setBatchName(batchSvr.fetchOneById(assignSubject.getBatchFk()).getBatchName());
 				assignSubjectDTO.setSubject_id(assignSubject.getSubjectFk());
 				assignSubjectDTO.setSubject_name(rClassTypeSvr.fetchOneById(assignSubject.getSubjectFk()).getName());
 				assignSubjectDTOLst.add(assignSubjectDTO);
 			}
		return assignSubjectDTOLst;
	}
	
	public AssignmentDTO fetchOneAssignSubjectDTO (Long assignSubjectPK) {
		    AssignmentDTO assignSubjectDTO = new AssignmentDTO();
		    assignSubjectDTO.setAssignment_id(fetchOneById(assignSubjectPK).getId());
			assignSubjectDTO.setAssignment_courseFk(fetchOneById(assignSubjectPK).getCourseFk());
			assignSubjectDTO.setCourse_title(courseSvr.fetchOneById(fetchOneById(assignSubjectPK).getCourseFk()).getTitle());
			assignSubjectDTO.setBatch_id(fetchOneById(assignSubjectPK).getBatchFk());
			assignSubjectDTO.setBatchName(batchSvr.fetchOneById(fetchOneById(assignSubjectPK).getBatchFk()).getBatchName());
			assignSubjectDTO.setSubject_id(fetchOneById(assignSubjectPK).getSubjectFk());
			assignSubjectDTO.setSubject_name(rClassTypeSvr.fetchOneById(fetchOneById(assignSubjectPK).getSubjectFk()).getName());
	return assignSubjectDTO;
	}

	public models.util.Page<AssignmentDTO> pageAssignSubject(int page, int pageSize, String value) {
		int from_index = (page < 1 ? 0 : page - 1) * pageSize;
		final List<AssignmentDTO> AssignSubject = assignSubjectDTOList().stream()
				.filter(c -> c.getAssignment_id().toString().contains(value) || c.getBatchName().contains(value))
				.collect(Collectors.toList());
		AssignSubject.sort((o1, o2) -> (o1.getAssignment_id().compareTo(o2.getAssignment_id())));
		final List<AssignmentDTO> result = AssignSubject.stream().skip(from_index).limit(pageSize)
				.collect(Collectors.toList());
		return new models.util.Page<AssignmentDTO>(result, AssignSubject.size(), page, pageSize);
	}
	
	public List<AssignmentDTO> getSubjectByBatch(Long batchPK) {
 		List<AssignSubject> assignSubjectLst = sqlContext.selectFrom(schemas.public_.Tables.ASSIGN_SUBJECT).where(schemas.public_.Tables.ASSIGN_SUBJECT.BATCH_FK.eq(batchPK)).fetchInto(AssignSubject.class);
 		List<AssignmentDTO> assignSubjectDTOLst = new ArrayList<>();
 			for(AssignSubject assignSubject: assignSubjectLst) {
 				AssignmentDTO assignSubjectDTO = new AssignmentDTO();
 				assignSubjectDTO.setAssignment_id(assignSubject.getId());
  				assignSubjectDTO.setAssignment_courseFk(assignSubject.getCourseFk());
  				assignSubjectDTO.setCourse_title(courseSvr.fetchOneById(assignSubject.getCourseFk()).getTitle());
 				assignSubjectDTO.setBatch_id(assignSubject.getBatchFk());
 				assignSubjectDTO.setBatchName(batchSvr.fetchOneById(assignSubject.getBatchFk()).getBatchName());
 				assignSubjectDTO.setSubject_id(assignSubject.getSubjectFk());
 				assignSubjectDTO.setSubject_name(rClassTypeSvr.fetchOneById(assignSubject.getSubjectFk()).getName());
 				assignSubjectDTOLst.add(assignSubjectDTO);
 			}
		return assignSubjectDTOLst;
	}
}
