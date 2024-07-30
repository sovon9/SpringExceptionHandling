package com.RestExceptionHandling.handleExcep.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Student {

	private int id;
	@NotNull
	@Size(min=2, message = "Name must have atleast two charecters")
	private String name;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
}
