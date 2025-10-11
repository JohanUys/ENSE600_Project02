package LOGIC;

import java.util.ArrayList;
import java.util.Random;

// Ship parent class
public class Ship
{
    //========== PROPERTIES ==========
    protected String name;
    
    //Ship inherent properties
    protected int price;
    protected int maxSpeed;
    protected int maxHoldSpace;
    protected int guns;
    
    //Ship variable properties
    protected ArrayList<Good> hold = new ArrayList<>();
    
    //========== CONSTRUCTOR ==========
    public Ship(String name)
    {
        this.name = name;
    }
    
    //========== GETTERS AND SETTERS ==========
    public String getName() {return this.name;}
    public int getPrice() {return this.price;}
    public int getMaxSpeed() {return this.maxSpeed;}
    public int getMaxHoldSpace() {return this.maxHoldSpace;}
    public int getGuns() {return this.guns;}
    public ArrayList<Good> getHold() {return this.hold;}
    public void setHold(ArrayList<Good> hold) {this.hold = hold;}
    public void setMaxSpeed(int speed) {this.maxSpeed = speed;}
    
    //========== METHODS ==========
    
    //Used in subclass constructors
    protected void generateShipProperties(int basePrice, int baseMaxSpeed, int baseMaxHoldSize, int baseGuns)
    {
        Random random = new Random();
        
        //Generate semi-random ship properties
        this.price = basePrice += random.nextInt(50); //0-49
        this.maxSpeed = baseMaxSpeed += random.nextInt(6); //0-5
        this.maxHoldSpace = baseMaxHoldSize += random.nextInt(4);//0-3
        this.guns = baseGuns + 2*random.nextInt(11); //0-20 (even only)
    }
    
    //When loading a good onto a ship. Returns true or false if succeeds or fails
    public void load(Good good)
    {
        if(this.hasHoldSpace())
        {
            this.hold.add(good);
        }
    }
    
    //When unloading a good from a ship. 
    public void unload(Good good)
    {
        this.hold.remove(good);
    } 
    
    //check if there is space in the hold. 
    public boolean hasHoldSpace()
    {
        return (this.hold.size() < this.maxHoldSpace);
    }
    
    
    public boolean hasInHold(Good good)
    {
        return (this.hold.contains(good));
    }
    
    // Fills the ship's hold completely with a randomly selected type of good.
    public void fillHoldRandomly()
    {
        Random random = new Random();
        int goodID = random.nextInt(Good.values().length);
        
        for(int i = 0 ; i<this.maxHoldSpace ; i++)
        {
            this.load(Good.values()[goodID]);
        }
    }
}