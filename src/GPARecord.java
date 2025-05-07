public class GPARecord extends Record
{
    private String subject;

    public GPARecord(String name, String phoneNum, int index, String subject)
    {
        super(name, phoneNum, index);
        this.subject = subject;
    }

    public String toString()
    {
        return super.toString() + "\n favorite subject is the " + subject + "\n";
    }
}