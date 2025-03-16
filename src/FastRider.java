public class FastRider extends Rider implements TicketPrice
{
    private static double totalGate;
    private double ticketPrice;

    public FastRider() {}

    public FastRider(int startOnlineTime)
    {
        super(startOnlineTime);
        setTicketPrice();
        setTotalGate();
    }

    @Override
    public void setTicketPrice()
    {
        this.ticketPrice = BASEPRICE * 1.40; // 40% increase
    }

    @Override
    public double getTicketPrice()
    {
        return ticketPrice;
    }

    @Override
    public void setTotalGate()
    {
        totalGate += ticketPrice;
    }
}