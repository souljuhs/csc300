import java.io.IOException;
import java.util.Scanner;

public class CreateNewUniversity
{
    public static void main(String[] args) throws IOException
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter the University Name: ");
        String univName = input.nextLine();

        University university = new University(univName);

        university.hireAdvisors();
        university.admitStudents();
        university.printUniversityCommunity();
    }
}