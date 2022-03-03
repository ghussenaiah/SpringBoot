package springboot.example.service;

import java.util.List;

import springboot.example.model.Department;

//Interface
public interface DepartmentService {

	// Save operation
	Department saveDepartment(Department department);

	// Read operation
	List<Department> fetchDepartmentList();

	// Update operation
	Department updateDepartment(Department department, Long departmentId);

	// Delete operation
	void deleteDepartmentById(Long departmentId);

	List<Department> listDepertmentOverDepartmentName(String name);

}
