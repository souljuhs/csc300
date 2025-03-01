import java.util.Arrays;

public class PieceMealVacation extends Vacation
{
    private String[] items;
    private double[] costs;

    public PieceMealVacation(String destination, double budget, String[] items, double[] costs)
    {
        super(destination, budget);
        setItems(items);
        setCosts(costs);
    }

    public void setItems(String[] items)
    {
        this.items = Arrays.copyOf(items, items.length);
    }

    public void setCosts(double[] newCosts)
    {
        costs = new double[items.length];
        for (int i = 0; i < costs.length; i++)
        {
            if (i < newCosts.length)
            {
                costs[i] = newCosts[i];
            }
            else
            {
                costs[i] = 0.0;
            }
        }
    }

    @Override
    public double overbudget()
    {
        double totalCost = 0;
        for (double cost : costs)
        {
            totalCost += cost;
        }
        return totalCost - getBudget();
    }

    @Override
    public String toString()
    {
        StringBuilder result = new StringBuilder();
        result.append(super.toString()).append("\n");

        for (int i = 0; i < items.length; i++)
        {
            result.append(String.format("%s: $%.2f\n", items[i], costs[i]));
        }

        return result.toString();
    }
}