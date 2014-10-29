package com.autentia.spring.boot.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autentia.spring.boot.example.mapper.CourseMapper;
import com.autentia.spring.boot.example.model.Course;

@Service("courseService")
public class CourseServiceImpl implements CourseService {

	private final CourseMapper courseMapper;
	
	@Autowired
	public CourseServiceImpl(CourseMapper courseRepository) {
		this.courseMapper = courseRepository;
	}

	@Override
	public int save(Course course) {
		return courseMapper.save(course);
	}

	@Override
	public Iterable<Course> getCourses() {
		return courseMapper.findAll();
	}

	@Override
	public Course findCourse(Long id) {
		return courseMapper.findOne(id);
	}

}
