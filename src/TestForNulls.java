import java.util.ArrayList;
import java.util.Random;

public class TestForNulls
{
    public static boolean hasNoNulls(ArrayList<?> list)
    {
        for (Object obj : list)
        {
            if (obj == null)
                return false;
        }
        return true;
    }

    public static void main(String[] args)
    {
        Random randy = new Random(5);

        ArrayList<Integer> intArrayL = new ArrayList<>();
        for (int i = 0; i < 9; i++)
        {
            intArrayL.add(randy.nextInt(5, 16));
        }

        if (hasNoNulls(intArrayL))
            System.out.println("It is true that intArrayL has no null value");
        else
            System.out.println("It is false that intArrayL has no null value");

        intArrayL.add(null);

        if (hasNoNulls(intArrayL))
            System.out.println("It is true that intArrayL has no null value");
        else
            System.out.println("It is false that intArrayL has no null value");

        System.out.println(intArrayL);

        ArrayList<String> stringArrayL = new ArrayList<>();
        for (int i = 0; i < 6; i++)
        {
            int num = randy.nextInt(9, 28);
            stringArrayL.add("wxy" + num);
        }

        if (hasNoNulls(stringArrayL))
            System.out.println("It is true that stringArrayL has no null value");
        else
            System.out.println("It is false that stringArrayL has no null value");

        stringArrayL.add(3, null);

        if (hasNoNulls(stringArrayL))
            System.out.println("It is true that stringArrayL has no null value");
        else
            System.out.println("It is false that stringArrayL has no null value");

        System.out.println(stringArrayL);
    }
}