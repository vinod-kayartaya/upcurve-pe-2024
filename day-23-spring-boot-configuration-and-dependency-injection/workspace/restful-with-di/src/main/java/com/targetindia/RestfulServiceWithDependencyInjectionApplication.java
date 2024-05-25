package com.targetindia;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@Slf4j
public class RestfulServiceWithDependencyInjectionApplication {

	public RestfulServiceWithDependencyInjectionApplication() {
		log.debug("RestfulServiceWithDependencyInjectionApplication class got instantiated");
	}

	public static void main(String[] args) {
		log.debug("RestfulServiceWithDependencyInjectionApplication.main() called");
		SpringApplication.run(RestfulServiceWithDependencyInjectionApplication.class, args);
		log.debug("end of RestfulServiceWithDependencyInjectionApplication.main()");
	}

}
