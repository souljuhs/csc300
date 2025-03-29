import java.util.*;

public class SearchNumbers
{
    public static void main(String[] args)
    {
        Random rand = new Random();
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        // Fill the list with 75 random numbers from 10 to 60
        for (int i = 0; i < 75; i++)
        {
            numbers.add(rand.nextInt(51) + 10); // 10 to 60 inclusive
        }

        // Sort the list
        Collections.sort(numbers);

        System.out.println("The sorted ArrayList is " + numbers);

        Scanner input = new Scanner(System.in);
        int query;

        while (true)
        {
            System.out.print("Please enter the value of the query between 10 and 60. Enter negative to exit: ");
            query = input.nextInt();

            if (query < 0)
            {
                break;
            }

            int index = Collections.binarySearch(numbers, query);

            if (index >= 0)
            {
                System.out.println(query + " is found at index " + index);
            }
            else
            {
                System.out.println("The value " + query + " is not found");
            }
        }
    }
}