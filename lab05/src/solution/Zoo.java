package solution;
import java.util.ArrayList;

public class Zoo implements AnimalLocation
{
    private String name;
    private double latitude;
    private double longitude;
    private ArrayList<Animal> zooAnimals = new ArrayList<Animal>();
    private int counter = 0;

    public Zoo(String name, double lat, double lon)
    {
       setName(name);
       latitude = lat;
       longitude = lon;
    }

    /**
     *returns the zoos latitude cord
     *@return latitude
     */
    public double getLatitude()
    {
        return latitude;
    }

    /**
     * returns the zoos longitude cord
     *@return longitude
     *
     */
    public double getLongitude()
    {
        return longitude;
    }

    /**
     *gets the name of the zoo
     *@return name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     *setts the name of the zoo
     *@param name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     *returns the counter that ticks up everytime an animal is added
     * @return counter
     */
    public int getNumOfAnimals()
    {
        return counter;
    }

    /**
     * takes an animal and adds it to the zoo
     *@param animal
     */
    public void addAnimal(Animal animal)
    {

        zooAnimals.add(animal);
        counter++;
    }

    /**
     *tests animal for each animal in the zoo
     *
     */
    public void testAnimals()
    {
        System.out.println(getName());
        System.out.println(getLatitude());
        System.out.println(getLongitude());
        System.out.println(getNumOfAnimals());
        for (Animal a : zooAnimals)
        {
            a.sleep();
            a.makeNoise();
            a.eat();
            a.roam();
            if(a instanceof Pet)
            {
                // zooAnimals(i).play();
                 //zooAnimals(i).beFriendly();
            }
        }

    }

    public static void main(String[] args)
    {
        Zoo myZoo = new Zoo("Ian's Zoo", 42.6, 136);
        Animal hippo = new Hippo(myZoo, "Lizzie");
        Animal lion = new Lion(myZoo, "Leroy");
        Animal fCat = new FeralCat(myZoo, "mittens");
        Animal cat = new Cat(myZoo, "Brian");
        Animal dog = new Dog(myZoo, "Callie");
        Animal coyote = new Coyote(myZoo, "Wille");
        Animal wolf = new Wolf(myZoo, "Wolfy");
        Animal wDog = new WildDog(myZoo, "Gizmo");
        myZoo.addAnimal(hippo);
        myZoo.addAnimal(lion);
        myZoo.addAnimal(fCat);
        myZoo.addAnimal(cat);
        myZoo.addAnimal(dog);
        myZoo.addAnimal(coyote);
        myZoo.addAnimal(wolf);
        myZoo.addAnimal(wDog);
        

    }


}   
