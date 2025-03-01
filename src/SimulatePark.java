import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SimulatePark
{
    public static void main(String[] args)
    {
        AmusementPark park = new AmusementPark();

        try
        {
            File file = new File("amusestats.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine().trim();

                if (line.isEmpty() || line.contains("RIDERS") || line.contains("WAIT AVG")) 
                {
                    continue;
                }

                if (line.startsWith("The Total Gate for Fast Riders"))
                {
                    double fastGate = Double.parseDouble(line.split("is ")[1].replace(",", ""));
                    park.setTotalFastGate(fastGate);
                }
                else if (line.startsWith("The Total Gate for Normal Riders"))
                {
                    double normalGate = Double.parseDouble(line.split("is ")[1].replace(",", ""));
                    park.setTotalNormalGate(normalGate);
                }
                else if (line.startsWith("RIDE"))
                {
                    String[] parts = line.split("\\s+");

                    if (parts.length < 5) 
                    {
                        System.out.printf("Skipping malformed line: %s\n", line);
                        continue;
                    }

                    try
                    {
                        String rideName = parts[0];
                        int fastRiders = Integer.parseInt(parts[1]);
                        double fastWait = Double.parseDouble(parts[2]);
                        int normalRiders = Integer.parseInt(parts[3]);
                        double normalWait = Double.parseDouble(parts[4]);

                        int totalRiders = fastRiders + normalRiders;
                        double totalWaitAvg = (fastRiders * fastWait + normalRiders * normalWait) / totalRiders;

                        Attraction attraction = new Attraction(rideName, fastRiders, fastWait, normalRiders, normalWait);
                        park.addAttraction(attraction);
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.printf("Error parsing ride data: %s\n", line);
                    }
                }
            }

            scanner.close();
        }
        catch (IOException e)
        {
            System.out.printf("Error reading amusestats.txt: %s\n", e.getMessage());
        }

        park.displayParkStats();
    }
}