package com.ym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ym"})
public class AppMain {
	
	public static void main(String[] args) {
		SpringApplication.run(AppMain.class, args);
	}
}
