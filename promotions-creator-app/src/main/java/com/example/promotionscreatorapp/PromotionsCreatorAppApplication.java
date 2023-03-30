package com.example.promotionscreatorapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
@EnableAutoConfiguration
public class PromotionsCreatorAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PromotionsCreatorAppApplication.class, args);
	}
	
}
