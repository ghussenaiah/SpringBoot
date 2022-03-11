package springboot.example.service;

import java.util.Map;

import javax.annotation.PostConstruct;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import springboot.example.model.Employee;
import springboot.example.repository.Employeerepo;
 
@Service
public class EmployeeService implements Employeerepo{
 
    private final String EMPLOYEE_CACHE = "EMPLOYEE";
 
    @Autowired
    RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, String, Employee> hashOperations;
 
    // This annotation makes sure that the method needs to be executed after 
    // dependency injection is done to perform any initialization.
    @PostConstruct
    private void intializeHashOperations() {
        hashOperations = redisTemplate.opsForHash();
    }
 
    // Save operation.
    @Override
    public void save(final Employee employee) {
        hashOperations.put(EMPLOYEE_CACHE, employee.getId(), employee);
        System.out.println(hashOperations.get(EMPLOYEE_CACHE, employee.getId()));
    }
 
    // Find by employee id operation.
    @Override
    public Employee findById(final String id) {
        return (Employee) hashOperations.get(EMPLOYEE_CACHE, id);
    }
 
    // Find all employees' operation.
    @Override
    public Map<String, Employee> findAll() {
        return hashOperations.entries(EMPLOYEE_CACHE);
    }
 
    // Delete employee by id operation.
    @Override
    public void delete(String id) {
        hashOperations.delete(EMPLOYEE_CACHE, id);
    }
}
