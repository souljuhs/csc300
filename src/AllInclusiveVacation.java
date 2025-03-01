public class AllInclusiveVacation extends Vacation
{
    private String brand;
    private int rating;
    private double price;

    public AllInclusiveVacation(String destination, double budget, String brand, int rating, double price)
    {
        super(destination, budget);
        setBrand(brand);
        setRating(rating);
        setPrice(price);
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public void setRating(int rating)
    {
        if (rating >= 1 && rating <= 5)
        {
            this.rating = rating;
        }
        else
        {
            throw new IllegalArgumentException("Rating must be > 0 and <= 5");
        }
    }

    public void setPrice(double price)
    {
        if (price >= 0.0)
        {
            this.price = price;
        }
        else
        {
            throw new IllegalArgumentException("Price must be >= 0.0");
        }
    }

    @Override
    public double overbudget()
    {
        return price - getBudget();
    }

    @Override
    public String toString()
    {
        return String.format("%s\nBrand: %s; Rating: %d; Price: $%.2f", 
                super.toString(), brand, rating, price);
    }
}