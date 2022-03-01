package springboot.example.model;
//Java Program to Demonstrate Department File

//Importing package module to this code fragment

//Importing required classes
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
/*
@NoArgsConstructor
@AllArgsConstructor
@Builder */


@Entity
/*
 * @Component
 * 
 * @Scope("prototype")
 */
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long departmentId;
	
	
	@Value("David")
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;

	/*public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentName() {
		return this.departmentName = departmentName;
	}*/
	

}
