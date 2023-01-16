package solution;

public abstract class Animal
{
    private String name;
    private Zoo zoo;
    private int hungerLevel = 0;

    public Animal(Zoo myZoo, String animalName)
    {
        setName(animalName);
        zoo = myZoo;   
    }

    /**
     *gets hunger level
     *@return hungerLevel
     */
    public int getHungerLevel()
    {
             return hungerLevel;   
    }
    
    /**
     *sets hunger level between 1 and 10
     *@param hunger
     */
    public void setHungerLevel(int hunger)
    {
        if (hungerLevel < 0)
        {
            hungerLevel = 0;
        }
        else if (hungerLevel > 10)
        {
            hungerLevel = 10;
        }
        else
        {
        hungerLevel = hunger;
        }
    }

    /**
     *returns the name of the animal
     *@return name
     */
    public String getName()
    {
        return name;
    }

    /**
     *sets the animals name
     *@param animalName
     */
    public void setName(String animalName)
    {
        name = animalName;
    }

    /**
     *sleeps maxing out hunger
     *
     */
    public void sleep()
    {
        System.out.println("Sleeping...");
        setHungerLevel(10);
    }

    /**
     *roams when called
     */
    public void roam()
    {
        System.out.println("moving around...");
        setHungerLevel(getHungerLevel()+1);
    }

    public abstract void makeNoise();
    
    public abstract void eat();
   
}
