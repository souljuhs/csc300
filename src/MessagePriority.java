import java.util.Comparator;

public class MessagePriority implements Comparator<Message>
{
    public int compare(Message a, Message b)
    {
        if (a.getClass().equals(b.getClass()))
        {
            if (a.getPriority() == b.getPriority())
                return a.getMessageCreationTime() - b.getMessageCreationTime();
            return a.getPriority() - b.getPriority();
        }

        return -a.getMessageLength().compareTo(b.getMessageLength());
    }
}