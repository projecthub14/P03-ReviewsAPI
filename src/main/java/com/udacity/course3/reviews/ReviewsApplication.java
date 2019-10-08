package com.udacity.course3.reviews;

import org.flywaydb.core.Flyway;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class ReviewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewsApplication.class, args);
	}


	@Bean
	public CommandLineRunner project3(Environment env) {
		return (args) -> {

			// Create the Flyway instance and point it to the database
			//get datasource properties from application.properties
			Flyway flyway = Flyway.configure().dataSource(
					env.getProperty("spring.datasource.url"),
					env.getProperty("spring.datasource.username"),
					env.getProperty("spring.datasource.password")).load();

			// Start the migration
			flyway.migrate();

		};
		}



}