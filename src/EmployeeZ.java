public class EmployeeZ implements Comparable<EmployeeZ>
{
    private String firstName;
    private double salary;

    public EmployeeZ(String firstName, double salary)
    {
        this.firstName = firstName;
        this.salary = salary;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public double getSalary()
    {
        return salary;
    }

    public void setSalary(double salary)
    {
        this.salary = salary;
    }

    @Override
    public int compareTo(EmployeeZ other)
    {
        if (Math.abs(this.salary - other.salary) <= 0.01)
        {
            return 0;
        }
        else if (this.salary > other.salary)
        {
            return -1;
        }
        else
        {
            return 1;
        }
    }
}