public abstract class Rider
{
    private String riderType;
    private int ridesTaken;
    private double totalCost;

    public Rider(String riderType, int ridesTaken, double totalCost)
    {
        this.riderType = riderType;
        this.ridesTaken = ridesTaken;
        this.totalCost = totalCost;
    }

    public String getRiderType()
    {
        return riderType;
    }

    public int getRidesTaken()
    {
        return ridesTaken;
    }

    public double getTotalCost()
    {
        return totalCost;
    }

    public abstract String getRiderCategory();

    @Override
    public String toString()
    {
        return String.format("%s has taken %d rides, total cost: $%.2f", riderType, ridesTaken, totalCost);
    }
}