package solution;

public abstract class Feline extends Animal
{
    public Feline(Zoo myZoo, String name)
    {
        super(myZoo, name);
    }

    public void roam()
    {
        System.out.println("felines like to roam alone...");
        setHungerLevel(getHungerLevel() +1);
    }





}
