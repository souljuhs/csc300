public class QuadTypeTest
{
    public static void main(String[] args)
    {
        QuadType<Integer, Character, String, Boolean> quad =
            new QuadType<>(1, 'B', "twenty", false);

        System.out.println("Original QuadType: " + quad);

        quad.setFirst(25);
        quad.setSecond('H');
        quad.setThird("fifty");
        quad.setFourth(true);

        System.out.println("Modified QuadType: " + quad);
    }
}