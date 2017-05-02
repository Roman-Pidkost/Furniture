package ua.com.furniture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("ua.com.furniture.*")
public class FurnitureApplication {

	public static void main(String[] args) {
		SpringApplication.run(FurnitureApplication.class, args);
	}
}
