import java.util.Comparator;

class CustomerSortingComparator implements Comparator<Customer>
{
    @Override
    public int compare(Customer c1, Customer c2)
    {
        int nameComparison = c1.getName().compareToIgnoreCase(c2.getName());  
        return (nameComparison != 0) ? nameComparison : Integer.compare(c1.getId(), c2.getId());
    }
}