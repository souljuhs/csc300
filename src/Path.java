public class Path
{
    public static int pathIDCounter = 0;

    private int pathIDNumber, totalMessagesProcessedByPath, timeRemainingForCurrentTransmission;
    private Message assignedMessage;

    public Path()
    {
        setPathIDNumber();
    }

    public int getPathIDNumber() { return pathIDNumber; }
    public int getTotalMessagesProcessedByPath() { return totalMessagesProcessedByPath; }
    public int getTimeRemainingForCurrentTransmission() { return timeRemainingForCurrentTransmission; }
    public Message getAssignedMessage() { return assignedMessage; }

    public void setPathIDNumber() { pathIDNumber = ++pathIDCounter; }
    public void setAssignedMessage(Message m) { assignedMessage = m; }

    public Message removeAssignedMessage()
    {
        Message temp = assignedMessage;
        assignedMessage = null;
        totalMessagesProcessedByPath++;
        return temp;
    }

    public void setTimeRemainingForCurrentTransmission(int time) { timeRemainingForCurrentTransmission = time; }
    public void decrementTimeRemainingForCurrentTransmission() { timeRemainingForCurrentTransmission--; }

    public String toString()
    {
        return "Path " + pathIDNumber + " processed " + totalMessagesProcessedByPath + " messages";
    }
}