package com.autentia.spring.boot.example.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	@NotEmpty(message = "Name is required.")
	private String name;

	@Column(nullable = false)
	@NotEmpty(message = "Description is required.")
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