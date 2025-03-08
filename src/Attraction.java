import java.util.ArrayList;

public class Attraction
{
    private static int attractionCounter = 0;
    private String attractionID;
    private String name;
    private int fastRiders;
    private int normalRiders;
    private double fastWaitTime;
    private double normalWaitTime;
    private int ratePerMinute;

    public Attraction(int ratePerMinute)
    {
        setRatePerMinute(ratePerMinute);
        setAttractionID();
        this.name = "Attraction " + attractionID; 
        this.fastRiders = 0;
        this.normalRiders = 0;
        this.fastWaitTime = 0.0;
        this.normalWaitTime = 0.0;
    }

    public Attraction(String name, int fastRiders, double fastWaitTime, int normalRiders, double normalWaitTime)
    {
        this.name = name;
        this.fastRiders = fastRiders;
        this.fastWaitTime = fastWaitTime;
        this.normalRiders = normalRiders;
        this.normalWaitTime = normalWaitTime;
    }

    public void setRatePerMinute(int ratePerMinute)
    {
        this.ratePerMinute = ratePerMinute;
    }

    public int getRatePerMinute()
    {
        return ratePerMinute;
    }

    private void setAttractionID()
    {
        attractionCounter++;
        this.attractionID = "RIDE" + attractionCounter;
    }

    public String getAttractionID()
    {
        return attractionID;
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
        return String.format("%s (ID: %s) - Fast Riders: %d (Avg Wait: %.2f min), Normal Riders: %d (Avg Wait: %.2f min), Rate Per Minute: %d",
                name, attractionID, fastRiders, fastWaitTime, normalRiders, normalWaitTime, ratePerMinute);
    }
}