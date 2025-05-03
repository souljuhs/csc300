import java.util.Scanner;
import java.io.PrintStream;
import java.io.FileNotFoundException;

public class ModelNetworkCommsCenter
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the name of the Network Comms Center:");
        String name = sc.nextLine();

        System.out.println("Please enter a seed value as an int:");
        int seed = sc.nextInt();

        System.out.println("Please enter the number of Paths as an int:");
        int numPaths = sc.nextInt();

        System.out.println("Please enter the number of milliseconds to keep Network Comms Center operating for new messages:");
        int duration = sc.nextInt();

        sc.nextLine(); // consume leftover newline

        System.out.println("Please enter the name of the output file for Network Comms Center results:");
        String outputFile = sc.nextLine();

        try
        {
            PrintStream ps = new PrintStream(outputFile);
            System.setOut(ps); 

            NetworkCommsCenter ncc = new NetworkCommsCenter(name, seed);
            ncc.initializeNetworkCommsCenter(numPaths);
            ncc.operateNetworkCommsCenter(duration);
            ncc.generateNetworkCommsCenterResults();

            System.out.println("\nI avow that I did this exam without help from any other person.");

            ps.close();
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Error: Could not write to output file.");
        }

        sc.close();
    }
}