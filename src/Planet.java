import java.util.Random;

public class Planet
{
    private static Random randyPlanet = new Random(11);

    private String planetName;
    private int planetTons;

    public Planet()
    {
        setPlanetName("unknown");
        setPlanetTons(randyPlanet.nextInt(70000001) + 10000000);
    }

    public Planet(String planetName)
    {
        setPlanetName(planetName);
        setPlanetTons(randyPlanet.nextInt(70000001) + 10000000);
    }

    public void setPlanetName(String planetName)
    {
        this.planetName = planetName;
    }

    public void setPlanetTons(int planetTons)
    {
        this.planetTons = planetTons;
    }

    public String getPlanetName()
    {
        return planetName;
    }

    public int getPlanetTons()
    {
        return planetTons;
    }

    public String toString()
    {
        return "The planet named " + planetName + " weighs " + String.format("%,d", planetTons) + " tons";
    }

    // equals method
    public boolean equals(Planet other)
    {
        return this.planetName.equals(other.planetName) && this.planetTons == other.planetTons;
    }
}
