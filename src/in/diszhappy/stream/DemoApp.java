package in.diszhappy.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import in.diszhappy.pojo.Person;
import in.diszhappy.util.PersonUtil;

public class DemoApp {
public static void main(String[] args) {
	List<Person> javaProgrammers = PersonUtil.getJavaProgrammers();
	List<Person> phpProgrammers = PersonUtil.getPHPProgrammers();
    // sorted, collect, limit, min, max examples
    System.out.println("\n\nSort and print first 5 Java programmers by name:");
    List<Person> sortedJavaProgrammers = javaProgrammers
            .stream()
            .sorted((p, p2) -> (p.getFirstName().compareTo(p2.getFirstName())))
            .limit(5)
            .collect(Collectors.toList());

    sortedJavaProgrammers.forEach((p) -> System.out.printf("%s %s; %n", p.getFirstName(), p.getLastName()));

    System.out.println("\nSort and print Java programmers by salary:");
    sortedJavaProgrammers = javaProgrammers
            .stream()
            .sorted((p, p2) -> (p.getSalary() - p2.getSalary()))
            .collect(Collectors.toList());

    sortedJavaProgrammers.forEach((p) -> System.out.printf("%s %s; %n", p.getFirstName(), p.getLastName()));

    // min is faster than sorting and choosing the first
    System.out.println("\nGet the lowest Java programmer salary:");
    Person pers = javaProgrammers
            .stream()
            .min((p1, p2) -> (p1.getSalary() - p2.getSalary()))
            .get();

    System.out.printf("Name: %s %s; Salary: $%,d.", pers.getFirstName(), pers.getLastName(), pers.getSalary());

    System.out.println("\nGet the highest Java programmer salary:");
    Person person = javaProgrammers
            .stream()
            .max((p, p2) -> (p.getSalary() - p2.getSalary()))
            .get();

    System.out.printf("Name: %s %s; Salary: $%,d.", person.getFirstName(), person.getLastName(), person.getSalary());

    // map, collect examples
    System.out.println("\nGet PHP programmers first name to String:");
    String phpDevelopers = phpProgrammers
            .stream()
            .map(Person::getFirstName)
            .collect(Collectors.joining(" ; "));    // this can be use as a token in further operations

    System.out.println(phpDevelopers);

    System.out.println("\nGet Java programmers first name to Set:");
    Set<String> javaDevFirstName = javaProgrammers
            .stream()
            .map(Person::getFirstName)
            .collect(Collectors.toSet());

    javaDevFirstName.stream().forEach((s) -> System.out.printf("%s ", s));;

    System.out.println("\nGet Java programmers last name to TreeSet:");
    TreeSet<String> javaDevLastName = javaProgrammers
            .stream()
            .map(Person::getLastName)
            .collect(Collectors.toCollection(TreeSet::new));

    javaDevLastName.stream().forEach((s) -> System.out.printf("%s ", s));

    int numProcessorsOrCores = Runtime.getRuntime().availableProcessors();
    System.out.printf("\n\nParallel version on %s-core machine:", numProcessorsOrCores);

    // parrallel stream, sum examples
    System.out.println("\nCalculate total money spent for paying Java programmers:");
    int totalSalary = javaProgrammers
            .parallelStream()
            .mapToInt(p -> p.getSalary())
            .sum();

    System.out.printf("Money spent for paying Java programmers: $%,d %n", totalSalary);

    //Get count, min, max, sum, and average for numbers
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    IntSummaryStatistics stats = numbers
            .stream()
            .mapToInt((x) -> x)
            .summaryStatistics();

    System.out.println("Highest number in List : " + stats.getMax());
    System.out.println("Lowest number in List : " + stats.getMin());
    System.out.println("Sum of all numbers : " + stats.getSum());
    System.out.println("Average of all numbers : " + stats.getAverage());
}
}
