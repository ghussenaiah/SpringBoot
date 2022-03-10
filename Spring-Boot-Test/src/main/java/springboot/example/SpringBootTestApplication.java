package springboot.example;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import springboot.example.model.Department;

@SpringBootApplication
@EnableScheduling
public class SpringBootTestApplication implements CommandLineRunner {
	
	
	
	
	
	private static final Logger logger = LogManager.getLogger(SpringBootTestApplication.class);
	

	@Autowired
	ApplicationContext context;
	

	public static void main(String[] args) {

		SpringApplication.run(SpringBootTestApplication.class, args);

		String currentDir = System.getProperty("user.dir");
		System.out.println(currentDir);
		logger.info("this is a info message");
		logger.warn("this is a warn message");
		logger.error("this is a error message");

		System.out.println(SpringBootTestApplication.class.getClassLoader().getResource("logging.properties"));

	}

	@Override
	public void run(String... args) throws Exception {

		/*
		 * Department dep = context.getBean(Department.class); System.out.println(dep);
		 * dep.setDepartmentName("cse"); System.out.println(dep);
		 * 
		 * Department dep1 = context.getBean(Department.class);
		 * System.out.println(dep1);
		 */

	}
}

