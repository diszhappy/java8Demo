# java8Demo
These are few exammple of java 8 for beginners.
Java 8 Learning doc.

Functional Interface and Lambda: 
The interfaces those have only one abstract method(e.g. Runnable, Callable, ActionListener etc) called Single Abstract Method interfaces (SAM Interfaces). And a popular way in which these are used is by creating Anonymous Inner classes using these interfaces like 

public class AnonymousInnerClassTest {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("A thread created and running ...");
			}
		}).start();
	}
}

With Java 8 the same concept of SAM interfaces is recreated and are called Functional interfaces. A functional interface has exactly one abstract method. It is basically used in functional programming(Lambda expression). It can be created by annotating the interface with @FunctionalInterface. 

e.g

@FunctionalInterface
public interface MyInterface {
	public abstract int getSquare(int x);
}

We can use lambda to create object of anonymous MyInterface.

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		checkFeaturesOfLambda();

	}
	 private static void checkFeaturesOfLambda(){
		 /**
		  * The below myInterface reference will hold one object of 		        
  * MyInterface  and the abstract method getSqure is overridden by 		  
   * the lambda expression.
		  */
		 MyInterface myInterface = (number) ->  number*number;
		 System.out.println(myInterface.getSquare(5));
	 }

}

The output will be 25.




Lambda Comparator

Lambda expression helps us to write comparator easily. Let’s consider the example to implement comparator using lambda.

First see the classical comparator. Let there is an employee object and we will compare that based upon name.

The classical comparator will be 

Comparator<Employee> byName = new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getName().compareTo(o2.getName());
			}
		};

The Lambda comparator will be 
Comparator<Employee> byName =
			(Employee o1, Employee o2)->o1.getName().compareTo(o2.getName());



Stream
Another big feature of java 8 is stream. Streams are wrappers around collections that use lambdas pervasively. They support many operations that use lambdas, like map, filter, limit, sorted, count, min, max, sum, collect and others. Also, streams use lazy evaluation and they are not actually reading all the data and methods like getFirst() can end the stream. In the next examples, we will explore what lambdas and streams can do. We created a Person class and use this class to add some data to a list that will be used in further streams operations. The Person class is just a simple POJO.

One useful method of stream is collect. We can convert a stream to list using collect method.

Stream<String> language = Stream.of("java", "python", "node");
// Convert language Stream to List
List<String> result = language.collect(Collectors.toList());

Another useful method of stream is filter. Filter can be added to a stream to fetch the data as per the requirement. Let’s consider we have two lists of person. 
1.	JavaProgrammerList(javaProgrammers)
2.	PhpProgrammerList(phpProgrammers)

We can apply filter on both these list for various operation. Let’s find the list of person those have more than 1400 salary from phpProgrammers list.
List<Person> filteredPHProgrammers = phpProgrammers.stream()
        .filter((p) -> (p.getSalary() > 1400)).collect(Collectors.toList());
Now print the employees those have more than 1700 salary.
filteredPHProgrammers.stream()
        .filter((p) -> (p.getSalary() > 1700)).forEach(System.out::println);



We can create a filter and reuse that as per our requirement. For example let’s create a filter for person whose age is less than 24 years and collects them to a list

Predicate<Person> ageFilter = (p) -> (p.getAge() < 24);
List<Person> phpProgrammersFileteredByAge = phpProgrammers.stream()
.filter(ageFilter).collect(Collectors.toList())

Another function of stream is limit. We can use this to select a limited number of objects from a collection. For example let’s print first 3 persons from javaProgrammers list.

javaProgrammers.stream()
                .limit(3).forEach(System.out::println);
