package springboot.example.repository;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



import springboot.example.model.Employee;

@Repository
public interface Employeerepo extends CrudRepository<Employee, Serializable> {
	
	// Save a new employee.
	
		
		// Find employee by id.
		Employee findById(String id);
		
		// Final all employees.
		Iterable<Employee> findAll();
		
		// Delete a employee.
		void delete(String id);
}
