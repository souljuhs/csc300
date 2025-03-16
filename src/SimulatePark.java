import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

public class SimulatePark
{
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the name of Amusement Park: ");
        String parkName = scanner.nextLine();

        int numAttractions;
        do
        {
            System.out.print("Please enter the number of attractions (3-10, excluding 7): ");
            numAttractions = scanner.nextInt();
        } while (numAttractions < 3 || numAttractions > 10 || numAttractions == 7);

        AmusementPark park = new AmusementPark(parkName, numAttractions);

        int duration;
        do
        {
            System.out.print("Please enter the duration of the simulation in minutes (>= 60): ");
            duration = scanner.nextInt();
        } while (duration < 60);

        park.runThePark(duration);

        System.out.print("Please enter the name of the output file: ");
        String filename = scanner.next();

        PrintWriter writer = new PrintWriter(filename);
        park.printParkStatistics();
        writer.close();

        scanner.close();
    }
}