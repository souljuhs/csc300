public class QuadType<F, S, T, U>
{
    private F first;
    private S second;
    private T third;
    private U fourth;

    public QuadType(F first, S second, T third, U fourth)
    {
        setFirst(first);
        setSecond(second);
        setThird(third);
        setFourth(fourth);
    }

    public F getFirst() { return first; }
    public void setFirst(F first) { this.first = first; }

    public S getSecond() { return second; }
    public void setSecond(S second) { this.second = second; }

    public T getThird() { return third; }
    public void setThird(T third) { this.third = third; }

    public U getFourth() { return fourth; }
    public void setFourth(U fourth) { this.fourth = fourth; }

    public String toString()
    {
        return "<" + first + ", " + second + ", " + third + ", " + fourth + ">";
    }
}