package com.example.demo.com.example.demo.model;

import java.io.Serializable;

public class Student implements Serializable {
    private Integer id;
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String name;
    // standard getters and setters
}