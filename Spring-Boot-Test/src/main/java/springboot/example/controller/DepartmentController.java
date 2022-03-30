package springboot.example.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Importing required classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import springboot.example.model.Department;
import springboot.example.service.DepartmentService;


@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	// Save operation// SpringBootTest
	@PostMapping("/departments")
	public Department saveDepartment(@RequestBody Department department,HttpServletRequest request, HttpServletResponse response) {
		System.out.println("remote address"+request.getRemoteHost());
		return departmentService.saveDepartment(department);
	}

	// Read operation
	@GetMapping("/departments")
	public List<Department> fetchDepartmentList() {
		return departmentService.fetchDepartmentList();
	}
	
	@GetMapping("/departmentsbyname/{depname}")
	public List<Department> fetchDepartmentList(@PathVariable("depname") String depname) {
		return departmentService.listDepertmentOverDepartmentName(depname);
	}


	// Update operation
	@PutMapping("/departments/{id}")
	public Department updateDepartment(@RequestBody Department department, @PathVariable("id") Long departmentId) {
		return departmentService.updateDepartment(department, departmentId);
	}

	// Delete operation
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
		departmentService.deleteDepartmentById(departmentId);

		return "Deleted Successfully";
	}
	
	
	@PostMapping("/fileupload")
	public ResponseEntity<Object> saveDepartment(@RequestParam("file") MultipartFile file) throws IOException {
		
		 byte[] fileContent=file.getBytes();
	     System.out.println(file.getSize());
	     System.out.println(file.getOriginalFilename());
	     System.out.println(file.getName());
		 return new ResponseEntity<Object>("file uploaded",HttpStatus.OK);
	}
}





