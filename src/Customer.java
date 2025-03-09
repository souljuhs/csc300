import java.util.Objects;

class Customer
{
    private String name;
    private int id;

    public Customer(String name, int id)
    {
        this.name = name;
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public int getId()
    {
        return id;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && name.equalsIgnoreCase(customer.name); 
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name.toLowerCase(), id); 
    }

    @Override
    public String toString()
    {
        return "Customer: " + name + " | ID: " + id;
    }
}