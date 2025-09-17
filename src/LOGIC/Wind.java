package LOGIC;

import java.util.Random;

public class Wind
{
    //========== PROPERTIES ==========
    private Direction direction;
    private int speed;
    private final int maxSpeed = 50; 
    private final int maxDirectionChange = 3;
    
    //========== CONSTRUCTOR ==========
    public Wind()
    {
        Random random = new Random();
        
        this.direction = Direction.values()[random.nextInt(Direction.values().length)];
        this.speed = random.nextInt(maxSpeed) + 1; //1-50 knots
    }
    
    //========== GETTERS&SETTERS ==========
    public Direction getDirection() {return this.direction;}
    public int getSpeed() {return this.speed;}
    
    
    //========== METHODS ==========
    public void windChange()
    {
        Random random = new Random();
        
        //set the windspeed from 1-50 knots
        this.speed = random.nextInt(maxSpeed) + 1;
        
        //amount by which the wind direction will change
        int directionChange = random.nextInt(maxDirectionChange);
        
        int newDirectionID;
        int numDirections = 7; //0-7
        
        switch(random.nextInt(1))
        {
            case 0 ->
            {
                //change wind direction clockwise
                newDirectionID = this.direction.getID() + directionChange;
                
                if(newDirectionID > numDirections)
                {
                    this.direction = Direction.values()[newDirectionID - numDirections];
                }
                else this.direction = Direction.values()[newDirectionID];
            }
            
            case 1 ->
            {
                //change wind direction counterclockwise
                newDirectionID = this.direction.getID() - directionChange;
                
                if(newDirectionID < 0)
                {
                    this.direction = Direction.values()[newDirectionID + numDirections];
                }
                else this.direction = Direction.values()[newDirectionID];
            }
        }
    }
}
