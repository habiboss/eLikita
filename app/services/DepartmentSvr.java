package services;

import java.util.List;

import interfaces.IDepartment;
import models.Department;
import play.db.jpa.JPA;

public class DepartmentSvr implements IDepartment{

	@Override
	public String save(Department department) {
		// TODO Auto-generated method stub
		try {
			JPA.em().persist(department);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public String update(Department department) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(Department department) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public List<Department> findList() {
		// TODO Auto-generated method stub
		String Querry_findList = "SELECT department FROM Department department ORDER BY department.id";
		try {
			return JPA.em().createQuery(Querry_findList).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.toString();
		}
		return null;
	}

	@Override
	public Department findById(Long departmentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
