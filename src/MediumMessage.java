public class MediumMessage extends Message
{
    private String messageLength;

    public MediumMessage(int arrivalTime)
    {
        super(arrivalTime);
        setMessageLength();
    }

    public void setMessageLength() { messageLength = "Medium"; }
    public String getMessageLength() { return messageLength; }

    public String toString()
    {
        return messageLength + " message with priority " + getPriority() +
               " and ID " + getMessageID() + " waited " + getWaitTime() + " ms";
    }
}