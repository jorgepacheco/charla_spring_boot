package com.autentia.spring.boot.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.autentia.spring.boot.example.model.Course;
import com.autentia.spring.boot.example.repository.CourseRepository;

@Service("courseService")
@Transactional
public class CourseServiceImpl implements CourseService, CommandLineRunner {

	private final CourseRepository courseRepository;
	
	@Autowired
	public CourseServiceImpl(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	@Override
	public Course save(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public Iterable<Course> getCourses() {
		return courseRepository.findAll();
	}

	@Override
	public Course findCourse(Long id) {
		return courseRepository.findOne(id);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Iterable<Course> courses = courseRepository.findAll();
		for (Course course : courses) {
			System.out.println("Course:" + course.getName());
		}
		
	}

}
