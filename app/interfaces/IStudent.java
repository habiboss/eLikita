package interfaces;

import java.util.List;

import models.Student;

public interface IStudent {
	
	public String save(Student student);
	
	public String update(Student student);
	
	public String delete(Student student);
	
	public List<Student> findList();
	
	public Student findById(Long id);

}
