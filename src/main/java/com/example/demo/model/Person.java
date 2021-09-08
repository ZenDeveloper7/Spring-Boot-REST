package com.example.demo.model;

public class Person {

	private String name;
	private int age;
	private int id;
	private String gender;
	
	public Person(String name, int age, int id, String gender) {
		this.name = name;
		this.age = age;
		this.id = id;
		this.gender = gender;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
