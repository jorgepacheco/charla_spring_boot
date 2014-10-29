package com.autentia.spring.boot.example.view;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.autentia.spring.boot.example.model.Course;
import com.autentia.spring.boot.example.service.CourseService;

@ManagedBean
@ViewScoped
public class CourseView {
	
	@ManagedProperty("#{courseService}")
	private CourseService courseService;
	
	private Iterable<Course> courses;
	
	
	@PostConstruct
	public void init() {
		courses = courseService.getCourses();
	}
	
	public String getHello() {
		return "Hello from PrimeFaces and Spring Boot!";
	}

	public CourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	public Iterable<Course> getCourses() {
		return courses;
	}

	public void setCourses(Iterable<Course> courses) {
		this.courses = courses;
	}
}
