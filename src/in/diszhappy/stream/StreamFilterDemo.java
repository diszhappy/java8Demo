package in.diszhappy.stream;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import in.diszhappy.pojo.Person;
import in.diszhappy.util.PersonUtil;

/**
 * 
 * @author Saumm Wednesday 28 09 2016
 *
 *
 */
public class StreamFilterDemo {
	public static void main(String[] args) {
		List<Person> javaProgrammers = PersonUtil.getJavaProgrammers();
		List<Person> phpProgrammers = PersonUtil.getPHPProgrammers();
		System.out.println("Show java programmers names:");
		javaProgrammers.forEach(System.out::println);
		System.out.println("Show java programmers names:");
		phpProgrammers.forEach(System.out::println);
		// let’s show PHP programmers that earn more than $1,700:
		System.out.println("------------------------------------\n"+"show PHP programmers that earn more than $1,400\n------------------------------------");
		
		
		List<Person> filteredPHProgrammers = phpProgrammers.stream()
		        .filter((p) -> (p.getSalary() > 1400)).collect(Collectors.toList());
		filteredPHProgrammers.forEach(System.out::println);
		System.out.println("------------------------------------\n"+"show PHP programmers that earn more than $1,700\n------------------------------------");
		filteredPHProgrammers.stream()
        .filter((p) -> (p.getSalary() > 1700))
        .forEach(System.out::println);

	}
}
