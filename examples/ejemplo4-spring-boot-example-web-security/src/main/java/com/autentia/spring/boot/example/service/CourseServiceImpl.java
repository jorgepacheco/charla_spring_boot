package com.autentia.spring.boot.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autentia.spring.boot.example.model.Course;
import com.autentia.spring.boot.example.repository.CourseRepository;

@Service("courseService")
public class CourseServiceImpl implements CourseService {

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

}
