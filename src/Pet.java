import java.util.*;

public class Pet
{
    public static List<Pet> pets = new ArrayList<>();

    private String name, animal, breed, color;
    private double price;

    public Pet() {}

    public Pet(String name, String animal, String breed, String color, double price)
    {
        setName(name);
        setAnimal(animal);
        setBreed(breed);
        setColor(color);
        setPrice(price);
    }

    public void setName(String name) { this.name = name; }
    public void setAnimal(String animal) { this.animal = animal; }
    public void setBreed(String breed) { this.breed = breed; }
    public void setColor(String color) { this.color = color; }
    public void setPrice(double price) { this.price = price; }

    public String getName() { return name; }
    public String getAnimal() { return animal; }
    public String getBreed() { return breed; }
    public String getColor() { return color; }
    public double getPrice() { return price; }

    public String toString()
    {
        return name + ": a " + color + " " + breed + " " + animal + " purchased for $" + String.format("%.2f", price);
    }

    public boolean equals(Object other)
    {
        if (!(other instanceof Pet)) return false;
        Pet p = (Pet) other;
        return breed.equals(p.breed) && animal.equals(p.animal);
    }
}