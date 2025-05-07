import java.util.function.Predicate;

public class PredicateMethodsGeneric
{
    public static <T> void result(Predicate<T> p, T arg)
    {
        System.out.println("The Predicate is " + p.test(arg) + " for " + arg);
    }

    public static void main(String[] args)
    {
        Predicate<Integer> p1 = x -> x % 2 == 0;
        Predicate<Integer> p2 = x -> x > 3;

        for (int i = 4; i <= 6; i++)
        {
            result(p1, i);
            result(p2, i);
        }

        Predicate<String> p3 = s -> s.charAt(0) == 'H';
        result(p3, "Hello");
        result(p3, "Goodbye");
    }
}