import java.util.*;
import java.io.PrintWriter;

public class Flight
{
    private String flightName;
    private int seats;
    private int seatsSold;
    private Random randy;
    private LinkedList<Passenger> passBooked = new LinkedList<>();
    private PriorityQueue<Passenger> boardingQueue = new PriorityQueue<>(new PassengerComparator());

    public Flight(String flightName, int seed)
    {
        setFlightName(flightName);
        randy = new Random(seed);
        setSeats();
    }

    public void setFlightName(String fName)
    {
        flightName = fName;
    }

    public void setSeats()
    {
        seats = randy.nextInt(76) + 75; // random between 75 and 150
    }

    public void sellSeats()
    {
        seatsSold = seats / 2 + randy.nextInt(1 + seats / 2);

        for (int i = 0; i < seatsSold; i++)
        {
            int choice = randy.nextInt(5); // 0 to 4
            if (choice == 0)
            {
                passBooked.add(new FirstClassPassenger());
            }
            else
            {
                passBooked.add(new CoachPassenger());
            }
        }
    }

    public void lineUpCall()
    {
        for (Passenger p : passBooked)
        {
            boardingQueue.add(p);
        }
    }

    public void boarding(PrintWriter outputWriter)
    {
        outputWriter.println("The boarding order for Flight " + flightName + " with " + seats + " seats and " + seatsSold + " seats sold is:");

        int count = 0;
        while (!boardingQueue.isEmpty())
        {
            outputWriter.print(boardingQueue.remove() + "\t");

            count++;
            if (count % 3 == 0)
            {
                outputWriter.println();
            }
        }
        outputWriter.println("\n");
    }
}