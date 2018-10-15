package services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.jooq.DSLContext;
import models.dto.CourseDTO;
import schemas.public_.tables.pojos.Course;
import schemas.public_.tables.records.CourseRecord;
import services.referentiel.RAttendanceTypeSvr;
import services.referentiel.RSyllabusSvr;
import schemas.public_.tables.daos.CourseDao;

public class CourseSvr extends CourseDao {
	
	@Inject
	DSLContext sqlContext;
	@Inject
	RAttendanceTypeSvr 	rAttendanceTypeSvr;
	@Inject
	RSyllabusSvr rSyllabusSvr;
	@Inject
	public CourseSvr(DSLContext sqlContext) {
		super();
		this.setConfiguration(sqlContext.configuration());
	}
	
	public List<Course> findByCourse(String q) {
		// TODO Auto-generated method stub
		List<Course> courseLst = new ArrayList<Course>();
		org.jooq.Result<CourseRecord> courseRecord = sqlContext
				.selectFrom(schemas.public_.tables.Course.COURSE).where(schemas.public_.tables.Course.COURSE.TITLE.like(q + "%"))
				.fetch();
		for (CourseRecord courseRecords : courseRecord) {
			Course course = new Course();
			course.setId(courseRecords.getId());
			course.setTitle(courseRecords.getTitle());
			courseLst.add(course);
		}
		return courseLst;
	}
	
	
	public void save(Course course) {
		// TODO Auto-generated method stub
		if (findByTitle(course.getId())) {
			super.update(course);
		} else {
			super.insert(course);
		}
	}

	
	public void delete(Course course) {
		// TODO Auto-generated method stub
		try {
			this.deleteById(course.getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	public List<Course> findList() {
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

	public models.util.Page<CourseDTO> pageCourse(int page, int pageSize, String value) {
		int from_index = (page < 1 ? 0 : page - 1) * pageSize;
		final List<CourseDTO> course = courseDTOList().stream()
				.filter(c -> c.getId().toString().contains(value) || c.getTitle().contains(value))
				.collect(Collectors.toList());
		course.sort((o1, o2) -> (o1.getId().compareTo(o2.getId())));
		final List<CourseDTO> result = course.stream().skip(from_index).limit(pageSize)
				.collect(Collectors.toList());
		return new models.util.Page<CourseDTO>(result, course.size(), page, pageSize);
	}
	
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
	
	public CourseDTO fetchOneCourseDTO(Long coursePK) {
		CourseDTO courseDTO = new CourseDTO();
		courseDTO.setId(fetchOneById(coursePK).getId());
		courseDTO.setrAttendanceTypeName_(rAttendanceTypeSvr.fetchOneById(fetchOneById(coursePK).getAttendanceTypeFk()).getName_());
		courseDTO.setCode(fetchOneById(coursePK).getCode());
		courseDTO.setDepartment(fetchOneById(coursePK).getDepartment());
		courseDTO.setDescription(fetchOneById(coursePK).getDescription());
		courseDTO.setMinAttendancePercentage(coursePK);
		// courseDTO.setrAttendanceTypeDescription(rAttendanceTypeSvr.fetchOneById(course.getAttendanceTypeFk()).getDescription());
		courseDTO.setrAttendanceTypeId(rAttendanceTypeSvr.fetchOneById(fetchOneById(coursePK).getAttendanceTypeFk()).getId());
		// courseDTO.setrSyllabusDescription(rSyllabusSvr.fetchOneById(course.getSyllabusFk()).getDescription());
		courseDTO.setrSyllabusId(rSyllabusSvr.fetchOneById(fetchOneById(coursePK).getSyllabusFk()).getId());
		courseDTO.setrSyllabusName_(rSyllabusSvr.fetchOneById(fetchOneById(coursePK).getSyllabusFk()).getName_());
		courseDTO.setStatus(fetchOneById(coursePK).getStatus());
		courseDTO.setTitle(fetchOneById(coursePK).getTitle());
		courseDTO.setTotalWorkingDays(fetchOneById(coursePK).getTotalWorkingDays());
		return courseDTO;
	}
	

}
