import java.util.ArrayList;
import java.util.Random;

public class AmusementPark
{
    private String parkName;
    private int numAttractions;
    private ArrayList<Attraction> attractions;

    public AmusementPark(String parkName, int numAttractions)
    {
        this.parkName = parkName;
        this.numAttractions = numAttractions;
        attractions = new ArrayList<>();
        createAttractions(numAttractions);
    }

    private void createAttractions(int numAttractions)
    {
        Random rand = new Random(9);
        for (int i = 0; i < numAttractions; i++)
        {
            attractions.add(new Attraction(rand.nextInt(22, 36)));
        }
    }

    public void runThePark(int duration)
    {
        Random rand = new Random(6);
        for (int minute = 0; minute < duration; minute++)
        {
            for (Attraction attraction : attractions)
            {
                attraction.processRiders();
            }
        }
    }

    public void printParkStatistics()
    {
        System.out.printf("Statistics for %s:\n", parkName);
        for (Attraction attraction : attractions)
        {
            System.out.println(attraction);
        }
    }
}
