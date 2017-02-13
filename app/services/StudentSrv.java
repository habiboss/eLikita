package services;

import java.util.List;

import interfaces.IStudent;
import models.Student;
import play.db.jpa.JPA;

public class StudentSrv implements IStudent{

	@Override
	public String save(Student student) {
		// TODO Auto-generated method stub
		try {
			JPA.em().persist(student);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public String update(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findList() {
		// TODO Auto-generated method stub
		String Querry_findList = "SELECT student FROM Student student ORDER BY student.id";
		try {
			return JPA.em().createQuery(Querry_findList).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public Student findById(Long id) {
		// TODO Auto-generated method stub
		String Querry_findById = "SELECT student FROM Student student WHERE student.id =:id ORDER BY student.id";
		try {
			return (Student) JPA.em().createQuery(Querry_findById).setParameter("id", id).getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
