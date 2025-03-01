public class FastRider extends Rider
{
    public FastRider(int ridesTaken, double totalCost)
    {
        super("Fast Rider", ridesTaken, totalCost);
    }

    @Override
    public String getRiderCategory()
    {
        return "Fast Rider";
    }
}