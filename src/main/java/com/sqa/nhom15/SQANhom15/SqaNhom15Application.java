package com.sqa.nhom15.SQANhom15;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan(basePackages = "com.sqa.nhom15.SQANhom15")
@Configuration
public class SqaNhom15Application {

	public static void main(String[] args) {
		SpringApplication.run(SqaNhom15Application.class, args);
	}

}
