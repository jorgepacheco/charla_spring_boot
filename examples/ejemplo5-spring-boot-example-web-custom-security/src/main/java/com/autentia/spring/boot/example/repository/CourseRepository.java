package com.autentia.spring.boot.example.repository;

import com.autentia.spring.boot.example.model.Course;

public interface CourseRepository {

	public Course save(Course course);

	public Iterable<Course> findAll();

	public Course findOne(Long id);

}
