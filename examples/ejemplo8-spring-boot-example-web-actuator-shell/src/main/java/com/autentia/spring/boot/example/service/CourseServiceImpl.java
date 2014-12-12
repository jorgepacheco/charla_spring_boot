package com.autentia.spring.boot.example.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.autentia.spring.boot.example.model.Course;
import com.autentia.spring.boot.example.repository.CourseRepository;

@Service("courseService")
@Transactional
public class CourseServiceImpl implements CourseService {

	private final CourseRepository courseRepository;
	
	private final CounterService counterService;

	private final GaugeService gaugeService;
	
	@Autowired
	public CourseServiceImpl(CourseRepository courseRepository, CounterService counterService, GaugeService gaugeService) {
		this.courseRepository = courseRepository;
		this.counterService = counterService;
		this.gaugeService = gaugeService;
	}

	@Override
	public Course save(Course course) {
		this.counterService.increment("autentia.metrics.save.course");
		return courseRepository.save(course);
	}

	@Override
	public Iterable<Course> getCourses() {
		
	    Long start = new Date().getTime();
	    Iterable<Course> courses = courseRepository.findAll();
	    gaugeService.submit("autentia.metrics.time.get.courses", new Date().getTime() - start);
		
		return courses;
	}

	@Override
	public Course findCourse(Long id) {
		return courseRepository.findOne(id);
	}

}
