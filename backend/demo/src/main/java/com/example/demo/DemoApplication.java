package com.example.demo;

import com.example.demo.Exception.GlobalExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Import(GlobalExceptionHandler.class)
public class DemoApplication {

	public static void main(String[] args) {


		SpringApplication.run(DemoApplication.class, args);
	}

}
