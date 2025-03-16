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
            costs[i] = (i < newCosts.length) ? newCosts[i] : 0.0;
        }
    }

    @Override
    public double overbudget()
    {
        double totalCost = Arrays.stream(costs).sum();
        return totalCost - getBudget();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof PieceMealVacation)) return false;
        PieceMealVacation other = (PieceMealVacation) obj;
        return Arrays.equals(items, other.items) &&
               Arrays.equals(costs, other.costs);
    }
}