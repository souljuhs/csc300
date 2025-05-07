import java.util.function.Predicate;

public class PredicateStatementImpl
{
    public static <T> void result(Predicate<T> p, T arg)
    {
        System.out.println("The Predicate is " + p.test(arg) + " for value " + arg);
    }

    public static void main(String[] args)
    {
        Predicate<Integer> pr1 = x -> x < 50;
        Predicate<Integer> pr2 = x -> x % 2 == 0;
        Predicate<Integer> pr3 = x -> x > 20;

        Predicate<Integer> pr4 = pr1.or(pr2).negate().and(pr3);

        for (int i = 10; i <= 129; i += 7)
        {
            result(pr4, i);
        }
    }
}