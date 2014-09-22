package com.autentia.springboot.component;

import org.springframework.boot.*;
import org.springframework.stereotype.*;

@Service
public class MyService implements CommandLineRunner {
	
	public String message(){
		return "Primera aplicación con Spring Boot !!!!\n";
	}

    public void run(String... args) {
      System.out.println(":::: COMMAND LINE RUNNER ::::");
    }

}