package com.first_app.app_learning_springboot;

//import com.first_app.app_learning_springboot.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@SpringBootApplication
public class AppLearningSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppLearningSpringbootApplication.class, args);

	}


}
