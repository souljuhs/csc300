import java.util.*;
import java.io.*;

public class OperateAirline
{
    public static void main(String[] args) throws Exception
    {
        Scanner keyboard = new Scanner(System.in);
        ArrayList<Flight> flightList = new ArrayList<>();

        for (int i = 0; i < 3; i++)
        {
            System.out.print("Please enter the Flight Name: ");
            String flightName = keyboard.nextLine();

            System.out.print("Please enter an integer seed from 1 to 50: ");
            int seed = keyboard.nextInt();
            keyboard.nextLine(); // clear buffer

            flightList.add(new Flight(flightName, seed));
        }

        System.out.print("Please enter the name of the output file: ");
        String outputFileName = keyboard.nextLine();
        PrintWriter writer = new PrintWriter(new File(outputFileName));

        for (Flight f : flightList)
        {
            f.sellSeats();
            f.lineUpCall();
            f.boarding(writer);
            writer.println();
            writer.println();
        }

        writer.close();
        keyboard.close();
    }
}