package com.wildfire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.wildfire.domain.entities")
@EnableJpaRepositories(basePackages = "com.wildfire.domain.repositories")
public class WildfireMonitoringApplication {
	public static void main(String[] args) {
		SpringApplication.run(WildfireMonitoringApplication.class, args);
	}
}
