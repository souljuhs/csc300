import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Polling
{
	static Scanner keyboard = new Scanner(System.in);
	static Random randy;
	static PrintWriter outputWriter;

	public static void main(String[] args) throws IOException
	{
		System.out.printf("Please enter a seed for Random: ");
		int seed = keyboard.nextInt();
		randy = new Random(seed);
		keyboard.nextLine(); // this fixes InputMismatchException

		System.out.printf("Please enter name of file to read causes from: ");
		String causeFileName = keyboard.nextLine();
		ArrayList<String> causesList = readCauses(causeFileName);

		System.out.printf("Please enter number of users to be polled: ");
		int numPolled = keyboard.nextInt();
		keyboard.nextLine(); // this fixes InputMismatchException

		System.out.printf("Please enter name of file to write poll results to: ");
		String outputFileName = keyboard.nextLine();
		outputWriter = new PrintWriter(new File(outputFileName));

		int[][] pollResults = performSurvey(causesList, numPolled);
		int[] causesSum = calcCausesSums(pollResults);
		double[] averageForCause = calcAverage(causesSum, numPolled);

		reportResults(causesList, pollResults, averageForCause, causesSum);

		outputWriter.close();
		System.out.printf("Polling results saved to %s\n", outputFileName);
	}

	public static ArrayList<String> readCauses(String fileName) throws IOException
	{
		File inputFile = new File(fileName);

		// debug, prints the absolute file path
		System.out.printf("Looking for file at: %s\n", inputFile.getAbsolutePath());

		if (!inputFile.exists())
		{
			System.out.printf("Error: %s not found.\n", fileName);
			System.exit(0);
		}

		Scanner fileReader = new Scanner(inputFile);
		ArrayList<String> causes = new ArrayList<>();

		while (fileReader.hasNextLine())
		{
			causes.add(fileReader.nextLine().trim()); // removes spaces
		}

		fileReader.close();
		return causes;
	}

	public static int[][] performSurvey(ArrayList<String> causesList, int numPolled)
	{
		int[][] polling = new int[causesList.size()][numPolled];

		for (int i = 0; i < numPolled; i++)
		{
			outputWriter.printf("Pollee %d Record\n", i + 1);
			for (int j = 0; j < causesList.size(); j++)
			{
				polling[j][i] = randy.nextInt(1, 11); // ensures a valid range from 1-10
				outputWriter.printf("The ranking for cause %s: is %d%n", causesList.get(j), polling[j][i]);
			}
			outputWriter.println();
		}
		return polling;
	}

	public static int[] calcCausesSums(int[][] pollResults)
	{
		int[] sums = new int[pollResults.length];

		for (int i = 0; i < pollResults.length; i++)
		{
			for (int j = 0; j < pollResults[i].length; j++)
			{
				sums[i] += pollResults[i][j];
			}
		}
		return sums;
	}

	public static double[] calcAverage(int[] causesSum, int numPolled)
	{
		double[] averages = new double[causesSum.length];
		for (int i = 0; i < causesSum.length; i++)
		{
			averages[i] = (double) causesSum[i] / numPolled;
		}
		return averages;
	}

	public static void reportResults(ArrayList<String> causesList, int[][] pollResults, double[] averageForCause, int[] causesSum)
	{
		outputWriter.printf("Polling Results\n");
		outputWriter.printf("Cause         Polled Person Average\n");

		for (int i = 0; i < causesList.size(); i++)
		{
			outputWriter.printf("%-12s", causesList.get(i));
			
			for (int j = 0; j < pollResults[i].length; j++)
			{
				outputWriter.printf("%2d ", pollResults[i][j]);
			}
			
			outputWriter.printf(" %.2f%n", averageForCause[i]);
		}

		int maxIndex = findMaxCause(averageForCause);
		int minIndex = findMinCause(averageForCause);

		outputWriter.printf("The cause %s with an average rating of %.2f is the highest rated cause%n", causesList.get(maxIndex), averageForCause[maxIndex]);
		outputWriter.printf("The cause %s with an average rating of %.2f is the lowest rated cause%n", causesList.get(minIndex), averageForCause[minIndex]);
	}

	public static int findMaxCause(double[] averages)
	{
		int maxIndex = 0;
		for (int i = 1; i < averages.length; i++)
		{
			if (averages[i] > averages[maxIndex])
			{
				maxIndex = i;
			}
		}
		return maxIndex;
	}

	public static int findMinCause(double[] averages)
	{
		int minIndex = 0;
		for (int i = 1; i < averages.length; i++)
		{
			if (averages[i] < averages[minIndex])
			{
				minIndex = i;
			}
		}
		return minIndex;
	}
}