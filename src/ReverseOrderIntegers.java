import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ReverseOrderIntegers {
	public static void main(String[] args) throws IOException {
		Scanner keyboard = new Scanner(System.in);

		System.out.printf("Please enter the file name containing a list of integers: ");
		String fileName = keyboard.nextLine();
		File inputFile = new File(fileName);

		if (!inputFile.exists()) {
			System.out.printf("Error: %s not found.\n", fileName);
			System.exit(0);
		}

		Scanner fileReader = new Scanner(inputFile);
		ArrayList<Integer> numbers = new ArrayList<>();

		while (fileReader.hasNextInt()) {
			int num = fileReader.nextInt();
			int index = 0;
			while (index < numbers.size() && numbers.get(index) > num) {
				index++;
			}
			numbers.add(index, num);
		}

		fileReader.close();

		System.out.printf("Output Using Enhanced For:\n");
		for (int number : numbers) {
			System.out.printf("%d\n", number);
		}

		System.out.printf("\nOutput Using The Iterator:\n");
		Iterator<Integer> iter = numbers.iterator();
		while (iter.hasNext()) {
			System.out.printf("%d\n", iter.next());
		}
	}
}