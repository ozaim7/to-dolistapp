package com.zaim.to_dolistapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.info.Info;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@OpenAPIDefinition(
		info = @Info(
                title = "ToDo API",
                version = "1.0",
                description = "Spring Boot ToDo APP"
        )
)
@SpringBootApplication
public class ToDolistappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDolistappApplication.class, args);
	}

}
