package java8;
import java.util.*;
/*
 * Sample Input 1:
	1 1 1 1 1
	2 100
	
	Sample Output 1:
	1 1 101 1 1
 */

public class Adding_values {
	// write a method here
	public static void addValueByIndex(long[] array, int index, long value) {

	}

	// don't change the code below
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
		int index = scanner.nextInt();
		long value = scanner.nextLong();
		addValueByIndex(array, index, value);
		Arrays.stream(array).forEach(e -> System.out.print(e + " "));
	}

}
