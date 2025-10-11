package LOGIC;

import java.util.Random;

public class Wind
{
    //========== PROPERTIES ==========
    private Direction direction;
    private int speed;
    private final int maxDirectionChange = 3;
    
    //========== CONSTRUCTOR ==========
    public Wind()
    {
        Random random = new Random();
        
        this.direction = Direction.values()[random.nextInt(Direction.values().length)];
        generateWindSpeed();
    }
    
    //========== GETTERS&SETTERS ==========
    public Direction getDirection() {return this.direction;}
    public int getSpeed() {return this.speed;}
    
    public void setDirection(Direction direction) {this.direction = direction;}
    public void setSpeed(int speed) {this.speed = speed;}
    
    
    //========== METHODS ==========
    private void generateWindSpeed()
    {
        Random random = new Random();
        
        speed = random.nextInt(40) + 1; //1-40 
        
        speed += 10; //10-50 
    }
    
    public void windChange()
    {
        Random random = new Random();
        
        generateWindSpeed();
        
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
