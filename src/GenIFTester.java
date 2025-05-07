import java.util.Scanner;

public class GenIFTester
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        GenericInterface<String> reverse = str -> {
            StringBuilder sb = new StringBuilder(str);
            return sb.reverse().toString();
        };

        for (int i = 0; i < 3; i++)
        {
            System.out.println("Enter a string to be reversed:");
            String original = input.nextLine();
            String reversed = reverse.func(original);
            System.out.println("The entry " + original + " reversed is " + reversed);
        }

        GenericInterface<Integer> factorial = num -> {
            int result = 1;
            for (int i = 2; i <= num; i++)
            {
                result *= i;
            }
            return result;
        };

        for (int i = 0; i < 3; i++)
        {
            System.out.println("Enter an integer to be factorialised:");
            int n = input.nextInt();
            System.out.println("factorial of " + n + " = " + factorial.func(n));
        }
    }
}