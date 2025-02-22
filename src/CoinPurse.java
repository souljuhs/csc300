public class CoinPurse
{
    private int quarters;
    private int dimes;
    private int nickels;
    private int pennies;

    private final double QUARTER_VALUE = 0.25;
    private final double DIME_VALUE = 0.10;
    private final double NICKEL_VALUE = 0.05;
    private final double PENNY_VALUE = 0.01;

    public CoinPurse(int quarters, int dimes, int nickels, int pennies)
    {
        this.quarters = Math.max(quarters, 0);
        this.dimes = Math.max(dimes, 0);
        this.nickels = Math.max(nickels, 0);
        this.pennies = Math.max(pennies, 0);
    }

    public int getQuarters()
    {
        return quarters;
    }

    public int getDimes()
    {
        return dimes;
    }

    public int getNickels()
    {
        return nickels;
    }

    public int getPennies()
    {
        return pennies;
    }

    public void setQuarters(int quarters)
    {
        this.quarters = Math.max(quarters, 0);
    }

    public void setDimes(int dimes)
    {
        this.dimes = Math.max(dimes, 0);
    }

    public void setNickels(int nickels)
    {
        this.nickels = Math.max(nickels, 0);
    }

    public void setPennies(int pennies)
    {
        this.pennies = Math.max(pennies, 0);
    }

    // methods to calculate money from each coin type
    public double moneyFromQuarters()
    {
        return quarters * QUARTER_VALUE;
    }

    public double moneyFromDimes()
    {
        return dimes * DIME_VALUE;
    }

    public double moneyFromNickels()
    {
        return nickels * NICKEL_VALUE;
    }

    public double moneyFromPennies()
    {
        return pennies * PENNY_VALUE;
    }

    // calculate total amount
    public double totalAmount()
    {
        return moneyFromQuarters() + moneyFromDimes() + moneyFromNickels() + moneyFromPennies();
    }

    public String toString()
    {
        return "quarters: " + quarters + " dimes: " + dimes + " nickels: " + nickels + " pennies: " + pennies;
    }

    public boolean equals(CoinPurse other)
    {
        return this.quarters == other.quarters && this.dimes == other.dimes &&
               this.nickels == other.nickels && this.pennies == other.pennies;
    }
}