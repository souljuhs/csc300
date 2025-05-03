import java.util.Random;

public abstract class Message implements MessageLength
{
    public static int messageIDCounter = 0;
    public static Random randy = new Random(5);

    private int priority, messageCreationTime, startTransmitTime;
    private int transmissionDuration, waitTime, totalTime;
    private String messageID;
    private Path messagePath;

    public Message(int messageCreationTime)
    {
        setPriority();
        setMessageID();
        setMessageCreationTime(messageCreationTime);
    }

    public int getPriority() { return priority; }
    public int getMessageCreationTime() { return messageCreationTime; }
    public int getStartTransmitTime() { return startTransmitTime; }
    public int getTransmissionDuration() { return transmissionDuration; }
    public int getWaitTime() { return waitTime; }
    public int getTotalTime() { return totalTime; }
    public String getMessageID() { return messageID; }
    public int getPathIDNumber() { return messagePath.getPathIDNumber(); }

    public void setMessageCreationTime(int time) { messageCreationTime = time; }
    public void setPriority() { priority = randy.nextInt(1, 46); }
    public void setMessageID() { messageID = "Message " + ++messageIDCounter; }
    public void setMessagePath(Path p) { messagePath = p; }

    public void setStartTransmitTime(int time)
    {
        startTransmitTime = time;
        setWaitTime();
    }

    public void setWaitTime() { waitTime = startTransmitTime - messageCreationTime; }

    public void setTotalTime(int endTime) { totalTime = endTime - messageCreationTime; }

    public void setTransmissionDuration(int duration) { transmissionDuration = duration; }
}