package com.autentia.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autentia.springboot.component.MyService;

@RestController
@EnableAutoConfiguration
@ComponentScan
public class Application {
	
	@Autowired
	private MyService service;

    @RequestMapping("/hello")
    String home() {
        return service.message();
    }

    public static void main(String[] args) throws Exception {
      SpringApplication.run(Application.class, new String[]{"--debug"});
    }

}