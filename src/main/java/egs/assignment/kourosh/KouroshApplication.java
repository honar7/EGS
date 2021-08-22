package egs.assignment.kourosh;

import egs.assignment.kourosh.service.GroupUserDetailsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class KouroshApplication {

	public static void main(String[] args) {
		SpringApplication.run(KouroshApplication.class, args);
	}

}
