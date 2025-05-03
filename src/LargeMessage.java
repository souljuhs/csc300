public class LargeMessage extends Message
{
    private String messageLength;

    public LargeMessage(int arrivalTime)
    {
        super(arrivalTime);
        setMessageLength();
    }

    public void setMessageLength() { messageLength = "Large"; }
    public String getMessageLength() { return messageLength; }

    public String toString()
    {
        return messageLength + " message with priority " + getPriority() +
               " and ID " + getMessageID() + " waited " + getWaitTime() + " ms";
    }
}