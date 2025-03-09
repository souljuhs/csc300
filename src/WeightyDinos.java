import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

class WeightyDinos
{
    public static void main(String[] args)
    {
        ArrayList<Dinosaur> dinoList = new ArrayList<>();
        Random rand = new Random(4);

        for (int i = 0; i < 12; i++)
        {
            int weight = 50000 + rand.nextInt(150001);
            dinoList.add(new Dinosaur(weight));
        }

        Collections.sort(dinoList);

        System.out.println("Name\tWeight");
        Iterator<Dinosaur> it = dinoList.iterator();
        while (it.hasNext())
        {
            System.out.println(it.next());
        }
    }
}