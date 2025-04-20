import java.util.*;

public class PalindromeTest
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 4; i++)
		{
			System.out.print("Enter any string: ");
			String input = sc.nextLine();
			String clean = input.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
			Stack<Character> stack = new Stack<>();

			for (char c : clean.toCharArray())
			{
				stack.push(c);
			}

			StringBuilder reversed = new StringBuilder();
			while (!stack.isEmpty())
			{
				reversed.append(stack.pop());
			}

			if (clean.equals(reversed.toString()))
				System.out.println("The input String is a palindrome.\n");
			else
				System.out.println("The input String is not a palindrome.\n");
		}
	}
}