package interfaces;

import java.util.List;

import models.Course;

public interface ICourse {
	
	public String save(Course course);
	
	public String update(Course course);
	
	public String delete(Course course);
	
	public List<Course> findList();
	
	public Course findById(Long id);

}
