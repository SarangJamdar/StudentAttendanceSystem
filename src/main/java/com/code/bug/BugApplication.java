package com.code.bug;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.code")
public class BugApplication {

	public static void main(String[] args) {
		SpringApplication.run(BugApplication.class, args);
	}

}
