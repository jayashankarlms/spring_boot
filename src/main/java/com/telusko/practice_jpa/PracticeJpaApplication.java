package com.telusko.practice_jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.telusko.practice_jpa.service.AlienService;

@SpringBootApplication
public class PracticeJpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(PracticeJpaApplication.class, args);
		AlienService service = context.getBean(AlienService.class);
		System.out.println(service.objectCreation());
	}

}
