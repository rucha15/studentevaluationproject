package com.project.studentevaluationproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class StudentEvaluationApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentEvaluationApplication.class, args);
	}

}
