package presc_lib;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication //(exclude = { SecurityAutoConfiguration.class })

@Configuration
@ComponentScan
@EnableAutoConfiguration

public class PrescLibApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrescLibApplication.class, args);
	}

}
