import java.util.ArrayList;

public class Attraction
{
    private static int attractionCounter = 0;
    private String attractionID;
    private int ratePerMinute;
    private ArrayList<NormalRider> normalLine;
    private ArrayList<FastRider> fastLine;
    private ArrayList<Rider> gotOnRide;

    public Attraction(int ratePerMinute)
    {
        setRatePerMinute(ratePerMinute);
        setAttractionID();
        normalLine = new ArrayList<>();
        fastLine = new ArrayList<>();
        gotOnRide = new ArrayList<>();
    }

    public void setRatePerMinute(int ratePerMinute)
    {
        this.ratePerMinute = ratePerMinute;
    }

    private void setAttractionID()
    {
        attractionCounter++;
        this.attractionID = "RIDE" + attractionCounter;
    }

    public int getRatePerMinute() { return ratePerMinute; }
    public String getAttractionID() { return attractionID; }

    public void addRiderNormalLine(NormalRider rider) { normalLine.add(rider); }
    public void addRiderFastLine(FastRider rider) { fastLine.add(rider); }

    public NormalRider removeRiderNormalLine()
    {
        return normalLine.isEmpty() ? null : normalLine.remove(0);
    }

    public FastRider removeRiderFastLine()
    {
        return fastLine.isEmpty() ? null : fastLine.remove(0);
    }

    public int getAlNormalLineSize() { return normalLine.size(); }
    public int getAlFastLineSize() { return fastLine.size(); }

    public void addGotOnRide(Rider rider) { gotOnRide.add(rider); }
    public Rider getGotOnRide(int i) { return gotOnRide.get(i); }
    public int getAlGotOnRideSize() { return gotOnRide.size(); }

    public void processRiders()
    {
        int toBeProcessed = ratePerMinute;
        while (toBeProcessed > 0 && (!fastLine.isEmpty() || !normalLine.isEmpty()))
        {
            if (!fastLine.isEmpty() && (toBeProcessed % 3 != 0 || normalLine.isEmpty()))
            {
                FastRider rider = removeRiderFastLine();
                rider.setEndOnlineTime(0);
                addGotOnRide(rider);
                toBeProcessed--;
            }
            else if (!normalLine.isEmpty())
            {
                NormalRider rider = removeRiderNormalLine();
                rider.setEndOnlineTime(0);
                addGotOnRide(rider);
                toBeProcessed--;
            }
        }
    }
}