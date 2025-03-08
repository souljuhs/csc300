import java.util.ArrayList;
import java.util.Random;

public class AmusementPark
{
    private ArrayList<Attraction> attractions;
    private double totalFastGate;
    private double totalNormalGate;

    public AmusementPark()
    {
        attractions = new ArrayList<>();
        totalFastGate = 0.0;
        totalNormalGate = 0.0;
    }

    public void addAttraction(Attraction attraction)
    {
        attractions.add(attraction);
    }

    public void setTotalFastGate(double totalFastGate)
    {
        this.totalFastGate = totalFastGate;
    }

    public void setTotalNormalGate(double totalNormalGate)
    {
        this.totalNormalGate = totalNormalGate;
    }

    public void createAttractions(int numAttractions)
    {
        Random randy = new Random(9);

        for (int i = 0; i < numAttractions; i++)
        {
            int ratePerMinute = randy.nextInt(25, 45);
            attractions.add(new Attraction(ratePerMinute));
        }
    }

    public void displayParkStats()
    {
        System.out.printf("Amusement Park Statistics:\n");
        System.out.printf("Total Gate for Fast Riders: $%.2f\n", totalFastGate);
        System.out.printf("Total Gate for Normal Riders: $%.2f\n", totalNormalGate);

        System.out.printf("\nAttraction Statistics:\n");
        for (Attraction attraction : attractions)
        {
            System.out.printf("%s\n", attraction);
        }
    }
}