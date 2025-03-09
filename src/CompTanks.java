import java.util.Comparator;

class Tank
{
    private int weight;
    private int numOfShells;
    private String tankCategory;

    public Tank(int weight, int numOfShells, String tankCategory)
    {
        this.weight = weight;
        this.numOfShells = numOfShells;
        this.tankCategory = tankCategory;
    }

    public int getWeight()
    {
        return weight;
    }

    public int getNumOfShells()
    {
        return numOfShells;
    }

    public String getTankCategory()
    {
        return tankCategory;
    }
}

class CompTanks implements Comparator<Tank>
{
    @Override
    public int compare(Tank T1, Tank T2)
    {
        if (T1.getNumOfShells() == T2.getNumOfShells())
        {
            if (T1.getWeight() == T2.getWeight())
            {
                return T1.getTankCategory().compareTo(T2.getTankCategory());
            }
            return Integer.compare(T1.getWeight(), T2.getWeight());
        }
        return Integer.compare(T1.getNumOfShells(), T2.getNumOfShells());
    }
}