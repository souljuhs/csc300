import java.util.ArrayList;

public class Advisor extends UniversityMember
{
    private String department;
    private ArrayList<Student> advStudentList;

    public Advisor()
    {
        super();
        department = "unknown";
        advStudentList = new ArrayList<>();
    }

    public Advisor(String memberName, String department)
    {
        super(memberName);
        this.department = department;
        advStudentList = new ArrayList<>();
    }

    public void setDepartment(String department)
    {
        this.department = department;
    }

    public String getDepartment()
    {
        return department;
    }

    // add student to advisor list
    public void addStudentToAdvisor(Student student)
    {
        advStudentList.add(student);
    }

    // get student from advisor list
    public Student getStudentFromAdvisorList(int index)
    {
        if (index >= 0 && index < advStudentList.size())
        {
            return advStudentList.get(index);
        }
        else
        {
            return null;
        }
    }

    // get number of students
    public int getNumStudentsInAdvisorList()
    {
        return advStudentList.size();
    }

    public String toString()
    {
        return super.toString() + " of the " + department + " Department";
    }

    public boolean equals(Advisor other)
    {
        return super.equals(other) && this.department.equals(other.department);
    }
}
