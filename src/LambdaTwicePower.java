import java.util.Scanner;

interface TwicePower
{
    double twicePower(double b, double p);
}

public class LambdaTwicePower
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        TwicePower e1 = (b, p) -> Math.pow(b, p) * 2;

        System.out.print("Please enter the base as a type double: ");
        double base1 = input.nextDouble();
        System.out.print("Please enter the power as a type double: ");
        double power1 = input.nextDouble();
        System.out.printf("Without using return the value of double the power of %.2f to the %.2f is %.3f\n",
                base1, power1, e1.twicePower(base1, power1));

        TwicePower e2 = (b, p) -> {
            return Math.pow(b, p) * 2;
        };

        System.out.print("Please enter the base as a type double: ");
        double base2 = input.nextDouble();
        System.out.print("Please enter the power as a type double: ");
        double power2 = input.nextDouble();
        System.out.printf("Using return the value of double the power of %.2f to the %.2f is %.3f\n",
                base2, power2, e2.twicePower(base2, power2));
    }
}