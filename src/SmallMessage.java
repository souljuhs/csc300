public class SmallMessage extends Message
{
    private String messageLength;

    public SmallMessage(int arrivalTime)
    {
        super(arrivalTime);
        setMessageLength();
    }

    public void setMessageLength() { messageLength = "Small"; }
    public String getMessageLength() { return messageLength; }

    public String toString()
    {
        return messageLength + " message with priority " + getPriority() +
               " and ID " + getMessageID() + " waited " + getWaitTime() + " ms";
    }
}