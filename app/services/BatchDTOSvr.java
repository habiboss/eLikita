package services;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.jooq.DSLContext;
import models.dto.BatchDTO;
import schemas.public_.tables.daos.BatchDao;
import schemas.public_.tables.pojos.Batch;

public class BatchDTOSvr extends BatchDao{
	@Inject
	DSLContext sqlContext;
	@Inject
	CourseSvr courseSvr;
	@Inject
	public BatchDTOSvr(DSLContext sqlContext) {
		super();
		this.setConfiguration(sqlContext.configuration());
	}
	
	public List<BatchDTO> batchDTOList () {
		List<Batch> batchLst = findAll();
 		List<BatchDTO> batchDTOLst = new ArrayList<>();
 			for(Batch batch: batchLst) {
 				BatchDTO batchDTO = new BatchDTO();
 				batchDTO.setId(batch.getId());
 				batchDTO.setBatchName(batch.getBatchName());
 				batchDTO.setCourseFk(batch.getCourseFk());
 				batchDTO.setCourseTitle(courseSvr.fetchOneById(batch.getCourseFk()).getTitle());
 				batchDTO.setEndDate(batch.getEndDate());
 				batchDTO.setMaxStudent(batch.getMaxStudent());
 				//courseDTO.setrAttendanceTypeDescription(rAttendanceTypeSvr.fetchOneById(course.getAttendanceTypeFk()).getDescription());
 				batchDTO.setStartDate(batch.getStartDate());
 				//courseDTO.setrSyllabusDescription(rSyllabusSvr.fetchOneById(course.getSyllabusFk()).getDescription());
 				batchDTOLst.add(batchDTO);
 			}
		return batchDTOLst;
	}
}
