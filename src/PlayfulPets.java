import java.util.*;

public class PlayfulPets
{
    public static void main(String[] args)
    {
        Pet.pets.add(new Pet("Scruffy", "dog", "poodle", "brown", 895.00));
        Pet.pets.add(new Pet("Meow", "cat", "siamese", "white", 740.25));
        Pet.pets.add(new Pet("Max", "dog", "poodle", "black", 540.50));
        Pet.pets.add(new Pet("Cuddles", "dog", "pug", "black", 1282.75));
        Pet.pets.add(new Pet("HotDog", "dog", "dachsund", "brown", 621.75));
        Pet.pets.add(new Pet("Slider", "snake", "garden", "brown", 320.00));

        PetMatcher breedMatcher = (Pet p) -> {
            List<Pet> match = new ArrayList<>();
            for (Pet pet : Pet.pets)
            {
                if (pet.getBreed().equals(p.getBreed()))
                {
                    match.add(pet);
                }
            }
            return match;
        };

        PetMatcher priceMatcher = new PetMatcher()
        {
            public List<Pet> matchPet(Pet p)
            {
                List<Pet> match = new ArrayList<>();
                for (Pet pet : Pet.pets)
                {
                    if (pet.getPrice() <= p.getPrice())
                    {
                        match.add(pet);
                    }
                }
                return match;
            }

            @Override
            public Pet firstPet(Pet p)
            {
                for (Pet pet : Pet.pets)
                {
                    if (pet.getPrice() <= p.getPrice())
                    {
                        return pet;
                    }
                }
                return null;
            }
        };

        PetMatcher colorMatcher = new PetMatcher()
        {
            public List<Pet> matchPet(Pet p)
            {
                List<Pet> match = new ArrayList<>();
                for (Pet pet : Pet.pets)
                {
                    if (pet.getColor().equals(p.getColor()))
                    {
                        match.add(pet);
                    }
                }
                return match;
            }

            @Override
            public Pet firstPet(Pet p)
            {
                for (Pet pet : Pet.pets)
                {
                    if (pet.getColor().equals(p.getColor()))
                    {
                        return pet;
                    }
                }
                return null;
            }
        };

        matchPetsFromTheList("Poodles", breedMatcher, new Pet(null, "dog", "poodle", null, 0.0));
        matchPetsFromTheList("Pets for $850 or less", priceMatcher, new Pet(null, null, null, null, 850.0));
        matchPetsFromTheList("Pets that are black", colorMatcher, new Pet(null, null, null, "black", 0.0));
    }

    public static void matchPetsFromTheList(String criteria, PetMatcher matcher, Pet myPet)
    {
        System.out.println(criteria + ":");
        Pet first = matcher.firstPet(myPet);
        System.out.println("First: " + (first != null ? first.toString() : "No match"));

        System.out.println("\nAll matches:");
        List<Pet> matches = matcher.matchPet(myPet);
        for (Pet p : matches)
        {
            System.out.println(p);
        }
        System.out.println();
    }
}