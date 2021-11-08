package tn.esprit.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

//import tn.esprit.spring.controllers.ClientRestController;
@EnableSwagger2
@SpringBootApplication
//@ComponentScan(basePackageClasses = ClientRestController.class)
public class SpringBootDataJpaEntityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpaEntityApplication.class, args);
	}

}
