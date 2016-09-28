package in.diszhappy.stream;

import java.util.List;
import java.util.function.Predicate;

import in.diszhappy.pojo.Person;
import in.diszhappy.util.PersonUtil;

/**
 * Here we will create a filter and reuse them in further operation
 * 
 * @author Saumm Wednesday 28 09 2016
 *
 *
 */
public class ReUsableFilterDemo {
	public static void main(String[] args) {
		List<Person> javaProgrammers = PersonUtil.getJavaProgrammers();
		List<Person> phpProgrammers = PersonUtil.getPHPProgrammers();
		
		// Define some filters
        Predicate<Person> ageFilter = (p) -> (p.getAge() > 25);
        Predicate<Person> salaryFilter = (p) -> (p.getSalary() > 1400);
        Predicate<Person> genderFilter = (p) -> ("female".equals(p.getGender()));

        System.out.println("\n\nFemale PHP programmers that earn more than $1,400 and are older than 24 years:");
        phpProgrammers.stream()
                .filter(ageFilter)
                .filter(salaryFilter)
                .filter(genderFilter)
                .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));

        // Reuse filters
        System.out.println("\n\nFemale Java programmers older than 24 years:");
        javaProgrammers.stream()
                .filter(ageFilter)
                .filter(genderFilter)
                .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));
	}
}
