package com.autentia.spring.boot.example.model;

import java.io.Serializable;

public class Course implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private String description;


	protected Course() {
	}

	public Course(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	@Override
	public String toString() {
		return getName() + "," + getDescription();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}