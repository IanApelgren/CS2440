package solution;

public class Cat extends Feline implements Pet
{
    public Cat(Zoo myZoo, String name)
    {
        super(myZoo, name);
    }
    public void makeNoise()
    {
        System.out.println("meow...");
    }
    public void eat()
    {
        System.out.println("pick");
        setHungerLevel(getHungerLevel()-3);
    }
    public void play()
    {
        System.out.println("frolic..");
    }
    public void beFriendly()
    {
        System.out.println("purr...");
    }


}
