package com.example.restful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.example", "com.example.model"})
@ComponentScan({"com.example"})
@EntityScan({"com.example.model"})
@EnableJpaRepositories("com.example.model")
public class ResTfulApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(ResTfulApplication.class, args);
	}
}
