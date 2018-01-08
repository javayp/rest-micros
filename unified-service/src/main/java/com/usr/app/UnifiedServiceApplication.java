package com.usr.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UnifiedServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnifiedServiceApplication.class, args);
	}
}
