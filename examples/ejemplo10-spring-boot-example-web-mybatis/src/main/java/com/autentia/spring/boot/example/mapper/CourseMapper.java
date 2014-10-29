package com.autentia.spring.boot.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.autentia.spring.boot.example.model.Course;

public interface CourseMapper {
	@Select("SELECT * FROM course WHERE id = #{id}")
	public Course findOne(long id);

    @Insert("insert into course (name, description) values(#{name}, #{description})")
    @SelectKey(statement="call identity()", keyProperty="id", before=false, resultType=Long.class)
    public int save(Course course);
    
    
    @Select("SELECT * FROM course")
    public List<Course> findAll();
}
