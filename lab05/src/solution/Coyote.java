package solution;

public class Coyote extends Canine
{
    public Coyote(Zoo myZoo, String name)
    {
        super(myZoo, name);
    }

    public void makeNoise()
    {
        System.out.println("howl...");
    }

    public void eat()
    {
        System.out.println("gnaws...");
        setHungerLevel(getHungerLevel()-2);
    }


}
