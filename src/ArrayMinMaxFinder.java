import java.util.Random;

public class ArrayMinMaxFinder
{
    public static int[] findMinMax(int[] numbers, int left, int right)
    {
        // base case: only one element
        if (left == right)
        {
            return new int[]{numbers[left], numbers[left]};
        }

        // base case: two elements
        if (right - left == 1)
        {
            if (numbers[left] < numbers[right])
            {
                return new int[]{numbers[left], numbers[right]};
            }
            else
            {
                return new int[]{numbers[right], numbers[left]};
            }
        }

        int mid = (left + right) / 2;	// this divides the array into two halves
        int[] leftMinMax = findMinMax(numbers, left, mid);
        int[] rightMinMax = findMinMax(numbers, mid + 1, right);

        int min = Math.min(leftMinMax[0], rightMinMax[0]);
        int max = Math.max(leftMinMax[1], rightMinMax[1]);

        return new int[]{min, max};
    }

    public static void main(String[] args)
    {
        int[] sampleArray = new Random().ints(10, 1, 100).toArray();
        int[] result = findMinMax(sampleArray, 0, sampleArray.length - 1);

        System.out.println("Minimum: " + result[0]);
        System.out.println("Maximum: " + result[1]);
    }
}