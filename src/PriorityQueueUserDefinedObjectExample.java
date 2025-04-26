import java.util.*;
import java.io.*;

public class PriorityQueueUserDefinedObjectExample
{
    public static void main(String[] args) throws Exception
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter input file name: ");
        String inputFile = keyboard.nextLine();

        System.out.print("Enter output file name: ");
        String outputFile = keyboard.nextLine();

        Scanner fileReader = new Scanner(new File(inputFile));
        PrintWriter fileWriter = new PrintWriter(new File(outputFile));

        PriorityQueue<EmployeeZ> pq = new PriorityQueue<>();

        while (fileReader.hasNext())
        {
            String name = fileReader.next();
            double salary = fileReader.nextDouble();
            pq.add(new EmployeeZ(name, salary));
        }

        while (!pq.isEmpty())
        {
            EmployeeZ emp = pq.remove();
            fileWriter.printf("%8s %10.2f\n", emp.getFirstName(), emp.getSalary());
        }

        fileReader.close();
        fileWriter.close();
        keyboard.close();
    }
}