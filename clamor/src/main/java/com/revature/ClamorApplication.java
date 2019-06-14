package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ClamorApplication {

	public static void main(String[] args) {
		System.out.println("running clamor on port 1234");
		SpringApplication.run(ClamorApplication.class, args);
	}

}
