package com.sedat.lambdaExpressions;

import java.util.List;
import java.util.Random;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 
 * @author sedat.turkoglu
 *Functional interfaces were introduced together with lambdas from java 8 to be used with lambdas.
 *Those functional interfaces are located in java.util.function package
 */
public class FunctionalAndPredicateInterfaces {

	public static void main(String[] args) {
		List<Employee> employes = Employee.populateEmployees();
		
		//forEach() is defined in Iterable<T> functional interface
		employes.forEach(e -> {
			System.out.println(e.getAge());
			System.out.println(e.getName());
		});
		
		printEmployeesByAge(employes, "Employees over 30", em -> em.getAge() > 30);
		printEmployeesByAge(employes, "Employees below or 30", em -> em.getAge() <= 30);
		
		//you don't need to use lambdas for Predicate interface, you can also use an anon class like below
		printEmployeesByAge(employes, "Employees younger than 25", new Predicate<Employee>() {
			@Override
			public boolean test(Employee t) {
				//System.out.println("The class name is: " + getClass().getSimpleName());
				return t.getAge() < 25;
			}
		});
		
		//consumer and predicate interfaces are general interfaces and they dont care about the type passed to them, so you should use specific consumers and predicates where possible
		IntPredicate greaterthan15 = i -> i>15;
		System.out.println("Testing int predicate: " + greaterthan15.test(16));
		//and you can even reuse them :)
		int a = 15;
		System.out.println(greaterthan15.test(a + 20));
		//you can even chain predicates to test multiple conditions
		IntPredicate lessThan100 = k -> k < 100;
		int myvalue = 16;
		System.out.println("Chain predicate: " + greaterthan15.and(lessThan100).test(myvalue));
		
		Random random = new Random();
		Supplier<Integer> randomSupplier = () -> random.nextInt(100);
		for(int i = 0; i < 10; i++) {
			int value = randomSupplier.get();
			System.out.println("Random supplier: " + value + " is smaller than 100 and greater than 15? : " + greaterthan15.and(lessThan100).test(value));
		}		
	}
	
	/**
	 * This method makes use of predicate logic to test a dynamic condition
	 * the condition is we might want to print the names of the employees who are older than 30,
	 * or younger than 30 etc. which we can decide programmatically using Predicate interface which takes an argument and returns a boolean
	 * based on our logic. BRILIIIAAANNTTTTTTTTTT
	 */
	public static void printEmployeesByAge(List<Employee> employes, String ageText, Predicate<Employee> condition) {
		System.out.println("\n" + ageText);
		System.out.println("=========================");
		for(Employee e:employes) {
			if(condition.test(e)) {
				System.out.println(e.getName() + " " + e.getAge());
			}
		}
	}

}
