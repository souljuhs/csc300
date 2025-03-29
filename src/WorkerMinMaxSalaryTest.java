import java.util.*;
import java.io.*;

public class WorkerMinMaxSalaryTest
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        ArrayList<Worker> wrks = new ArrayList<Worker>();

        System.out.print("Please enter name of file to read workers from: ");
        String fileName = input.nextLine();

        try
        {
            Scanner fileScanner = new Scanner(new File(fileName));

            while (fileScanner.hasNext())
            {
                int id = fileScanner.nextInt();
                String name = fileScanner.next();
                int salary = fileScanner.nextInt();
                String jobTitle = fileScanner.next();
                wrks.add(new Worker(id, name, salary, jobTitle));
            }

            fileScanner.close();

            Worker min = Collections.min(wrks);
            Worker max = Collections.max(wrks);

            System.out.println("Worker with minimum salary: " + min);
            System.out.println("Worker with maximum salary: " + max);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found.");
        }
    }
}