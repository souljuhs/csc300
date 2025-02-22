import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

public class University
{
    private String univName;
    private ArrayList<Advisor> advList;
    private ArrayList<Student> freshmanStudList;
    private ArrayList<Student> sophomoreStudList;
    private ArrayList<Student> juniorStudList;
    private ArrayList<Student> seniorStudList;
    private Scanner input;

    public University(String univName)
    {
        this.univName = univName;
        advList = new ArrayList<>();
        freshmanStudList = new ArrayList<>();
        sophomoreStudList = new ArrayList<>();
        juniorStudList = new ArrayList<>();
        seniorStudList = new ArrayList<>();
        input = new Scanner(System.in);
    }

    public void hireAdvisors() throws IOException
    {
        System.out.print("Please enter the name of the input file with advisor's name and department: ");
        String fileName = input.nextLine();
        Scanner fileScanner = new Scanner(new File(fileName));

        while (fileScanner.hasNextLine())
        {
            String advisorName = fileScanner.nextLine();
            String department = fileScanner.nextLine();
            advList.add(new Advisor(advisorName, department));
        }
        fileScanner.close();
    }

    public void admitStudents() throws IOException
    {
        System.out.print("Please enter the name of the input file with student's name and year: ");
        String fileName = input.nextLine();
        Scanner fileScanner = new Scanner(new File(fileName));

        int advisorIndex = 0;
        while (fileScanner.hasNextLine())
        {
            String studentName = fileScanner.nextLine();
            String year = fileScanner.nextLine();

            if (year.equals("Freshman") || year.equals("Sophomore") ||
                year.equals("Junior") || year.equals("Senior"))
            {
                Advisor advisor = advList.get(advisorIndex);
                Student student = new Student(studentName, advisor, year);
                advisor.addStudentToAdvisor(student);

                if (year.equals("Freshman"))
                {
                    freshmanStudList.add(student);
                }
                if (year.equals("Sophomore"))
                {
                    sophomoreStudList.add(student);
                }
                if (year.equals("Junior"))
                {
                    juniorStudList.add(student);
                }
                if (year.equals("Senior"))
                {
                    seniorStudList.add(student);
                }

                advisorIndex = (advisorIndex + 1) % advList.size();
            }
            else
            {
                System.out.println(studentName + " has an illegal student year: " +
                                   year + " Rejected entry");
            }
        }
        fileScanner.close();
    }

    public void printUniversityCommunity() throws IOException
    {
        System.out.print("Please enter the name of the output file for the University: ");
        String fileName = input.nextLine();
        PrintWriter output = new PrintWriter(new File(fileName));

        output.println(univName + "'s Community Of Advisors and Their Students");
        for (Advisor advisor : advList)
        {
            output.println("Students advised by " + advisor.toString());
            for (int i = 0; i < advisor.getNumStudentsInAdvisorList(); i++)
            {
                output.println(advisor.getStudentFromAdvisorList(i).toString());
            }
        }

        output.println("\n" + univName + "'s List Of Students By Year");
        
        output.println("FRESHMAN STUDENTS");
        for (Student s : freshmanStudList)
        {
            output.println(s.toString());
        }

        output.println("SOPHOMORE STUDENTS");
        for (Student s : sophomoreStudList)
        {
            output.println(s.toString());
        }

        output.println("JUNIOR STUDENTS");
        for (Student s : juniorStudList)
        {
            output.println(s.toString());
        }

        output.println("SENIOR STUDENTS");
        for (Student s : seniorStudList)
        {
            output.println(s.toString());
        }

        output.close();
    }
}
