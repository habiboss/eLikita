package interfaces;

import java.util.List;
import schemas.public_.tables.pojos.Course;

public interface ICourse {
	
	public void save(Course course);
		
	public void delete(Course course);
	
	public List<Course> findList();
	
}
