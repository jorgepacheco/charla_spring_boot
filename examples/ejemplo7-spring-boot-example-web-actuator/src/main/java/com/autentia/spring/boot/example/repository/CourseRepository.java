package com.autentia.spring.boot.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.autentia.spring.boot.example.model.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {

}
