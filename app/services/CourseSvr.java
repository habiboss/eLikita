package services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.jooq.DSLContext;
import models.dto.CourseDTO;
import schemas.public_.tables.pojos.Course;
import schemas.public_.tables.records.CourseRecord;
import schemas.public_.Tables;
import schemas.public_.tables.daos.CourseDao;

public class CourseSvr extends CourseDao {
	
	@Inject
	DSLContext sqlContext;
	@Inject
	CourseDTOSvr courseDTOSvr;
	
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
		final List<CourseDTO> course = courseDTOSvr.courseDTOList().stream()
				.filter(c -> c.getId().toString().contains(value) || c.getTitle().contains(value))
				.collect(Collectors.toList());
		course.sort((o1, o2) -> (o1.getId().compareTo(o2.getId())));
		final List<CourseDTO> result = course.stream().skip(from_index).limit(pageSize)
				.collect(Collectors.toList());
		return new models.util.Page<CourseDTO>(result, course.size(), page, pageSize);
	}
	

}
