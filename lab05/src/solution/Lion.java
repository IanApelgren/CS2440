package solution;


public class Lion extends Feline
{
    public Lion(Zoo myZoo, String name)
    {
        super(myZoo, name);
    }
    
    /**
     * makes noise
     */
    public void makeNoise()
    {
        System.out.println("roar...");
    }
    
    /**
     *eats
     */
    public void eat()
    {
        System.out.println("rip with teeth...");
        setHungerLevel(getHungerLevel()-2);
    }


}
