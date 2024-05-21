package com.targetindia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class RestfulServiceWithDependencyInjectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulServiceWithDependencyInjectionApplication.class, args);
	}

}
