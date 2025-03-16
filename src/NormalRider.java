public class NormalRider extends Rider implements TicketPrice
{
    private static double totalGate;
    private double ticketPrice;

    public NormalRider() {}

    public NormalRider(int startOnlineTime)
    {
        super(startOnlineTime);
        setTicketPrice();
        setTotalGate();
    }

    @Override
    public void setTicketPrice()
    {
        this.ticketPrice = BASEPRICE;
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