package com.sedat.lambdaExpressions;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	private String name;
	private int age;
	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
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
	
	public static List<Employee> populateEmployees(){
		Employee john = new Employee("John Doe", 32);
		Employee jack = new Employee("Jack Sparrow", 42);
		Employee doe = new Employee("Doe Hill", 38);
		Employee snow = new Employee("Snow White", 22);
		List<Employee> employes = new ArrayList<>();
		employes.add(john);
		employes.add(jack);
		employes.add(doe);
		employes.add(snow);
		return employes;
	}
}
