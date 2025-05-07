public abstract class Record
{
    private String name, phoneNum;
    private int index;

    public Record(String name, String phoneNum, int index)
    {
        this.name = name;
        this.phoneNum = phoneNum;
        this.index = index;
    }

    public String getName() { return name; }
    public String getPhoneNum() { return phoneNum; }
    public int getIndex() { return index; }

    public String toString()
    {
        return "name: " + name + " phone number: " + phoneNum;
    }
}