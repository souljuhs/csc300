import java.util.ArrayList;
import java.util.Random;

public class GenericMethodsTest
{
    public static <T> void printArrayList(ArrayList<T> inputAL)
    {
        for (T element : inputAL)
        {
            System.out.printf("%s ", element);
        }
        System.out.printf("\n");
    }

    public static void main(String[] args)
    {
        Random randy = new Random(6);

        ArrayList<Integer> integerAL = new ArrayList<>();
        for (int i = 1; i < 7; i++)
        {
            integerAL.add(randy.nextInt(7, 101));
        }

        ArrayList<Double> doubleAL = new ArrayList<>();
        for (int i = 1; i < 7; i++)
        {
            doubleAL.add(10.0 * randy.nextDouble());
        }

        ArrayList<Character> characterAL = new ArrayList<>();
        for (int i = 1; i < 7; i++)
        {
            characterAL.add((char) randy.nextInt(65, 91));
        }

        System.out.printf("ArrayList integerAL contains: ");
        printArrayList(integerAL);

        System.out.printf("ArrayList doubleAL contains: ");
        printArrayList(doubleAL);

        System.out.printf("ArrayList characterAL contains: ");
        printArrayList(characterAL);
    }
}