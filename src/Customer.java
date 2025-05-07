public class Customer
{
    private String name, phoneNum, sport, team, subject, friends;
    private double gpa;
    private int numFriends;

    public Customer(String name, String phoneNum, String sport, String team,
                    double gpa, String subject, int numFriends, String friends)
    {
        this.name = name;
        this.phoneNum = phoneNum;
        this.sport = sport;
        this.team = team;
        this.gpa = gpa;
        this.subject = subject;
        this.numFriends = numFriends;
        this.friends = friends;
    }

    public String getName() { return name; }
    public String getPhoneNum() { return phoneNum; }
    public String getSport() { return sport; }
    public String getTeam() { return team; }
    public double getGpa() { return gpa; }
    public String getSubject() { return subject; }
    public int getNumFriends() { return numFriends; }
    public String getFriends() { return friends; }
}