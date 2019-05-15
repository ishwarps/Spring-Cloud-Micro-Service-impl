package com.example.priceInfoMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
@EnableEurekaClient
public class PriceInfoMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PriceInfoMsApplication.class, args);
	}
}
