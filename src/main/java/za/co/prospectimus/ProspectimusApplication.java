package za.co.prospectimus;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class ProspectimusApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProspectimusApplication.class, args);
	}
	

}
