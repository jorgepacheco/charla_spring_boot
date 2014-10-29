package com.autentia.spring.boot.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.autentia.spring.boot.example.model.Course;
import com.autentia.spring.boot.example.model.User;

public interface UserMapper {
	@Select("SELECT * FROM user WHERE id = #{userId}")
	public User getUser(long userId);

    @Insert("insert into user (email, userName) values(#{email}, #{userName})")
    public int addUser(User user);

}
