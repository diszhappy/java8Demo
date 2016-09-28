package in.diszhappy.stream;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import in.diszhappy.pojo.Person;
import in.diszhappy.util.PersonUtil;

public class LimitDemo {
	public static void main(String[] args) {
		List<Person> javaProgrammers = PersonUtil.getJavaProgrammers();
		List<Person> phpProgrammers = PersonUtil.getPHPProgrammers();
		Predicate<Person> genderFilter = (p) -> ("female".equals(p.getGender()));
		// limit examples
        System.out.println("\n\nPrint first 3 Java programmers:");
        javaProgrammers.stream()
                .limit(3).forEach(System.out::println);

        System.out.println("\n\nPrint first 3 female Java programmers:");
        javaProgrammers.stream()
                .filter(genderFilter)
                .limit(3)
                .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));

        // sorted, collect, limit, min, max examples
        System.out.println("\n\nSort and print first 5 Java programmers by name:");
        List<Person> sortedJavaProgrammers = javaProgrammers
                .stream()
                .sorted((p, p2) -> (p.getFirstName().compareTo(p2.getFirstName())))
                .limit(5)
                .collect(Collectors.toList());

        sortedJavaProgrammers.forEach((p) -> System.out.printf("%s %s; %n", p.getFirstName(), p.getLastName()));
	}
}
