import java.util.concurrent.atomic.AtomicInteger;

class Dinosaur implements Comparable<Dinosaur>
{
    private static AtomicInteger dinoCounter = new AtomicInteger(1);
    private String dinoName;
    private int dinoWeight;

    public Dinosaur()
    {
        this.dinoName = "Barney";
    }

    public Dinosaur(int weight)
    {
        this.dinoWeight = weight;
        this.dinoName = "DINO" + dinoCounter.getAndIncrement();
    }

    public String getDinoName()
    {
        return dinoName;
    }

    public int getDinoWeight()
    {
        return dinoWeight;
    }

    public void setDinoWeight(int weight)
    {
        this.dinoWeight = weight;
    }

    @Override
    public int compareTo(Dinosaur other)
    {
        return Integer.compare(this.dinoWeight, other.dinoWeight);
    }

    @Override
    public String toString()
    {
        return dinoName + "\t" + dinoWeight;
    }
}