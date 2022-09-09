package com.first_app.app_learning_springboot;

//import com.first_app.app_learning_springboot.student.Student;
import com.first_app.app_learning_springboot.sale_app.util.NestedPropertiesExample;
import com.first_app.app_learning_springboot.sale_app.util.SaleAppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@SpringBootApplication // annotation
@EnableConfigurationProperties
public class AppLearningSpringbootApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AppLearningSpringbootApplication.class, args);
		//1. create container
		//2. find all dependency in project and insert them to container.
		//3. container => ApplicationContext, dependency => Bean.

	}
	@Autowired
	SaleAppProperties saleAppProperties;
	@Autowired
	NestedPropertiesExample nestedPropertiesExample;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("-----------------URL variable----------------");
		System.out.println("\t locationUrl: "+saleAppProperties.getLocationUrl());
		System.out.println("\t productUrl: "+saleAppProperties.getProductUrl());
		System.out.println("\t saleUrl: "+saleAppProperties.getSaleUrl());
		System.out.println("\t timeUrl: "+saleAppProperties.getTimeUrl());
		System.out.println("-----------------nested example variable----------------");
		System.out.println("\t demoList: "+nestedPropertiesExample.getDemoList());
		System.out.println("\t demoMap: "+nestedPropertiesExample.getDemoMap());

	}


}
