package interfaces;

import java.util.List;

import models.Department;

public interface IDepartment {
	
	public String save(Department department);
	
	public String update(Department department);
	
	public String delete (Department department);
	
	public List<Department> findList();
	
	public Department findById(Long departmentId);
}
