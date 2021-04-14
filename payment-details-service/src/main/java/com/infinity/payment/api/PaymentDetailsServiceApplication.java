package com.infinity.payment.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PaymentDetailsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentDetailsServiceApplication.class, args);
	}

}
