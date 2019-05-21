package com.uisrael.edu.ec.crigm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.filter.RequestContextFilter;

@SpringBootApplication
@ComponentScan(basePackages = "com.uisrael.edu.ec.crigm") 

public class CrigmApplication{

	@Bean
	public RequestContextFilter requestContextFilter() {
		return new RequestContextFilter();
	}
	
	public static void main(String[] args)  {
		SpringApplication.run(CrigmApplication.class, args);
	}

  
}
