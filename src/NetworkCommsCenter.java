import java.util.*;

public class NetworkCommsCenter
{
    private Random randyX;
    private PriorityQueue<Message> msgWaitingQ;
    private ArrayList<Path> pathAvailableList = new ArrayList<>();
    private ArrayList<Path> pathBusyList = new ArrayList<>();
    private ArrayList<Message> processedMessages = new ArrayList<>();
    private String commCenterName;
    private int currentTime;

    public NetworkCommsCenter(String name, int seed)
    {
        commCenterName = name;
        msgWaitingQ = new PriorityQueue<>(new MessagePriority());
        randyX = new Random(seed);
    }

    public void initializeNetworkCommsCenter(int numPaths)
    {
        for (int i = 0; i < numPaths; i++)
        {
            pathAvailableList.add(new Path());
        }

        for (int i = 0; i < 15; i++)
        {
            int randGen = randyX.nextInt(1, 11);
            if (randGen <= 2)
                msgWaitingQ.add(new SmallMessage(currentTime));
            else if (randGen <= 5)
                msgWaitingQ.add(new MediumMessage(currentTime));
            else
                msgWaitingQ.add(new LargeMessage(currentTime));
        }

        currentTime = 1;
    }

    public void operateNetworkCommsCenter(int durationForArrivingMessages)
    {
        int endArrivalsTime = currentTime + durationForArrivingMessages;

        while (processedMessages.size() < Message.messageIDCounter || currentTime < endArrivalsTime)
        {
            Iterator<Path> iter = pathBusyList.iterator();
            while (iter.hasNext())
            {
                Path p = iter.next();
                p.decrementTimeRemainingForCurrentTransmission();
                if (p.getTimeRemainingForCurrentTransmission() == 0)
                {
                    Message m = p.removeAssignedMessage();
                    m.setTotalTime(currentTime);
                    processedMessages.add(m);
                    pathAvailableList.add(p);
                    iter.remove();
                }
            }

            if (!msgWaitingQ.isEmpty() && !pathAvailableList.isEmpty())
            {
                Message m = msgWaitingQ.poll();
                Path p = pathAvailableList.remove(0);
                int duration = Message.randy.nextInt(1, 11);
                m.setStartTransmitTime(currentTime);
                m.setTransmissionDuration(duration);
                m.setMessagePath(p);
                p.setAssignedMessage(m);
                p.setTimeRemainingForCurrentTransmission(duration);
                pathBusyList.add(p);
            }

            if (currentTime < endArrivalsTime)
            {
                int randGen = randyX.nextInt(1, 11);
                if (randGen <= 2)
                    msgWaitingQ.add(new SmallMessage(currentTime));
                else if (randGen <= 5)
                    msgWaitingQ.add(new MediumMessage(currentTime));
                else
                    msgWaitingQ.add(new LargeMessage(currentTime));
            }

            currentTime++;
        }
    }

    public void generateNetworkCommsCenterResults()
    {
        System.out.println(commCenterName + " Network Comms Center\n");

        System.out.println("Summary Data by Path");
        for (Path p : pathAvailableList) { System.out.println(p); }
        for (Path p : pathBusyList) { System.out.println(p); }

        int smallCount = 0, mediumCount = 0, largeCount = 0;
        double smallSum = 0, mediumSum = 0, largeSum = 0;

        System.out.printf("\n%10s %10s %10s %10s %10s %10s %10s %10s %10s\n",
            "MESSAGE ID", "PRIORITY", "PATH ID", "LENGTH", "CREATION", "WAIT", "START", "DURATION", "TOTAL");

        for (Message m : processedMessages)
        {
            System.out.printf("%10s %10d %10d %10s %10d %10d %10d %10d %10d\n",
                m.getMessageID(), m.getPriority(), m.getPathIDNumber(),
                m.getMessageLength(), m.getMessageCreationTime(), m.getWaitTime(),
                m.getStartTransmitTime(), m.getTransmissionDuration(), m.getTotalTime());

            switch (m.getMessageLength())
            {
                case "Small":
                    smallCount++;
                    smallSum += m.getTotalTime();
                    break;
                case "Medium":
                    mediumCount++;
                    mediumSum += m.getTotalTime();
                    break;
                case "Large":
                    largeCount++;
                    largeSum += m.getTotalTime();
                    break;
            }
        }

        int totalCount = smallCount + mediumCount + largeCount;
        double totalSum = smallSum + mediumSum + largeSum;

        System.out.printf("\nThe average total time for %d Small Messages is %.2f milliseconds\n", smallCount, smallSum / smallCount);
        System.out.printf("The average total time for %d Medium Messages is %.2f milliseconds\n", mediumCount, mediumSum / mediumCount);
        System.out.printf("The average total time for %d Large Messages is %.2f milliseconds\n", largeCount, largeSum / largeCount);
        System.out.printf("The average total time for %d Total Messages is %.2f milliseconds\n", totalCount, totalSum / totalCount);
    }
}