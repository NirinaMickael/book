package com.app.bookrental.bookrental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.app.bookrental.bookrental")
public class BookrentalApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookrentalApplication.class, args);
	}

}
