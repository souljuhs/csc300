import java.util.Comparator;

public class WorkerMultiSortComparator implements Comparator<Worker>
{
    @Override
    public int compare(Worker w1, Worker w2)
    {
        int jobCompare = w1.getJobTitle().compareTo(w2.getJobTitle());

        if (jobCompare == 0)
        {
            int nameLength1 = w1.getName().length();
            int nameLength2 = w2.getName().length();

            if (nameLength1 == nameLength2)
            {
                return w1.getId() - w2.getId();
            }
            else
            {
                return nameLength1 - nameLength2;
            }
        }

        return jobCompare;
    }
}