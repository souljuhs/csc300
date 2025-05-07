public class FriendsRecord extends Record
{
    private String friends;

    public FriendsRecord(String name, String phoneNum, int index, String friends)
    {
        super(name, phoneNum, index);
        this.friends = friends;
    }

    public String toString()
    {
        return super.toString() + "\n friends are " + friends + "\n";
    }
}