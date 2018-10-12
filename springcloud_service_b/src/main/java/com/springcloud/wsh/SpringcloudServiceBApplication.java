package com.springcloud.wsh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringcloudServiceBApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudServiceBApplication.class, args);
	}
}
