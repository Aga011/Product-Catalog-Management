package com.Aga.Agali.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.Aga.Agali")
@ComponentScan(basePackages = "com.Aga.Agali")
@EnableJpaRepositories(basePackages = "com.Aga.Agali")

public class ProductCatalogManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCatalogManagementApplication.class, args);
	}

}
