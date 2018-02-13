package services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.jooq.DSLContext;
import models.dto.AssignmentDTO;
import schemas.public_.tables.daos.AssignmentDao;
import schemas.public_.tables.pojos.Assignment;
import schemas.public_.tables.records.AssignmentRecord;
import services.referentiel.RClassTypeSvr;
 

public class AssignmentSvr extends AssignmentDao{
	@Inject
	DSLContext sqlContext;
	@Inject
	BatchSvr batchSvr;
	@Inject
	CourseSvr courseSvr;
	@Inject
	RClassTypeSvr rClassTypeSvr;
	@Inject
	AssignmentDTO assignmentDTO;
	
	@Inject
	public AssignmentSvr(DSLContext sqlContext) {
		super();
		this.setConfiguration(sqlContext.configuration());
	}
	
	public List<Assignment> findByAssignment(String q) {
		// TODO Auto-generated method stub
		List<Assignment> assignmentLst = new ArrayList<Assignment>();
		org.jooq.Result<AssignmentRecord> assignmentRecord = sqlContext
				.selectFrom(schemas.public_.tables.Assignment.ASSIGNMENT).where(schemas.public_.tables.Assignment.ASSIGNMENT.TITLE.like(q + "%"))
				.fetch();
		for (AssignmentRecord assignmentRecords : assignmentRecord) {
			Assignment assignment = new Assignment();
			assignment.setId(assignmentRecords.getId());
			assignment.setTitle(assignmentRecords.getTitle());
			assignmentLst.add(assignment);
		}
		return assignmentLst;
	}
	
	
	public void save(Assignment assignment) {
		// TODO Auto-generated method stub
		if (!fetchById(assignment.getId()).isEmpty()) {
			super.update(assignment);
		} else {
			super.insert(assignment);
		}
	}

	
	public void delete(Assignment assignment) {
		// TODO Auto-generated method stub
		try {
			this.deleteById(assignment.getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
 	
	public Boolean findByTitle(Long title) {
		return !fetchById(title).isEmpty();
	}
	
	public List<AssignmentDTO> assignmentDTOList () {
		List<Assignment> assignmentLst = findAll();
 		List<AssignmentDTO> assignmentDTOLst = new ArrayList<>();
 			for(Assignment assignment: assignmentLst) {
 				AssignmentDTO assignmentDTO = new AssignmentDTO();
 				assignmentDTO.setAssignment_courseFk(assignment.getCourseFk());
 				assignmentDTO.setAssignment_dateSubmission(assignment.getDateSubmission());
 				assignmentDTO.setAssignment_description(assignment.getDescription());
 				assignmentDTO.setAssignment_id(assignment.getId());;
 				assignmentDTO.setAssignment_title(assignment.getTitle());
 				assignmentDTO.setBatch_id(batchSvr.fetchOneById(assignment.getBatchFk()).getId());
  				assignmentDTO.setBatchFk(assignment.getBatchFk());
  				assignmentDTO.setBatchName(batchSvr.fetchOneById(assignment.getBatchFk()).getBatchName());
 				assignmentDTO.setCourse_code(courseSvr.fetchOneById(assignment.getCourseFk()).getCode());
 				assignmentDTO.setCourse_id(courseSvr.fetchOneById(assignment.getCourseFk()).getId());
 				assignmentDTO.setCourse_title(courseSvr.fetchOneById(assignment.getCourseFk()).getTitle());
 				assignmentDTO.setSubject_id(rClassTypeSvr.fetchOneById(assignment.getSubjectFk()).getId());
 				assignmentDTO.setSubject_name(rClassTypeSvr.fetchOneById(assignment.getSubjectFk()).getName());
  				assignmentDTOLst.add(assignmentDTO);
 			}
		return assignmentDTOLst;
	}
	
	public AssignmentDTO fetchOneAssignmentDTO (Long assignmentPK) {
		    assignmentDTO.setAssignment_courseFk(fetchOneById(assignmentPK).getCourseFk());
			assignmentDTO.setAssignment_dateSubmission(fetchOneById(assignmentPK).getDateSubmission());
			assignmentDTO.setAssignment_description(fetchOneById(assignmentPK).getDescription());
			assignmentDTO.setAssignment_id(fetchOneById(assignmentPK).getId());;
			assignmentDTO.setAssignment_title(fetchOneById(assignmentPK).getTitle());
			assignmentDTO.setBatch_id(batchSvr.fetchOneById(fetchOneById(assignmentPK).getBatchFk()).getId());
			assignmentDTO.setBatchFk(fetchOneById(assignmentPK).getBatchFk());
			assignmentDTO.setBatchName(batchSvr.fetchOneById(fetchOneById(assignmentPK).getBatchFk()).getBatchName());
			assignmentDTO.setCourse_code(courseSvr.fetchOneById(fetchOneById(assignmentPK).getCourseFk()).getCode());
			assignmentDTO.setCourse_id(courseSvr.fetchOneById(fetchOneById(assignmentPK).getCourseFk()).getId());
			assignmentDTO.setCourse_title(courseSvr.fetchOneById(fetchOneById(assignmentPK).getCourseFk()).getTitle());
			assignmentDTO.setSubject_id(rClassTypeSvr.fetchOneById(fetchOneById(assignmentPK).getSubjectFk()).getId());
			assignmentDTO.setSubject_name(rClassTypeSvr.fetchOneById(fetchOneById(assignmentPK).getSubjectFk()).getName());
	return assignmentDTO;
	}

	public models.util.Page<AssignmentDTO> pageAssignment(int page, int pageSize, String value) {
		int from_index = (page < 1 ? 0 : page - 1) * pageSize;
		final List<AssignmentDTO> assignment = assignmentDTOList().stream()
				.filter(c -> c.getAssignment_id().toString().contains(value) || c.getAssignment_title().contains(value))
				.collect(Collectors.toList());
		assignment.sort((o1, o2) -> (o1.getAssignment_id().compareTo(o2.getAssignment_id())));
		final List<AssignmentDTO> result = assignment.stream().skip(from_index).limit(pageSize)
				.collect(Collectors.toList());
		return new models.util.Page<AssignmentDTO>(result, assignment.size(), page, pageSize);
	}
}
