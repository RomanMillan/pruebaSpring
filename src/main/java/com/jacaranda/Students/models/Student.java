package com.jacaranda.Students.models;

import java.util.Objects;

public class Student {

	private String name;
	private String surname;
	private int age;
	
	//constructor
	public Student() {
		super();
	}
	
	
	public Student(String name, String surname, int age) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
	}



	//Getter and setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	//hashCode and equals
	@Override
	public int hashCode() {
		return Objects.hash(name, surname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(name, other.name) && Objects.equals(surname, other.surname);
	}
	
	
}
