public class Attraction
{
    private String name;
    private int fastRiders;
    private int normalRiders;
    private double fastWaitTime;
    private double normalWaitTime;

    public Attraction(String name, int fastRiders, double fastWaitTime, int normalRiders, double normalWaitTime)
    {
        this.name = name;
        this.fastRiders = fastRiders;
        this.fastWaitTime = fastWaitTime;
        this.normalRiders = normalRiders;
        this.normalWaitTime = normalWaitTime;
    }

    public String getName()
    {
        return name;
    }

    public int getFastRiders()
    {
        return fastRiders;
    }

    public int getNormalRiders()
    {
        return normalRiders;
    }

    public double getFastWaitTime()
    {
        return fastWaitTime;
    }

    public double getNormalWaitTime()
    {
        return normalWaitTime;
    }

    @Override
    public String toString()
    {
        return String.format("%s: Fast Riders: %d (Avg Wait: %.2f min), Normal Riders: %d (Avg Wait: %.2f min)",
                name, fastRiders, fastWaitTime, normalRiders, normalWaitTime);
    }
}