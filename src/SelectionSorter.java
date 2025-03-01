import java.util.Arrays;

public class SelectionSorter
{
    public static void selectionSort(int[] arr)
    {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++)
        {
            int minIndex = i;

            for (int j = i + 1; j < n; j++)
            {
                if (arr[j] < arr[minIndex])
                {
                    minIndex = j;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args)
    {
        int[] numbers = { 29, 10, 14, 37, 13 };
        System.out.println("Before Sorting: " + Arrays.toString(numbers));

        selectionSort(numbers);

        System.out.println("After Sorting: " + Arrays.toString(numbers));
    }
}