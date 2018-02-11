package interfaces;

import java.util.List;

import models.Student;
import play.data.Form;

public interface IStudent {
	
	public String save(Form<Student> form, Student student);
	
	public String update(Student student);
	
	public String delete(Student student);
	
	public List<Student> findList();
	
	public Student findById(Long id);

}
