package com.atguigu.inxedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.atguigu.inxedu"})
public class InxeduCourseConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InxeduCourseConsumerApplication.class, args);
	}
}
