package com.vtoebe.bankaccount811;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BankAccount811Application {

	public static void main(String[] args) {
		SpringApplication.run(BankAccount811Application.class, args);
	}

}
