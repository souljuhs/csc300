public class SportRecord extends Record
{
    private String team;

    public SportRecord(String name, String phoneNum, int index, String team)
    {
        super(name, phoneNum, index);
        this.team = team;
    }

    public String toString()
    {
        return super.toString() + "\n favorite team is the " + team + "\n";
    }
}