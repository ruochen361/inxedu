package com.atguigu.inxedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class InxeduCourseProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(InxeduCourseProviderApplication.class, args);
	}
}
