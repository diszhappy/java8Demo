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
public class StreamToList {
	public static void main(String[] args) {

		Stream<String> language = Stream.of("java", "python", "node");

		// Convert a Stream to List
		List<String> result = language.collect(Collectors.toList());

		result.forEach(System.out::println);

	}
}
