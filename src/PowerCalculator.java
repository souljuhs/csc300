// Problem 4: Recursive String Reversal
public class PowerCalculator
{
    // Basic power function O(n)
    public static int basicPower(int x, int n)
    {
        if (n == 0) { return 1; }
        return x * basicPower(x, n - 1);
    }

    // Optimized power function O(log n) using divide and conquer
    public static int optimizedPower(int x, int n)
    {
        if (n == 0) { return 1; }
        int half = optimizedPower(x, n / 2);

        if (n % 2 == 0) { return half * half; }
        else { return x * half * half; }
    }

    public static void main(String[] args)
    {
        int base = 2, exponent = 5;
        System.out.println("Basic Power: " + basicPower(base, exponent));
        System.out.println("Optimized Power: " + optimizedPower(base, exponent));
    }
}