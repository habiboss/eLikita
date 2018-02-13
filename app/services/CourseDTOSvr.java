package services;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.jooq.DSLContext;
import models.dto.CourseDTO;
import schemas.public_.tables.daos.CourseDao;
import schemas.public_.tables.pojos.Course;
import services.referentiel.RAttendanceTypeSvr;
import services.referentiel.RSyllabusSvr;

public class CourseDTOSvr extends CourseDao{
	@Inject
	DSLContext sqlContext;
	@Inject
	public CourseDTOSvr(DSLContext sqlContext) {
		super();
		this.setConfiguration(sqlContext.configuration());
	}
	@Inject
	RAttendanceTypeSvr 	rAttendanceTypeSvr;
	@Inject
	RSyllabusSvr rSyllabusSvr;
	
	public List<CourseDTO> courseDTOList () {
		List<Course> courseLst = findAll();
 		List<CourseDTO> courseDTOLst = new ArrayList<>();
 			for(Course course: courseLst) {
 				CourseDTO courseDTO = new CourseDTO();
 				courseDTO.setId(course.getId());
 				courseDTO.setrAttendanceTypeName_(rAttendanceTypeSvr.fetchOneById(course.getAttendanceTypeFk()).getName_());
 				courseDTO.setCode(course.getCode());
 				courseDTO.setDepartment(course.getDepartment());
 				courseDTO.setDescription(course.getDescription());
 				courseDTO.setMinAttendancePercentage(course.getMinAttendancePercentage());
 				//courseDTO.setrAttendanceTypeDescription(rAttendanceTypeSvr.fetchOneById(course.getAttendanceTypeFk()).getDescription());
 				courseDTO.setrAttendanceTypeId(rAttendanceTypeSvr.fetchOneById(course.getAttendanceTypeFk()).getId());
 				//courseDTO.setrSyllabusDescription(rSyllabusSvr.fetchOneById(course.getSyllabusFk()).getDescription());
 				courseDTO.setrSyllabusId(rSyllabusSvr.fetchOneById(course.getSyllabusFk()).getId());
 				courseDTO.setrSyllabusName_(rSyllabusSvr.fetchOneById(course.getSyllabusFk()).getName_());
 				courseDTO.setStatus(course.getStatus());
 				courseDTO.setTitle(course.getTitle());
 				courseDTO.setTotalWorkingDays(course.getTotalWorkingDays());
 				courseDTOLst.add(courseDTO);
 			}
		return courseDTOLst;
	}
	
	/*	public CourseDTO fetchOneCourseDTO (Long coursePK) {
    CourseDTO courseDTO = new CourseDTO();
		courseDTO.setId(courseSvr.fetchOneById(coursePK).getId());
		courseDTO.setrAttendanceTypeName_(rAttendanceTypeSvr.fetchOneById(coursePK).getName_());
		courseDTO.setCode(courseSvr.fetchOneById(coursePK).getCode());
		courseDTO.setDepartment(courseSvr.fetchOneById(coursePK).getDepartment());
		courseDTO.setDescription(courseSvr.fetchOneById(coursePK).getDescription());
		courseDTO.setMinAttendancePercentage(coursePK);
		//courseDTO.setrAttendanceTypeDescription(rAttendanceTypeSvr.fetchOneById(course.getAttendanceTypeFk()).getDescription());
		courseDTO.setrAttendanceTypeId(rAttendanceTypeSvr.fetchOneById(coursePK).getId());
		//courseDTO.setrSyllabusDescription(rSyllabusSvr.fetchOneById(course.getSyllabusFk()).getDescription());
		courseDTO.setrSyllabusId(rSyllabusSvr.fetchOneById(coursePK).getId());
		courseDTO.setrSyllabusName_(rSyllabusSvr.fetchOneById(coursePK).getName_());
		courseDTO.setStatus(courseSvr.fetchOneById(coursePK).getStatus());
		courseDTO.setTitle(courseSvr.fetchOneById(coursePK).getTitle());
		courseDTO.setTotalWorkingDays(courseSvr.fetchOneById(coursePK).getTotalWorkingDays()); 		
return courseDTO;
}*/

	
}
