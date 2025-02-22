public class Student extends UniversityMember
{
    private Advisor advisor;
    private String year;
    private int studentNumber;
    private static int IDNUMBER = 1000;

    public Student()
    {
        super();
        year = "unknown";
        setStudentNumber();
    }

    // constructor with name, advisor, and year
    public Student(String memberName, Advisor advisor, String year)
    {
        super(memberName);
        this.advisor = advisor;
        this.year = year;
        setStudentNumber();
    }

    public void setAdvisor(Advisor advisor)
    {
        this.advisor = advisor;
    }

    public void setYear(String year)
    {
        this.year = year;
    }

    // setStudentNumber method
    public void setStudentNumber()
    {
        studentNumber = IDNUMBER++;
    }

    public Advisor getAdvisor()
    {
        return advisor;
    }

    public String getYear()
    {
        return year;
    }

    public int getStudentNumber()
    {
        return studentNumber;
    }

    public String toString()
    {
        return super.toString() + " with ID number " + studentNumber +
               " is in the " + year + " class";
    }

    public boolean equals(Student other)
    {
        return super.equals(other) &&
               this.year.equals(other.year) &&
               this.studentNumber == other.studentNumber;
    }
}
