package com.uisrael.edu.ec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.uisrael.edu.ec.sistar") 
public class SistarApplication{

	public static void main(String[] args)  {
		SpringApplication.run(SistarApplication.class, args);
	}

  
}
