package com.atguigu.inxedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class InxeduEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(InxeduEurekaApplication.class, args);
	}
}
