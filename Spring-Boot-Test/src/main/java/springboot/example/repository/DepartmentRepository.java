package springboot.example.repository;

import java.util.List;

//Java Program to Illustrate DepartmentRepository File

//Importing package module to code fragment

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import springboot.example.model.Department;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

	

	@Query("SELECT d FROM Department d WHERE d.departmentName = :departmentName")
	public List<Department> listDepertmentOverDepartmentName(@Param("departmentName") String name);
}
