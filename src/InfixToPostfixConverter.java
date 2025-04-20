import java.io.*;
import java.util.*;

public class InfixToPostfixConverter
{
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter name of the file to read infix expressions from: ");
		String filename = sc.nextLine();
		BufferedReader reader = new BufferedReader(new FileReader(filename));

		String infix;
		while ((infix = reader.readLine()) != null)
		{
			System.out.println("\nThe original infix expression is:");
			System.out.println(infix);
			String postfix = convertToPostfix(infix);
			System.out.println("The expression in postfix notation is:");
			System.out.println(postfix);
		}
		reader.close();
	}

	public static String convertToPostfix(String infix)
	{
		Stack<Character> charStack = new Stack<>();
		StringBuilder postfix = new StringBuilder();
		infix += ')';
		charStack.push('(');

		for (int i = 0; !charStack.isEmpty(); i++)
		{
			char ch = infix.charAt(i);
			if (Character.isDigit(ch))
			{
				postfix.append(ch).append(' ');
			}
			else if (ch == '(')
			{
				charStack.push(ch);
			}
			else if (isOperator(ch))
			{
				while (isOperator(charStack.peek()) && precedence(ch, charStack.peek()))
					postfix.append(charStack.pop()).append(' ');
				charStack.push(ch);
			}
			else if (ch == ')')
			{
				while (charStack.peek() != '(')
					postfix.append(charStack.pop()).append(' ');
				charStack.pop();
			}
		}
		
		return postfix.toString();
	}

	public static boolean isOperator(char c)
	{
		return "+-*/%^".indexOf(c) >= 0;
	}

	public static boolean precedence(char op1, char op2)
	{
		if (op1 == '^') return false;
		else if (op2 == '^') return true;
		else if ("*/%".indexOf(op1) >= 0) return false;
		else if ("*/%".indexOf(op2) >= 0) return true;
		else return false;
	}
}