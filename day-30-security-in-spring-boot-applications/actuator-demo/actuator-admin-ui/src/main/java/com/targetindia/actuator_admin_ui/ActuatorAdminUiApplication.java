package com.targetindia.actuator_admin_ui;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class ActuatorAdminUiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActuatorAdminUiApplication.class, args);
	}

}
