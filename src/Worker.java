public class Worker implements Comparable<Worker>
{
    private int id;
    private String name;
    private Integer salary;
    private String jobTitle;

    public Worker(int id, String name, Integer salary, String jobTitle)
    {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.jobTitle = jobTitle;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public Integer getSalary()
    {
        return salary;
    }

    public String getJobTitle()
    {
        return jobTitle;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setSalary(Integer salary)
    {
        this.salary = salary;
    }

    public void setJobTitle(String jobTitle)
    {
        this.jobTitle = jobTitle;
    }

    @Override
    public int compareTo(Worker other)
    {
        return this.salary.compareTo(other.salary);
    }

    @Override
    public String toString()
    {
        return "ID: " + id + "  Name: " + name + " Salary: $" + salary + " Job Title: " + jobTitle;
    }
}