package com.stocks.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.stocks")
@EntityScan(basePackages = "com.stocks.entity")
@EnableJpaRepositories(basePackages = "com.stocks.persistence")
public class StockServiceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockServiceApiApplication.class, args);
	}

}
