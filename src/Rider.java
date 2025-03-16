public abstract class Rider
{
    private int startOnlineTime;
    private int endOnlineTime;
    private int timeOnLine;

    public Rider() {}

    public Rider(int startOnlineTime)
    {
        setStartOnlineTime(startOnlineTime);
    }

    public void setStartOnlineTime(int startOnlineTime)
    {
        this.startOnlineTime = startOnlineTime;
    }

    public void setEndOnlineTime(int endOnlineTime)
    {
        this.endOnlineTime = endOnlineTime;
        this.timeOnLine = endOnlineTime - startOnlineTime;
    }

    public int getStartOnlineTime() { return startOnlineTime; }
    public int getEndOnlineTime() { return endOnlineTime; }
    public int getTimeOnLine() { return timeOnLine; }

    public abstract void setTotalGate();
}