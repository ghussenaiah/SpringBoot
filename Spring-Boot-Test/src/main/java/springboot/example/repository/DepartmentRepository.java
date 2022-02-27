package springboot.example.repository;

//Java Program to Illustrate DepartmentRepository File

//Importing package module to code fragment

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.example.model.Department;


@Repository
public interface DepartmentRepository
	extends JpaRepository<Department, Long> {
}
