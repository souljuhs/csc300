import java.util.function.BiPredicate;

public class BiPredicateTest
{
    public static <T> void resultBi(BiPredicate<T, T> p, T x, T y)
    {
        System.out.println("The BiPredicate is " + p.test(x, y) + " for values " + x + " and " + y);
    }

    public static void main(String[] args)
    {
        BiPredicate<Integer, Integer> biPred = (x, y) -> x > 2;
        BiPredicate<Integer, Integer> be = biPred.and((x, y) -> y < x).negate();

        for (int x = 1; x <= 4; x++)
        {
            for (int y = 1; y <= 4; y++)
            {
                resultBi(be, x, y);
            }
        }
    }
}