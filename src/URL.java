import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class URL
{
	public static void main(String[] args) throws IOException
	{
		Scanner keyboard = new Scanner(System.in);

		System.out.printf("Please enter the input file name: ");
		String inputFileName = keyboard.nextLine();
		File inputFile = new File(inputFileName);

		if (!inputFile.exists())
		{
			System.out.printf("Error: %s not found.\n", inputFileName);
			System.exit(0);
		}

		Scanner fileReader = new Scanner(inputFile);

		System.out.printf("Please enter the output file name: ");
		String outputFileName = keyboard.nextLine();
		PrintWriter outputWriter = new PrintWriter(new File(outputFileName));

		while (fileReader.hasNextLine())
		{
			String url = fileReader.nextLine();
			String siteName = extractName(url);
			outputWriter.printf("%s %s%n", url, siteName);
		}

		fileReader.close();
		outputWriter.close();
		System.out.printf("Processed URLs saved to %s\n", outputFileName);
	}

	public static String extractName(String url)
	{
		int start = url.indexOf("www.") + 4;
		int end = url.lastIndexOf(".com");
		return url.substring(start, end);
	}
}