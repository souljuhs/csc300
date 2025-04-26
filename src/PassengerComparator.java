import java.util.Comparator;

public class PassengerComparator implements Comparator<Passenger>
{
    public int compare(Passenger p1, Passenger p2)
    {
        if (!p1.getTicketClass().equals(p2.getTicketClass()))
        {
            if (p1.getTicketClass().equals("First"))
                return -1;
            else
                return 1;
        }
        else
        {
            return Integer.compare(p1.getTicketNumber(), p2.getTicketNumber());
        }
    }
}