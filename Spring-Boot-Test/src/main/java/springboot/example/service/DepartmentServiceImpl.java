package springboot.example.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import springboot.example.model.Article;
import springboot.example.model.Department;
import springboot.example.repository.ArticleRepository;
import springboot.example.repository.DepartmentRepository;
  
@Component
public class DepartmentServiceImpl implements DepartmentService {
  
	
	/* working code 
	 * @Scheduled(fixedRate = 1000) public void fixedDelaySch() { SimpleDateFormat
	 * sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"); Date now = new Date();
	 * String strDate = sdf.format(now);
	 * System.out.println("Fixed Delay scheduler:: " + strDate); }
	 */
	
	
    @Autowired
    private DepartmentRepository departmentRepository;
    
    @Autowired
    private ArticleRepository articleRepository;
    
    
  
    // Save operation
    @Override
    
    public Department saveDepartment(Department department)
	{
		Article ar = new Article();
		ar.setContent("tajmahal");
		ar.setDescription("tajmahal");
		ar.setKeywords("tajmahal");
		ar.setTitle("tajmahal");

		Department d = null;
		try {
			
			department.setDepartmentCode("99");
		    d = departmentRepository.save(department);
		    
		} catch (Exception e) {
			System.out.println(e);
		}
		try {

			articleRepository.save(ar);
		} catch (Exception e) {
			System.out.println(e);
		}

		return d;

	}
  
    // Read operation
    @Override 
    public List<Department> fetchDepartmentList()
    {
        return (List<Department>) departmentRepository.findAll();
    }
    
    @Override 
    public List<Department> listDepertmentOverDepartmentName(String name)
    {
        return (List<Department>) departmentRepository.listDepertmentOverDepartmentName(name);
    }
  
    // Update operation
    @Override
    public Department updateDepartment(Department department,
                     Long departmentId)
    {
        Department depDB = departmentRepository.findById(departmentId)
                  .get();
        
        if (Objects.nonNull(department.getDepartmentName())
                && !"".equalsIgnoreCase(
                    department.getDepartmentName())) {
                depDB.setDepartmentName(
                    department.getDepartmentName());
            }
      
            if (Objects.nonNull(
                    department.getDepartmentAddress())
                && !"".equalsIgnoreCase(
                    department.getDepartmentAddress())) {
                depDB.setDepartmentAddress(
                    department.getDepartmentAddress());
            }
      
            if (Objects.nonNull(department.getDepartmentCode())
                && !"".equalsIgnoreCase(
                    department.getDepartmentCode())) {
                depDB.setDepartmentCode(
                    department.getDepartmentCode());
            }
        return departmentRepository.save(depDB);
    }
  
    // Delete operation
    @Override
    public void deleteDepartmentById(Long departmentId)
    {
        departmentRepository.deleteById(departmentId);
    }
    
    
}