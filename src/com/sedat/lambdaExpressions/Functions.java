package com.sedat.lambdaExpressions;

import java.util.List;
import java.util.Random;
import java.util.function.Function;

/**
 * 
 * @author sedat.turkoglu
 *The Function<t, R> represents a function that takes an argument and returns a value.
 *In this example we could have added getLastName() to the Employee class but it is only to demonstrate what can be done
 *with the Function interface together with lambdas.
 *By using the Function, we can pass code that accepts and returns a value to a method in the form of a lambda expression, and then run that
 *code without having to create an interface and a class that implements that interface.
 */
public class Functions {

	public static void main(String[] args) {
		List<Employee> employes = Employee.populateEmployees();
		
		//first argument is what the apply() method takes and second one is what it returns
		Function<Employee, String> getLastName = (Employee e) -> {
			//define your logic here
			String name = e.getName();
			return name.substring(name.indexOf(' ') +1 );
		};
		
		Function<Employee, String> getFirstName = (Employee e) -> {
			return e.getName().substring(0, e.getName().indexOf(' '));
		};
		
		//System.out.println(getFirstName.apply(employes.get(0)));
		//System.out.println(getLastName.apply(employes.get(0)));
		
		Random r = new Random();
		//depending on the random boolean value, we are calling getFirstName or getLastName by passing them to getAName
		for(Employee e: employes) {
			if(r.nextBoolean()) {
				System.out.println(getAName(getFirstName, e));
			}else {
				System.out.println(getAName(getLastName, e));
			}
		}
	}
	
	private static String getAName(Function<Employee, String> getName, Employee e) {
		return getName.apply(e);
	}

}
