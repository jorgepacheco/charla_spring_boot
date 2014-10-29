/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.autentia.spring.boot.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.autentia.spring.boot.example.mapper.CourseMapper;
import com.autentia.spring.boot.example.mapper.UserMapper;
import com.autentia.spring.boot.example.model.Course;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class SampleProfileApplication implements CommandLineRunner {

    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private CourseMapper courseMapper;


	@Override
	public void run(String... args) {

        System.out.println("Adding Course");
        courseMapper.save(new Course("Scrum", "Scrum desde las trincheras"));
        
        Iterable<Course> courses = courseMapper.findAll();
        
        for (Course course : courses) {
			System.out.println(course);
		}
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleProfileApplication.class, new String[]{"--debug"});
	}
}
