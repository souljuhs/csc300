public class UniversityMember
{
    private String memberName;

    public UniversityMember()
    {
        memberName = "unknown";
    }

    public UniversityMember(String memberName)
    {
        this.memberName = memberName;
    }

    public void setMemberName(String memberName)
    {
        this.memberName = memberName;
    }

    public String getMemberName()
    {
        return memberName;
    }

    public String toString()
    {
        return memberName;
    }

    public boolean equals(UniversityMember other)
    {
        return this.memberName.equals(other.memberName);
    }
}