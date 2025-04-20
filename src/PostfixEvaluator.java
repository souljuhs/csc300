import java.io.*;
import java.util.*;

public class PostfixEvaluator
{
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter name of the file to read postfix expressions from: ");
		String filename = sc.nextLine();
		BufferedReader reader = new BufferedReader(new FileReader(filename));

		String line;
		while ((line = reader.readLine()) != null)
		{
			StringBuilder expr = new StringBuilder(line + " )");
			System.out.println("\nThe original postfix expression is:");
			System.out.println(line);
			int result = evaluatePostfixExpression(expr);
			System.out.println("The value of the expression is: " + result);
		}
		reader.close();
	}

	public static int evaluatePostfixExpression(StringBuilder expr)
	{
		Stack<Integer> intStack = new Stack<>();
		for (int i = 0; i < expr.length(); i++)
		{
			char c = expr.charAt(i);
			if (Character.isDigit(c))
			{
				intStack.push(c - '0');
				printStack(intStack);
			}
			else if (isOperator(c))
			{
				int val2 = intStack.pop();
				int val1 = intStack.pop();
				printStack(intStack);
				int result = calculate(val1, val2, c);
				intStack.push(result);
				printStack(intStack);
			}
		}
		return intStack.pop();
	}

	public static int calculate(int op1, int op2, char oper)
	{
		switch (oper)
		{
			case '+': return op1 + op2;
			case '-': return op1 - op2;
			case '*': return op1 * op2;
			case '/': return op1 / op2;
			case '^': return (int)Math.pow(op1, op2);
			case '%': return op1 % op2;
			default: return 0;
		}
	}

	public static void printStack(Stack<Integer> stack)
	{
		System.out.println(stack);
	}

	public static boolean isOperator(char c)
	{
		return "+-*/%^".indexOf(c) >= 0;
	}
}