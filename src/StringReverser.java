public class StringReverser
{
    public static String reverseString(String str)
    {
        if (str.length() <= 1) { return str; }
        return reverseString(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args)
    {
        String original = "XYZ";
        String reversed = reverseString(original);
        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reversed);
    }
}