import java.util.Random;

public class Sun
{
    private String sunName;
    private int sunAge;
    private Random randy = new Random(6);

    public Sun()
    {
        setSunName("unknown");
        setSunAge(randy.nextInt(1000000001) + 1000000000);
    }

    public Sun(String sunName)
    {
        setSunName(sunName);
        setSunAge(randy.nextInt(1000000001) + 1000000000);
    }

    public void setSunName(String sunName)
    {
        this.sunName = sunName;
    }

    public void setSunAge(int sunAge)
    {
        this.sunAge = sunAge;
    }

    public String getSunName()
    {
        return sunName;
    }

    public int getSunAge()
    {
        return sunAge;
    }

    public String toString()
    {
        return "The sun named " + sunName + " is " +
               String.format("%,d", sunAge) + " years old";
    }
}
