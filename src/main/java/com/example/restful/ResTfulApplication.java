package com.example.restful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example", "com.example.model"})
public class ResTfulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResTfulApplication.class, args);
	}
}
