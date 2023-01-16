package solution;

import java.util.HashMap;
import java.util.Set;

/**
 * 2440 lab final exam C bag of pixels.
 * @author Ian Apelgren
 * @version 1.0
 */
public class BagOfPixels
{
    private HashMap<Double, Integer> bag;
    
    
    /**
     * no args bag of pixels constructor.
     */
    public BagOfPixels()
    {
        bag = new HashMap<Double, Integer>(10);
        
    }
    
    /**
     * args constructor makes the capacity for bag of pixels.
     * @param cap initial capacity not that it seems to matter
     */
    public BagOfPixels(Integer cap)
    {
        if (cap >= 0)
        {
            bag = new HashMap<Double, Integer>(cap);
        }
        else
        {
            throw new IllegalArgumentException();
        }
        
    }
    
    /**
     * adds an empty key if one does not exist currently.
     * @param keyVal adds a key value
     * @return true if it made a key false if it didnt
     */
    public boolean add(Double keyVal)
    {
        Integer tempVal;
        if (keyVal >= 0.0 && keyVal <= 1.0)
        {
            if (bag.containsKey(keyVal) == false)
            {
                bag.put(keyVal, 1);
                
                return true;
            }
            else
            {
                tempVal = bag.get(keyVal);
                tempVal += 1;
                bag.put(keyVal, tempVal);
                return true;  
            }
        }
        else
        {
            return false;
        }
    }
    
    /**
     * addToMap takes a key and value provided and.
     *  adds them to either a new key or existing one.
     * will return false if the keyVal is invalide 
     * @param keyVal this is the key you want stored
     * @param val this is the number of pixels 
     * @return true if something was done false if nothing happened
     */
    public boolean add(Double keyVal, Integer val)
    {
        Integer tempVal;
        //Makes sure its a legit value for shade
        if (keyVal >= 0.0 && keyVal <= 1.0)
        {
            //if the key is not already in the map
            if (bag.containsKey(keyVal) == false)
            {
                bag.put(keyVal, val);
                
                return true;
            }
            //if the key is in the map adds the new pixels to it
            else
            {
                tempVal = bag.get(keyVal);
                tempVal += val;
                bag.put(keyVal, tempVal);
                return true;
            }
        }
        else 
        {
            return false;
        }
    }
    
    /**
     * takes a key and returns the value associated with it.
     * will return null if there is no key specified
     * @param keyVal the key
     * @return tempVal the number of pixels in specified value
     */
    public Integer getValue(Double keyVal)
    {
        Integer tempVal;
        
        if (bag.containsKey(keyVal))
        {
            tempVal = bag.get(keyVal);
        }
        else
        {
            tempVal = null;
        }
        return tempVal;
    }
    
    /**
     * removes the specified key from the bag.
     * @param key key you want removed
     *  @return boolean true if removed false otherwise
     */
    public boolean remove(Double key)
    {
        if (bag.containsKey(key))
        {
            bag.remove(key);
            
            return true;
        }
        else
        {
            return false;
        }
    }
    /**
     * returns the number of keys in the current bag.
     * @return size of bag
     */
    public int size()
    {
        Set<Double> keys = bag.keySet();
      
        int counter = 0;
        for (Double key: keys)
        {
            if (bag.get(key) != null)
            {
                counter += bag.get(key);
            }
        }
        return counter;
        
    }
    
    /**
     * calulates the average intesity of all pixels.
     * will be somewhere between 0 - 1.
     * @return intensity the calulated intensity of all pixels in
     */
    public Double averageIntensity()
    {
        Set<Double> keys = bag.keySet();
        double intensity;
        double average = 0;
        double tempAverage;
        int counter = 0;
        for (Double key: keys)
        {
            if (bag.get(key) != null)
            {
                tempAverage = key * bag.get(key);
                counter += bag.get(key);
                average += tempAverage;
            }
        }
        if (counter != 0)
        {
            intensity = (average / counter);
            return intensity;
        }
        else
        {
            return (double) 0;
        }
    }
    
    
    /**
     * does the same thing as get value with a stupid name.
     * @param keyVal the key
     * @return tempVal the number of said key
     */
    public int countOccurrences(double keyVal)
    {
        Integer tempVal;
        
        if (bag.containsKey(keyVal))
        {
            tempVal = bag.get(keyVal);
        }
        else
        {
            tempVal = 0;
        }
        return tempVal;  
    }
    
   

}
