package com.autentia.spring.boot.example.repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Repository;

import com.autentia.spring.boot.example.model.Course;

@Repository
public class InMemoryCourseRepositoryImpl implements CourseRepository,  CommandLineRunner{
	
	private static AtomicLong counter = new AtomicLong();

	private final ConcurrentMap<Long, Course> courses = new ConcurrentHashMap<Long, Course>();

	@Override
	public Course save(Course course) {
		
		Long id = course.getId();
		if (id == null) {
			id = counter.incrementAndGet();
			course.setId(id);
		}
		this.courses.put(id, course);
		return course;
	}

	@Override
	public Iterable<Course> findAll() {
		return  this.courses.values();
	}

	@Override
	public Course findOne(Long id) {
		return this.courses.get(id);
	}

	@Override
	public void run(String... args) throws Exception {
		Course curso1 = new Course("BOOT", "Introducción a Spring Boot");
		Course curso2 = new Course("JSF2", "Desarrollo de Aplicaciones con JSF2 / PrimeFaces");
		save(curso1);
		save(curso2);
		
	}

}
