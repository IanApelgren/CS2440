package solution;

abstract class Canine extends Animal
{
    public Canine(Zoo myZoo, String name)
    {
        super(myZoo, name);
    }

    public void roam()
    {
        System.out.println("Canines like to roam in packs...");
        setHungerLevel(getHungerLevel()+1);
    }


}
