package com.sedat.lambdaExpressions;

import java.util.List;

/**
 * 
 * @author sedat.turkoglu
 *	The scope of lambda is similar to the scope of the anonymous class.
 * Inside lambda you cannot change the value of a variable that is declared outside of lambda.
 * To be able use a variable inside lambda that is declared outside, the variable needs to be effectively final, not necessarily
 * declared as final but there needs to be a value.
 */
public class ScopeAndFunctionalProgrammingInLambda {

	public static void main(String[] args) {
		
		List<Employee> employes = Employee.populateEmployees();
		
		//below code doesnt compile because the employee is declared outside lambda with no initialization
		/*Employee e;
		for(int i = 0; i < employes.size(); i++) {
			e = employes.get(i);
			new Thread(() -> {
				System.out.println(e.getName());
			});
		}*/
		
		//below code works because e is assigned a new Employee object at every iteration, so it is reachable from lambda expression as it is effectively final
		for(Employee e: employes) {
			new Thread( () -> {
				System.out.println(e.getName());
			}).start();
		}
		
		//below function in iterable was also introduced together with lambdas
		System.out.println("#########################");
		employes.forEach(employee -> {
			System.out.println(employee.getName());
			System.out.println(employee.getAge());
		});
		
		//this is visible in lambda because it has a value
		int number = 25;
		
		Runnable r = () -> {
			try {
				Thread.sleep(1000);
			}catch(InterruptedException exc) {
				System.out.println(exc.getMessage());
			}
			System.out.println("The value of the variable declared outside of lambda is: " + number);
		};
		
		new Thread(r).start();
	}

}
