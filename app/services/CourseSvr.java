package services;

import java.util.List;

import interfaces.ICourse;
import models.Batch;
import models.Course;
import play.db.jpa.JPA;

public class CourseSvr implements ICourse{

	@Override
	public String save(Course course) {
		// TODO Auto-generated method stub
		try {
			JPA.em().persist(course);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public String update(Course course) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(Course course) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> findList() {
		// TODO Auto-generated method stub
		String Querry_findList = "SELECT course FROM Course course ORDER BY course.id";
		try {
			return JPA.em().createQuery(Querry_findList).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public Course findById(Long id) {
		// TODO Auto-generated method stub
				String Querry_findbyId = "SELECT course FROM Course course WHERE course.id = :id ORDER BY course.id";
				try {
					return (Course) JPA.em().createQuery(Querry_findbyId).setParameter("id", id).getSingleResult();
				} catch (Exception e) {
					// TODO: handle exception
				}
				return null;
			}
	
	

}
