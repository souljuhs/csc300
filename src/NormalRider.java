public class NormalRider extends Rider
{
    public NormalRider(int ridesTaken, double totalCost)
    {
        super("Normal Rider", ridesTaken, totalCost);
    }

    @Override
    public String getRiderCategory()
    {
        return "Normal Rider";
    }
}