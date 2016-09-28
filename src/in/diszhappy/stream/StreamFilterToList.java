package in.diszhappy.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * @author Saumm Wednesday 28 09 2016
 *
 *
 */
public class StreamFilterToList {
	public static void main(String[] args) {

		Stream<Integer> number = Stream.of(1, 2, 3, 4, 5);
		/**
		 * Filters the number 3 and returns other in a list
		 */
		List<Integer> result2 = number.filter(x -> x != 3).collect(Collectors.toList());

		result2.forEach(x -> System.out.println(x));

	}
}
