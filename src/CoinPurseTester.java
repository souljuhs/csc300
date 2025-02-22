import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class CoinPurseTester
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the name of the input file: ");
        String fileName = input.nextLine();

        File file = new File(fileName);
        if (!file.exists())
        {
            System.out.println("File not found.");
            return;
        }

        ArrayList<CoinPurse> purseList = new ArrayList<>();

        try
        {
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine())
            {
                int quarters = fileReader.nextInt();
                int dimes = fileReader.nextInt();
                int nickels = fileReader.nextInt();
                int pennies = fileReader.nextInt();

                CoinPurse tempCoinPurse = new CoinPurse(quarters, dimes, nickels, pennies);
                purseList.add(tempCoinPurse);
            }
            fileReader.close();
        }
        catch (Exception e)
        {
            System.out.println("Error reading file.");
            return;
        }

        for (int i = 0; i < purseList.size(); i++)
        {
            CoinPurse purse = purseList.get(i);
            System.out.println("Coin purse " + (i + 1) + " has the following coins and values:");
            System.out.println(purse.toString());
            System.out.printf("Money from quarters is $%.2f\n", purse.moneyFromQuarters());
            System.out.printf("Money from dimes is $%.2f\n", purse.moneyFromDimes());
            System.out.printf("Money from nickels is $%.2f\n", purse.moneyFromNickels());
            System.out.printf("Money from pennies is $%.2f\n", purse.moneyFromPennies());
            System.out.printf("Total money is $%.2f\n\n", purse.totalAmount());
        }

        // compare first purse with others
        CoinPurse firstPurse = purseList.get(0);
        for (int i = 1; i < purseList.size(); i++)
        {
            CoinPurse otherPurse = purseList.get(i);
            if (firstPurse.equals(otherPurse))
            {
                System.out.println("Purse 1 and Purse " + (i + 1) + " are equal");
            }
            else
            {
                System.out.println("Purse 1 and Purse " + (i + 1) + " are not equal");
            }
        }
    }
}
