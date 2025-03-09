import java.util.Scanner;

public class DecisionTreeExtraCredit 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Is it raining or snowing? (yes/no): ");
        String precipitation = input.next().toLowerCase();

        if (precipitation.equals("yes")) 
        {
            System.out.print("Enter wind speed (km/h): ");
            int windSpeed = input.nextInt();

            if (windSpeed > 50) 
            {
                System.out.println("Stay inside (too windy).");
            } 
            else 
            {
                System.out.println("You can go outside (take an umbrella).");
            }
        } 
        else  // No rain/snow
        { 
            System.out.print("Enter temperature (°C): ");
            int temperature = input.nextInt();

            if (temperature < 5) 
            {
                System.out.print("Enter wind speed (km/h): ");
                int windSpeed = input.nextInt();

                if (windSpeed > 50) 
                {
                    System.out.println("Stay inside (too windy).");
                } 
                else 
                {
                    System.out.println("You can go outside, but wear a jacket.");
                }
            } 
            else 
            {
                System.out.println("You can go outside normally.");
            }
        }

        input.close();
    }
}