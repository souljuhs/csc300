import java.util.function.BiFunction;
import java.util.function.Function;

public class ChainedOperators
{
    public static void main(String[] args)
    {
        BiFunction<Integer, Integer, Integer> f1 = (x, y) -> 5 * (2 * x + 3 * y);
        Function<Integer, Double> f2 = x -> x / 2.0;

        BiFunction<Integer, Integer, Double> f3 = f1.andThen(f2);

        for (int x = 3; x <= 5; x++)
        {
            for (int y = 5; y <= 8; y++)
            {
                System.out.printf("for the values x = %d and y = %d the result is %.2f\n", x, y, f3.apply(x, y));
            }
        }
    }
}