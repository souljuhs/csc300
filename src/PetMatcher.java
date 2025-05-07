import java.util.*;

@FunctionalInterface
interface PetMatcher
{
    List<Pet> matchPet(Pet p);

    default Pet firstPet(Pet p)
    {
        int index = Pet.pets.indexOf(p);
        return (index < 0) ? null : Pet.pets.get(index);
    }
}