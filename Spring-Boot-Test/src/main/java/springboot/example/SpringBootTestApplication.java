package springboot.example;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootTestApplication {
	
	
	private static final Logger logger = LogManager.getLogger(SpringBootTestApplication.class);

	public static void main(String[] args) {
			SpringApplication.run(SpringBootTestApplication.class, args);
			String currentDir = System.getProperty("user.dir");
			System.out.println(currentDir);
		  logger.info("this is a info message");
	      logger.warn("this is a warn message");
	      logger.error("this is a error message");
	      
	      System.out.println(SpringBootTestApplication.class.getClassLoader().getResource("logging.properties"));
	}

}


