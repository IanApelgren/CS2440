package solution;

public class Dog extends Canine implements Pet
{
    public Dog(Zoo myZoo, String name)
    {
        super(myZoo, name);
    }

    public void makeNoise()
    {
        System.out.println("woof");
    }
    public void eat()
    {
        System.out.println("slop...");
        setHungerLevel(getHungerLevel()-3);
    }
    public void play()
    {
        System.out.println("bow bow...");
    }
    public void beFriendly()
    {
        System.out.println("pant pant...");
    }


}
