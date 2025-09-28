package LOGIC.events;

import LOGIC.*;
import LOGIC.ships.*;

import java.util.Random;

public class PirateEvent implements Events
{
    private final Random random = new Random();
    private Ship pirateShip;
    
    @Override 
    public int getWeighting()
    {
        return 20;
    }
    
    @Override
    public void reset()
    {
        pirateShip = generateRandomPirateShip();
        pirateShip.fillHoldRandomly();
    }
    
    @Override
    public String getIntroText()
    {
        return "Captain! There's a warship approaching on the horizon!"
                + "\nLooks to be a " + pirateShip.getGuns() + " gun " + pirateShip.getName() 
                + "\nShe's coming on us fast! About " + pirateShip.getMaxSpeed() + " knots I'd say."
                + "\nWhat should we do?";
    }
    

    @Override
    public String getCardName()
    {
        return "EventPirateCard";
    }
    
    // Weighted random pirate ship generator
    private Ship generateRandomPirateShip() 
    {
        int roll = random.nextInt(100); // 0–99

        if (roll < 40) return new Cutter();            // 40% chance
        else if (roll < 70) return new Frigate();      // 30% chance
        else if (roll < 90) return new SecondRate();   // 20% chance      
        else return new FirstRate();                   // 10% chance
    }
}
