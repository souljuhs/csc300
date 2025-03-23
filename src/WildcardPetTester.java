import java.util.ArrayList;

public class WildcardPetTester
{
    public static void addDog(ArrayList<? super Poodle> list, String name)
    {
        list.add(new Poodle(name));
        System.out.println("Doggie named " + name + " was added");
    }

    public static void deleteDog(ArrayList<? extends Dog> list, String name)
    {
        for (int i = 0; i < list.size(); i++)
        {
            Dog d = list.get(i);
            if (d.getName().equals(name))
            {
                list.remove(i);
                System.out.println("Doggie named " + name + " was removed");
                return;
            }
        }
    }

    public static void printAll(ArrayList<?> list)
    {
        for (Object obj : list)
        {
            System.out.print(obj + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        ArrayList<Pet> petList = new ArrayList<>();
        ArrayList<Poodle> poodleList = new ArrayList<>();

        addDog(petList, "Rover");
        addDog(poodleList, "Fetch");
        addDog(poodleList, "BigBite");
        addDog(poodleList, "BestInShow");

        System.out.println("The list of Pets in the petList:");
        printAll(petList);

        System.out.println("The list of Poodles in the poodleList:");
        printAll(poodleList);

        deleteDog(poodleList, "Fetch");

        System.out.println("The list of Poodles after a deletion of the first Poodle in the list:");
        printAll(poodleList);
    }
}