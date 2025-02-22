import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class SolarSystem
{
    private String solSystemName;
    private Sun sol;
    private ArrayList<Planet> planetList = new ArrayList<>();

    public SolarSystem()
    {
        setSolSystemName("unknown");
        sol = new Sun();
    }

    public SolarSystem(String solSystemName, String sunName)
    {
        setSolSystemName(solSystemName);
        sol = new Sun(sunName);
        createPlanets();
    }

    public void setSolSystemName(String solSystemName)
    {
        this.solSystemName = solSystemName;
    }

    public String getSolSystemName()
    {
        return solSystemName;
    }

    // method to create planets from file
    public void createPlanets()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter file to read in planet list from: ");
        String fileName = input.nextLine();

        File file = new File(fileName);
        if (!file.exists())
        {
            System.out.println("File not found.");
            return;
        }

        try
        {
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine())
            {
                String planetName = fileReader.nextLine();
                Planet planet = new Planet(planetName);
                planetList.add(planet);
            }
            fileReader.close();
        }
        catch (Exception e)
        {
            System.out.println("Error reading file.");
        }
    }

    public int getNumPlanets()
    {
        return planetList.size();
    }

    public Planet getPlanet(int index)
    {
        if (index < 0 || index >= planetList.size())
        {
            System.out.println("Planet doesn't exist");
            return null;
        }
        return planetList.get(index);
    }

    public String toString()
    {
        String output = "The name of this solar system is " + solSystemName + "\n" +
                        sol.toString() + "\n";
        for (Planet planet : planetList)
        {
            output += planet.toString() + "\n";
        }
        return output;
    }
}