package com.atguigu.inxedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class InxeduStudentProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(InxeduStudentProviderApplication.class, args);
	}
}
