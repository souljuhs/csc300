import java.util.*;
import java.io.*;

public class WorkerMultiSortTest
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

            Collections.sort(wrks, new WorkerMultiSortComparator());

            Iterator<Worker> iter = wrks.iterator();

            while (iter.hasNext())
            {
                System.out.println(iter.next());
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found.");
        }
    }
}