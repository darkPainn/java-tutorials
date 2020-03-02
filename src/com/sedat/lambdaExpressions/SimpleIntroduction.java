package com.sedat.lambdaExpressions;

import java.util.Collections;
import java.util.List;

public class SimpleIntroduction {

	public static void main(String[] args) {
		List<Employee> employes = Employee.populateEmployees();
		
		//This is the regular way of implementing an anonymous class, lamdas is replacing it when the interface is a functional one
		/*Collections.sort(employes, new Comparator<Employee>() {
			@Override
			public int compare(Employee e1, Employee e2) {
				return e1.getName().compareTo(e2.getName());
			}
		});*/
		
		//This is the simplified version of above, with lamdas
		Collections.sort(employes, (Employee e1, Employee e2) -> 
			e1.getName().compareTo(e2.getName())
		);
		
		for(Employee e : employes) {
			System.out.println(e.getName());
		}
		
		//the below line (the lambda expression is actually the implementation of the UpperConcat interface.
		//you can have single line of code in the body(in which case the return statement is not needed.
		//you can also have multiple lines of code within the body and return the result
		UpperConcat uc = (s1, s2) -> s1.toUpperCase() + s2.toUpperCase();
		
		
		String s = doStringStuff(uc, employes.get(0).getName(), employes.get(1).getName());
		System.out.println(s);
	}
	
	public static final String doStringStuff(UpperConcat uc, String s1, String s2) {
		return uc.upperAndConcat(s1, s2);
	}

}





























