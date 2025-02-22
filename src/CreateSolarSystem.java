import java.util.Scanner;

public class CreateSolarSystem
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter the name of the Solar System: ");
        String solarSystemName = input.nextLine();

        System.out.print("Please enter the name of the Sun: ");
        String sunName = input.nextLine();

        SolarSystem solarSystem = new SolarSystem(solarSystemName, sunName);

        System.out.println(solarSystem.toString());

        if (solarSystem.getNumPlanets() > 1)
        {
            Planet firstPlanet = solarSystem.getPlanet(0);
            boolean matchFound = false;

            for (int i = 1; i < solarSystem.getNumPlanets(); i++)
            {
                Planet otherPlanet = solarSystem.getPlanet(i);
                if (firstPlanet.equals(otherPlanet))
                {
                    System.out.println(otherPlanet.toString() + " equals the first planet in the ArrayList");
                    matchFound = true;
                }
            }

            if (!matchFound)
            {
                System.out.println("There is no planet that matches the first planet");
                Planet lastPlanet = solarSystem.getPlanet(solarSystem.getNumPlanets() - 1);
                lastPlanet.setPlanetName(firstPlanet.getPlanetName());
                lastPlanet.setPlanetTons(firstPlanet.getPlanetTons());

                if (firstPlanet.equals(lastPlanet))
                {
                    System.out.println(lastPlanet.toString() + "\nand equals the first planet in the ArrayList");
                }
            }
        }
        else
        {
            System.out.println("There are no planets to compare");
        }
    }
}
