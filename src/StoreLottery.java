import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

class StoreLottery
{
    private ArrayList<Customer> customers = new ArrayList<>();

    public void addCustomers(Scanner inputScanner) throws IOException
    {
        System.out.print("What is the name of your input file of names and IDs: ");
        String filename = inputScanner.nextLine(); 

        Scanner fileScanner = new Scanner(new File(filename));

        while (fileScanner.hasNext())
        {
            String name = fileScanner.next();
            int id = fileScanner.nextInt();
            Customer newCustomer = new Customer(name, id);

            if (customers.contains(newCustomer))
            {
                System.out.println("The customer " + name + " ID " + id + " is a duplicate");
            }
            else
            {
                customers.add(newCustomer);
            }
        }
        fileScanner.close(); 

        Collections.sort(customers, new CustomerSortingComparator());
        printUnduplicatedList(inputScanner);  
    }

    public void printUnduplicatedList(Scanner inputScanner) throws IOException
    {
        System.out.print("What is the name of your output file for the names? ");
        String outputFilename = inputScanner.next().trim();  

        FileWriter writer = new FileWriter(outputFilename);
        Iterator<Customer> it = customers.iterator();

        while (it.hasNext())
        {
            writer.write(it.next().toString() + "\n");
        }
        writer.write("\n");

        for (Customer customer : customers)
        {
            writer.write(customer.toString() + "\n");
        }
        writer.close();

        System.out.println("File '" + outputFilename + "' has been successfully created.");
        pickWinner();
    }

    public void pickWinner()
    {
        if (customers.isEmpty())  
        {
            System.out.println("No customers available for the lottery.");
            return;
        }

        Random rand = new Random();
        Customer winner = customers.get(rand.nextInt(customers.size()));
        System.out.println("The winner and Manager for a Day is " + winner);
    }
}