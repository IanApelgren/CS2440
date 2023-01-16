package solution;


public class Hippo extends Animal 
{
    public Hippo(Zoo myZoo, String name)
    {
        super(myZoo,name);
    }

    /**
     *makes hippo noise
     */
    public void makeNoise()
    {
        System.out.println("blub...");
    }


    /**
     *hippo eats and decreases hunger
     */
    public void eat()
    {
        System.out.println("slurp...");
        setHungerLevel(getHungerLevel() - 1);
    }


}
