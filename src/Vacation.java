public abstract class Vacation
{
    private String destination;
    private double budget;

    public Vacation(String destination, double budget)
    {
        setDestination(destination);
        setBudget(budget);
    }

    public void setDestination(String destination)
    {
        this.destination = destination;
    }

    public void setBudget(double budget)
    {
        if (budget >= 0)
        {
            this.budget = budget;
        }
        else
        {
            throw new IllegalArgumentException("Budget must be >= 0.0");
        }
    }

    public String getDestination() { return destination; }
    public double getBudget() { return budget; }

    public abstract double overbudget();

    @Override
    public String toString()
    {
        return String.format("Destination: %s; Budget: $%.2f", destination, budget);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (!(obj instanceof Vacation)) return false;
        Vacation other = (Vacation) obj;
        return destination.equalsIgnoreCase(other.destination) && Math.abs(budget - other.budget) < 0.0001;
    }
}