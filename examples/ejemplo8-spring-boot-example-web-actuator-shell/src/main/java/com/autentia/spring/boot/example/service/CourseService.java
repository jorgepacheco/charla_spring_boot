package com.autentia.spring.boot.example.service;

import com.autentia.spring.boot.example.model.Course;

public interface CourseService {
	
	Course save(Course course);
	
	Iterable<Course> getCourses();
	
	Course findCourse(Long id);

}
