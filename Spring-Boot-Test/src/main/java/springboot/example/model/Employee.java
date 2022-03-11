package springboot.example.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;
 
// Employee model class has basic employee-related attributes.
@Component
public class Employee implements Serializable {
 
    private static final long serialVersionUID = 1L;
 
    private String id;
    private String name;
    private int age;
    private Double salary;
     
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
     
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
     
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
     
    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }
}