package com.farmasol;

import org.apache.catalina.security.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class FarmasolBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmasolBackendApplication.class, args);
	}

}
